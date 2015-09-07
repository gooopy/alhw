package com.ohs;

/**
 * Created by hyunseok on 9/6/15.
 */
public class Node {
    protected int val;
    protected Node leftChild;
    protected Node rightChild;
    protected Node parent;
    protected int depth;

    public Node(String s) {

        s = s.replaceAll("\\s","");     // remove all blank

        /* read int and assign 'val' */


        /* */
        if(s == "()()") {
            leftChild = null;
            rightChild = null;
        }

    }
}
