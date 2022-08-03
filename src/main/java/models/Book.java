package models;

public class Book {
    String name;
    int quantity;
    int isbn;

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Book(String name, int quantity, int isbn) {
        this.name = name;
        this.quantity = quantity;
        this.isbn = isbn;
    }


    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }


    public int getIsbn() {
        return isbn;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", isbn=" + isbn +
                '}';
    }
}
