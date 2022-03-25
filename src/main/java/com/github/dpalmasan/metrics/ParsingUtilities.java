package com.github.dpalmasan.metrics;

import java.util.LinkedList;
import java.util.Queue;

import edu.stanford.nlp.trees.Tree;

public class ParsingUtilities {

    /**
     * Based on:
     * https://github.com/skrtbhtngr/corenlp-helper/blob/master/TreeExtended.java
     * 
     * @param tree
     * @return
     */
    public static String treeToDot(Tree tree) {
        String result = "graph  {\n";
        Queue<Tree> q = new LinkedList<>();
        q.add(tree);
        int a, b;
        a = tree.hashCode() * tree.children().hashCode();
        result += " N_" + (a < 0 ? -a % Integer.MAX_VALUE : a) + " [label=\"" + tree.label() + "\"];\n";
        while (!q.isEmpty()) {
            Tree t = q.remove();
            for (Tree child : t.children()) {
                a = t.hashCode() * t.children().hashCode();
                if (child.children().length > 0)
                    b = child.hashCode() * child.children().hashCode();
                else
                    b = child.hashCode() * tree.hashCode();
                result += " N_" + (b < 0 ? -b % Integer.MAX_VALUE : b) + " [label=\"" + child.label() + "\"];\n";
                result += " N_" + (a < 0 ? -a % Integer.MAX_VALUE : a) + " -- " + "N_"
                        + (b < 0 ? -b % Integer.MAX_VALUE : b) + ";\n";
                q.add(child);
            }
        }
        result += "}";
        return result;
    }

    public static ParseTree treeToParseTree(Tree tree) {
        ParseTree root = new ParseTree(tree.label().toString());
        for (Tree child : tree.children()) {
            root.addChildren(treeToParseTree(child));
        }
        return root;
    }
}
