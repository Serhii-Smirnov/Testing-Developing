package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter line");
        Scanner in = new Scanner(System.in);
        String tmp = in.next();
        String pmt ="";
        for (int i=tmp.length(); i>0;i--)
            pmt += tmp.substring(i-1,i);
        System.out.println(pmt);
    }
}
