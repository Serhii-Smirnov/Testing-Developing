package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\КПИ им. Сикорского\\Тестирование\\Lab5Task5\\task5.txt");
        Scanner in = new Scanner(file);
        TreeSet<String> tmp = new TreeSet<String>();
        while(in.hasNext()){
            tmp.add(in.next().replaceAll("[^A-Za-zА-Яа-я0-9]", "").toLowerCase());
        }

        System.out.println(tmp);

        in.close();
    }
}
