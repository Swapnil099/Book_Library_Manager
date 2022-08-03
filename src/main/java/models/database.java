package models;

import models.Book;
import models.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class database {
    public static ArrayList<Student> studentList;
    public static ArrayList<Book> bookList;
    public static HashMap<Book,Student> libraryData;

    public database() {
        studentList  = new ArrayList<Student>();
        bookList  = new ArrayList<Book>();
        libraryData = new HashMap<Book,Student>();
    }



}
