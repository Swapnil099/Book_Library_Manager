package services;

import java.util.Scanner;

public class StartApp {
    databaseServices dbService = new databaseServices();

    public void start(){
        Scanner s1 = new Scanner(System.in);
        int select = 0;

        do{
            System.out.println("1: Add New Student");
            System.out.println("2: Add New Book");
            System.out.println("3: Search Student by Roll");
            System.out.println("4: Search Book by ISBN");
            System.out.println("5: Update Book");
            System.out.println("6: Issue Book");
            System.out.println("7: Display Entries");
            System.out.println("8: Display Student");
            System.out.println("9: Display Book");

            select = s1.nextInt();
            switch (select){
                case 1:
                    dbService.addStudent();
                    break;
                case 2:
                    dbService.addBook();
                    break;
                case 3:
                    dbService.searchStudentByRoll();
                    break;
                case 4:
                    dbService.searchBookByISBN();
                    break;
                case 5:
                    dbService.updateBookByISBN();
                    break;
                case 6:
                    dbService.issueBookByISBN();
                    break;
                case 7:
                    dbService.showEntries();
                    break;
                case 8:
                    dbService.printStudent();
                    break;
                case 9:
                    dbService.printBook();
                    break;
            }
        }
        while(select != 0);
    }
}
