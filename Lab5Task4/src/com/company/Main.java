package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i = (int) (Math.random() * 100);
        Scanner in = new Scanner(System.in);
        int j = -1;
        int a = 0;
        int b = 100;
        try
        {
            while (j != i)
            {
                System.out.println("Enter number [" + a + ";" + b + "]");
                j = in.nextInt();
                if ((j <= b) && (j >= a))
                {
                    if (i > j) {
                        System.out.println("More");
                        a = j;
                    } else if (i < j) {
                        System.out.println("Less");
                        b = j;
                    } else System.out.println("Winner");
                } else System.out.println("Wrong! try one more time");
            }
        }
        catch(Exception e){
            System.out.println("Wrong format!");
        }
    }
}
