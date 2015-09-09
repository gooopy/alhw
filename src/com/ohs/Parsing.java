package com.ohs;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by hyunseok on 9/7/15.
 */
public class Parsing {
    public Parsing(){};

    public LinkedList myParsing(String s){
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

        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }



        return result;
    }
}
