package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list){
        String Last;
        String first;
        double GPA;
        boolean swapped=false;
        System.out.println(list);
        for (int index = 0; index < list.size(); index++) {
            Last=list.get(index).getLastName();
            first=list.get(index).getFirstName();
            GPA=list.get(index).getGpa();
            for(int j=index; j<list.size(); j++){
                if(j!=index && list.get(j).getLastName().compareToIgnoreCase(Last)<=0){
                    if(list.get(j).getLastName().compareToIgnoreCase(Last)<0){
                        list.add(index,list.remove(j));
                        swapped=true;
                    }else if(list.get(j).getLastName().compareToIgnoreCase(Last)==0){
                        if(list.get(j).getFirstName().compareToIgnoreCase(first)<0){
                            swapped=true;
                            list.add(j,list.remove(index));
                        }else if(list.get(j).getFirstName().compareToIgnoreCase(first)==0){
                            if(list.get(j).getGpa()>GPA){
                            list.add(j,list.remove(index));
                            swapped=true;
                            }
                        }
                    }
                }
            }
            if(swapped){
                System.out.println(swapped);
                index=-1;
                swapped=false;
            }
            System.out.println(list);
        }
        return list;
    }

    public static void main(String[] args) {
                Student s1 = new Student("Abby", "Smith", 96.7);
        Student s2 = new Student("Michelle", "Jones", 98.1);
        Student s3 = new Student("Chase", "Bean", 95.2);
        Student s4 = new Student("Jack", "Clancy", 97.3);
        Student s5 = new Student("Brittany", "Jones", 95.5);
        Student s6 = new Student("Lisa", "Frank", 92.4);
        Student s7 = new Student("Marie", "Angelina", 96.5);
        Student s8 = new Student("Peter", "Frank", 97.9);
        Student s9 = new Student("Lisa", "Frank", 99.5);
        Student s10 = new Student("Dean", "Jones", 93.2);

        ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10));
        ArrayList<Student> expected = new ArrayList<Student>(Arrays.asList(s7,s3,s4,s9,s6,s8,s5,s10,s2,s1));
        Utility.sortStudents(students);
    }
}
