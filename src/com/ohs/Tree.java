package com.ohs;

/**
 * Created by hyunseok on 9/8/15.
 */
public class Tree {
    protected Node root;
    protected String result;
    protected String finalResult;

    public Tree() { root = null; }
    public Tree(Node _root){
        root = _root;
        finalResult = "-1";
    }

    public void traversal(int n){
        result = "";
        inorder(root,n,0,"0");
    }

    public void inorder(Node iter, int n, int sum, String path){
        if(iter.getLeft() != null){
            inorder(iter.getLeft(), n, sum+iter.getElement(), path+"0");
        }

        if(iter.getIsLeafNode() && (sum+iter.getElement() == n)){
            finalResult = path;
        }

        if(iter.getRight() != null){
            result = result + "1";
            inorder(iter.getRight(), n, sum+iter.getElement(), path+"1");
        }
    }

    public String getFinalResult(){
        return finalResult;
    }
}
