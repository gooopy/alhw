package com.ohs;


import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
         * File I/O stream set-up
         */

        String inputFilePath = "sample.txt";
        String outputFilePath = "output.txt";

        File inFile = new File(inputFilePath);
        FileWriter outFile = new FileWriter(outputFilePath);

        BufferedWriter writeFile = new BufferedWriter(outFile);


        Scanner sc = null;
        try {
            sc = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int caseNum = sc.nextInt();
        sc.nextLine();


        for(int i=0; i<caseNum; i++) {
            int checkNum = sc.nextInt();
            String s = sc.nextLine();

            //Parsing iter = new Parsing();
            //String temp = new String();

            Node root = new Node(s);
            Tree tree = new Tree(root);
            tree.traversal(checkNum);
            System.out.println(tree.getFinalResult());
        }










        writeFile.close();


    }
}
