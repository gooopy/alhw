package com.ohs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hyunseok on 9/6/15.
 */
public class Node {
    protected int element;
    protected Node left;
    protected Node right;
    protected boolean isLeafNode;
    //protected Node parent;

    public Node(String s) {
        s = s.replaceAll("\\s","");
        // Input String shoud be formal -> "(A (K~) (L~))"

        LinkedList<String> result = new LinkedList<String>();
        Stack<Character> tempStack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<(s.length()-1); i++){
            char temp = s.charAt(i);



            switch(temp) {
                case '(': {
                    if(tempStack.size()==0 && sb.length()!=0) {
                        result.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    tempStack.push('(');
                    break;


                }

                case ')': {
                    tempStack.pop();
                    if(tempStack.size()==0) {
                        sb.append(temp);
                        result.add(sb.toString());
                        sb = new StringBuilder();
                        continue;
                    }
                    break;
                }


            }

            sb.append(temp);

        }

        if(result.size() == 0){
            element = 10000;
            left = null;
            right = null;
            isLeafNode = true;
        } else {
            element = Integer.parseInt(result.get(0));

            if (result.get(1).length() == 2) {
                left = null;
            } else {
                left = new Node(result.get(1));
            }

            if (result.get(2).length() == 2) {
                right = null;
            } else {
                right = new Node(result.get(2));
            }

            if (this.left == null && this.right == null) {
                isLeafNode = true;
            } else {
                isLeafNode = false;
            }
        }

    }

    public int getElement(){
        return element;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }

    public boolean getIsLeafNode(){
        return isLeafNode;
    }



}
