package services;

import CustomExceptions.InvalidISBNException;
import models.Book;

import java.util.Scanner;

public class BookService {
    public Scanner s1  = new Scanner(System.in);
    public Scanner s2  = new Scanner(System.in);

    public BookService() {
    }

    public Book createBook(){
        System.out.println("Book Name: ");
        String name = s2.nextLine();
        System.out.println("quantity: ");
        int quantity = s1.nextInt();
        System.out.println("isbn: ");
        s1  = new Scanner(System.in);
        int isbn = s1.nextInt();

        if(isbn < 0) throw new InvalidISBNException();

        return new Book(name,quantity,isbn);
    }
}
