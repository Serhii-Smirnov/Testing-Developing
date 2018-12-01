package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) throws IOException
    {
        double startTime = System.nanoTime();
        File f1 = new File("task2.txt");
        OutputStream outputStream = new FileOutputStream(f1);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        List<Integer> alfa = new LinkedList<>();
        List<Integer> beta = new LinkedList<>();
        for(int i=0; i<150; i++)
            alfa.add((int) (Math.random() * 200));

        for(int i=0; i<150; i++)
            beta.add(alfa.get(i));

        sort(beta);

        int j=0;
        while (j<135)
        {
            beta.remove(0);
            j++;
        }
        for(int i=0; i<15; i++) {
            System.out.print(beta.get(i) + " ");
            writer.append(beta.get(i).toString()+" ");
        }
        writer.close();
        double timeSpent= System.nanoTime();
        System.out.println();

    }
}
