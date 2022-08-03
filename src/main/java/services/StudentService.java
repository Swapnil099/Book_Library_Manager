package services;

import CustomExceptions.InvalidRollException;
import models.Student;

import java.util.Scanner;

public class StudentService {
    public Scanner s1  = new Scanner(System.in);
    public Scanner s2  = new Scanner(System.in);

    public StudentService() {
    }

    public Student createStudent(){
        System.out.println("Student Name: ");
        String name = s2.nextLine();
        System.out.println("Roll Number: ");
        s1  = new Scanner(System.in);
        int roll = s1.nextInt();
        if(roll < 0 || roll > 1000) throw new InvalidRollException();

        return new Student(name,roll);
    }
}
