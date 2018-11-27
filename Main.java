package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n=1000;
        List<String> list = new LinkedList<>();
        double startTime = System.nanoTime();

        for(int i=0; i<n;i++)
            list.add("obj"+i);
        double timeSpent = (System.nanoTime() - startTime)/n;
        System.out.println("time of add one element to LinkedList " + timeSpent + " msec");

        startTime = System.nanoTime();


        if (list.contains(list.get(n/2)))
        {
            timeSpent = (System.nanoTime() - startTime);
            System.out.println("time of search element at LinkedList " + timeSpent + " msec");
        }

        startTime = System.nanoTime();

        for(int i=n-1; i>=0;i--)
            list.remove(i);
        timeSpent = (System.nanoTime() - startTime)/n;
        System.out.println("time of remove one element from LinkedList " + timeSpent + " msec");
        System.out.println("*****************************************************************");

        ArrayList<String> list1 = new ArrayList<>();
        startTime = System.nanoTime();
        for(int i=0; i<n;i++)
            list1.add("obj#"+i);
        timeSpent = (System.nanoTime() - startTime)/n;
        System.out.println("time of add one element to ArrayList " + timeSpent + " msec");

        startTime = System.nanoTime();

        if (list1.contains(list1.get(n/2)))
        {
            timeSpent = (System.nanoTime() - startTime);
            System.out.println("time of search element at ArrayList " + timeSpent + " msec");
        }

        startTime = System.nanoTime();

        for(int i=n-1; i>=0;i--)
            list1.remove(i);
        timeSpent = (System.nanoTime() - startTime)/n;
        System.out.println("time of remove one element from ArrayList " + timeSpent + " msec");
        System.out.println("*****************************************************************");

        TreeSet list2 = new TreeSet();
        startTime = System.nanoTime();
        for(int i=0; i<n;i++)
            list2.add("obj"+i);
        timeSpent = (System.nanoTime() - startTime)/n;
        System.out.println("time of add one element to TreeSet " + timeSpent + " msec");

        startTime = System.nanoTime();

        if (list2.contains("obj"+(int)(n/2)))
        {
            timeSpent = (System.nanoTime() - startTime);
            System.out.println("time of search element at TreeSet " + timeSpent + " msec");
        }


        startTime = System.nanoTime();
        for(int i=0;i<n;i++)
            list2.remove("obj"+i);
        timeSpent = (System.nanoTime() - startTime)/n;
        System.out.println("time of remove one element from TreeSet " + timeSpent + " msec");
        System.out.println("*****************************************************************");


        HashSet list3 = new HashSet();
        startTime = System.nanoTime();
        for(int i=0; i<n;i++)
            list3.add("obj#"+i);
        timeSpent = (System.nanoTime() - startTime)/n;
        System.out.println("time of add one element to HashSet " + timeSpent + " msec");

        startTime = System.nanoTime();

        if (list3.contains("obj#"+(int)(n/2)))
        {
            timeSpent = (System.nanoTime() - startTime);
            System.out.println("time of search element at HashSet " + timeSpent + " msec");
        }

        startTime = System.nanoTime();

        for(int i=n-1; i>=0;i--)
            list3.remove(i);
        timeSpent = (System.nanoTime() - startTime)/n;
        System.out.println("time of remove one element from HashSet " + timeSpent + " msec");
    }
}
