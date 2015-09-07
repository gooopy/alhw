package com.ohs;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hyunseok on 9/7/15.
 */
public class Parsing {
    public Parsing(){};

    public boolean myParsing(String s){
        s = s.replaceAll("\\s","");

        int cnt1 =0;
        int cnt2 =0;


        StringBuilder sb1 = new StringBuilder();
        int val = 0;
        String str1 = new String();
        String str2 = new String();
        boolean tog1 = true;
        boolean tog2 = true;

        Queue<Character> q = new LinkedList<Character>();


        for(int i=1; i<s.length(); i++){
            if((s.charAt(i) != '(') && tog1){
                sb1.append(s.charAt(i));
            } else if ((s.charAt(i) == '(') && tog1) {
                //q.add(s.charAt(i));
                tog1 = !tog1;
                val = Integer.parseInt(sb1.toString());
                sb1 = new StringBuilder();
                sb1.append(s.charAt(i));
                cnt1++;
                continue;
            }

            if(!tog1 && tog2) {
                if(s.charAt(i) == '(') cnt1++;
                else if(s.charAt(i) == ')') cnt2++;

                //q.add(s.charAt(i));
                sb1.append(s.charAt(i));

                if(cnt1 == cnt2) {
                    if(tog2){
                        str1 = sb1.toString();
                        tog2 = !tog2;
                        cnt1 = 0;
                        cnt2 = 0;
                    } else {
                        str2 = sb1.toString();
                        break;
                    }
                    sb1 = new StringBuilder();

                }
            }

        }

        /* format
        *  (
        *  int
        *  ( <- this is the first
        */

        /*for(int i=1; i<s.length()+1; i++){



            if(cnt1!=0 && cnt1==cnt2 && toggle){
                str1 = sb1.toString();
                sb1 = new StringBuilder();
                toggle = !toggle;
                cnt1 = 0;
                cnt2 = 0;
            }

            if(cnt1!=0 && cnt1==cnt2 && !toggle){
                str2 = sb1.toString();
            }

            if(i < s.length()) {
                if (s.charAt(i) == '(') {
                    cnt1++;
                } else if (s.charAt(i) == ')') {
                    cnt2++;

                }


                sb1.append(s.charAt(i));
            }

        }*/

        System.out.println(val);
        System.out.println(s);
        System.out.println(str1);
        System.out.println(str2);

        return false;
    }
}
