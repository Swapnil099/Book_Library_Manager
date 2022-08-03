package services;

import CustomExceptions.InvalidISBNException;
import CustomExceptions.InvalidRollException;
import models.Student;
import models.database;
import models.Book;
import services.StudentService;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class databaseServices {
    public database db = new database();
    public StudentService studentService = new StudentService();

    public BookService bookService = new BookService();
    public Scanner s1  = new Scanner(System.in);
    public Scanner s2  = new Scanner(System.in);

    public databaseServices() {
    }

    public void addStudent(){
        System.out.println("----------------------------");
        Student newStudent = null;
        try{
            newStudent = studentService.createStudent();
            db.studentList.add(newStudent);
            System.out.println("Student is Added");
        }
        catch (InvalidRollException e){
            e.printStackTrace();
            System.out.println("failed to create student");
        }
        catch (InputMismatchException e){
            e.printStackTrace();
            System.out.println("Please enter valid input data");
        }

        System.out.println("----------------------------");
    }

    public void addBook(){
        System.out.println("----------------------------");
        Book newBook = null;
        try{
             newBook = bookService.createBook();
             db.bookList.add(newBook);
             System.out.println("Book is Added");
        }
        catch (InvalidISBNException e){
            e.printStackTrace();
            System.out.println("Failed to create Book");
        }
        catch (InputMismatchException e){
            e.printStackTrace();
            System.out.println("Please enter valid input data");
        }

        System.out.println("----------------------------");
    }

    public void searchBookByISBN(){
        System.out.println("----------------------------");
        System.out.println("Enter Book ISBN number: ");
        int isbn;

        try{
            isbn = s1.nextInt();
            for(Book b:db.bookList) {
                if(b.getIsbn() == isbn) {
                    System.out.println("Book Found");
                    System.out.println(b);
                    System.out.println("----------------------------");
                    return;
                }
            }
            System.out.println("Book Not Found");
        }
        catch (InputMismatchException e){
            e.printStackTrace();
            System.out.println("Please enter valid ISBN Number");
        }

        System.out.println("----------------------------");

    }

    public void searchStudentByRoll(){
        System.out.println("----------------------------");
        System.out.println("Enter Student Roll number: ");
        int roll;

        try{
            roll = s1.nextInt();
            for(Student s:db.studentList) {
                if(s.getRoll() == roll) {
                    System.out.println("Student Found");
                    System.out.println(s);
                    System.out.println("----------------------------");
                    return;
                }
            }

            System.out.println("Student with Roll "+roll+" Not Found");
        }
        catch (InputMismatchException e){
            e.printStackTrace();
            System.out.println("Please Enter Valid Interger Roll Number");
        }

        System.out.println("----------------------------");
    }

    public void updateBookByISBN(){
        System.out.println("----------------------------");
        System.out.println("Enter Book ISBN number: ");
        int isbn = s1.nextInt();

        for(Book b:db.bookList) {
            if(b.getIsbn() == isbn) {
                System.out.println("Book Found! Enter Updated Info");

                System.out.println("Updated Book Name: (put blank to keep unchanged)");
                String name = s2.nextLine();
                if(name.length() > 0) b.setName(name);

                System.out.println("Updated quantity: (put zero to keep unchanged)");
                int quantity = s1.nextInt();
                if(quantity > 0) b.setQuantity(quantity);

                System.out.println("Updated isbn: (put zero to keep unchanged)");
                int newisbn = s1.nextInt();
                if(newisbn > 0) b.setIsbn(newisbn);

                System.out.println("Info updated, New Book Info is "+ b);
                System.out.println("----------------------------");
                return;
            }
        }
        System.out.println("Book with isbn : "+ isbn + " Not Found");
        System.out.println("----------------------------");

    }

    public void issueBookByISBN(){
        System.out.println("----------------------------");
        System.out.println("Enter ISBN number : ");
        int isbn = s1.nextInt();
        System.out.println("Enter Roll Number : ");
        int roll = s1.nextInt();

        Student issuer = new Student();
        boolean studentFound = false;
        for(Student s:db.studentList) {
            if(s.getRoll() == roll) {
                issuer = s;
                studentFound = true;
                break;
            }
        }

        if(!studentFound) {
            System.out.println("Student with Roll : "+roll+" is Not Found");
            System.out.println("----------------------------");
            return;
        }

        for(Book b:db.bookList){
            if(b.getIsbn() == isbn){
                if(b.getQuantity() > 0) {
                    b.setQuantity(b.getQuantity() - 1);
                    db.libraryData.put(b, issuer);
                    System.out.println("Book Issued Successfully");
                    System.out.println("----------------------------");
                    return;
                }
                System.out.println("Book is currently out of stock");
                System.out.println("----------------------------");
                return;
            }
            System.out.println("Book with isbn : " + isbn +" is Not Found");
            System.out.println("----------------------------");
            return;
        }
    }

    public void showEntries(){
        System.out.println("----------------------------");
        for(Map.Entry<Book,Student> data:db.libraryData.entrySet()){
            System.out.println(data.getKey() + " -> " + data.getValue());
        }
        System.out.println("----------------------------");
    }

    public void printStudent(){
        System.out.println("---------------------------");
        for(Student s:db.studentList) System.out.println(s.toString());
        System.out.println("----------------------------");
    }

    public void printBook(){
        System.out.println("---------------------------");
        for(Book b:db.bookList) System.out.println(b.toString());
        System.out.println("----------------------------");
    }


}
