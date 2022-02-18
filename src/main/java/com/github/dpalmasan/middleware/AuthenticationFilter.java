package com.github.dpalmasan.middleware;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.dpalmasan.auth.Auth.TokenRequest;
import com.github.dpalmasan.auth.AuthServiceGrpc.AuthServiceBlockingStub;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @GrpcClient("authService")
    private AuthServiceBlockingStub authServiceStub;

    private boolean validateAuthToken(String token) {
        TokenRequest request = TokenRequest.newBuilder().setToken(token).build();
        try {
            return authServiceStub.validateToken(request).getSuccess();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String token = WebUtils.getCookie(request, "access_token").getValue();
        if (!validateAuthToken(token)) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
            return;
        }
        filterChain.doFilter(request, response);
    }
}