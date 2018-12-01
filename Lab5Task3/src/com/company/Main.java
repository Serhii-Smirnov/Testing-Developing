package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Main {

    public static void main(String[] args){

        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new HourWork("Maryna",50000));
        people.add(new HourWork("Masha",200));
        people.add(new HourWork("Regina",1000000));
        people.add(new FixedWork("Anya",4000));
        people.add(new FixedWork("Denys",34567));
        people.add(new FixedWork("Vasilevs",5777));
        people.add(new HourWork("Sergerius",500000000));

        people.sort(Person.ComparatorPerson);

        for (Person p : people) {
            System.out.println(p);
        }


        if (people.size()>=5)
            for(int i =0; i<5;i++){
                System.out.println(people.get(i).GetName());
            }

        if(people.size()>=3)
            for(int i = people.size()-3; i<people.size(); i++){
                System.out.println(people.get(i).GetPersonId());
            }

        saveToFile(people,"task3.txt");
    }

    public static void saveToFile(Collection<Person> collection, String fileName){
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Person p : collection) {
                String lineForWriting = p.toString();
                writer.write(lineForWriting + System.getProperty("line.separator"));
            }
            writer.close();
        }catch (IOException e){
            System.out.println("Error with save");
        }
    }
}

abstract class Person{

    public static int id;
    protected int personID;
    protected String name;
    protected double salary;

    abstract double SalaryForMonth();
    public double GetSalary(){return salary;}
    public String GetName() {return name;}
    public static int GetId() {return id++;}
    public int GetPersonId() {return personID;}

    public int compareTo(Person compare) {

        double CompareSalary = ((Person) compare).GetSalary();
        if(this.salary != CompareSalary) {
            return (int)(this.salary - CompareSalary);
        }
        else {
            return compare.GetName().compareTo(this.name);
        }


    }

    public static Comparator<Person> ComparatorPerson = new Comparator<Person>() {
        public int compare(Person p1, Person p2)
        {
            return p2.compareTo(p1);
        }
    };

}

class HourWork extends Person{

    private double SalForHour;

    public HourWork(String name, double SalForHour){
        this.name=name;
        this.SalForHour=SalForHour;
        salary=SalaryForMonth();
        personID=Person.GetId();

    }

    @Override
    double SalaryForMonth(){
        return 20.8*8*SalForHour;
    }

    @Override
    public String toString() {
        return "NAME: "+name+" \n"+"ID: "+personID+" \n"+"Salary per hour: "+SalForHour+" \n"+"TOTAL salary: "+salary;
    }

    public double GetSalForHour() {
        return SalForHour;
    }
}

class FixedWork extends Person{

    private double SalFix;

    public FixedWork(String name, double SalFix){
        this.name=name;
        this.SalFix=SalFix;
        salary=SalaryForMonth();
        personID=Person.GetId();

    }

    @Override
    double SalaryForMonth(){
        return SalFix;
    }

    @Override
    public String toString() {
        return "NAME: "+name+" \n"+"ID: "+personID+" \n"+"TOTAL salary: "+salary;
    }

    public double GetFixSal() {
        return SalFix;
    }
}