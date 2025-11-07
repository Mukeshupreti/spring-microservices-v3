package com.example.sonarpractice.library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Library lib = new Library();
        Book b1 = new Book("978-1","Effective Java","Joshua Bloch");
        lib.addBook(b1, 1);
        Member m = new Member("m1","Mukesh");
        Optional<Loan> loan = lib.issueBook("978-1", m);
        System.out.println("Issued: " + loan);
        // simulate overdue
        loan.ifPresent(l -> l.setDueDate(LocalDate.now().minusDays(5)));
        double fine = lib.returnBook(loan.get().getId());
        System.out.println("Fine: " + fine);
    }
}

class Book {
    private final String isbn;
    private final String title;
    private final String author;
    public Book(String isbn,String title,String author){ this.isbn=isbn;this.title=title;this.author=author;}
    public String getIsbn(){ return isbn; }
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
}

class Member {
    private final String id; private final String name;
    public Member(String id,String name){ this.id=id; this.name=name; }
    public String getId(){ return id; }
}

class Loan {
    private final UUID id = UUID.randomUUID();
    private final Book book;
    private final Member member;
    private LocalDate dueDate;
    private LocalDate returned;
    public Loan(Book book, Member member){
        this.book=book; this.member=member; this.dueDate=LocalDate.now().plusDays(14);
    }
    public UUID getId(){ return id; }
    public Book getBook(){ return book; }
    public LocalDate getDueDate(){ return dueDate; }
    public void setDueDate(LocalDate d){ this.dueDate=d; }
    public void returned(){ this.returned=LocalDate.now(); }
}

class Library {
    private final Map<String,Integer> inventory = new HashMap<>();
    private final Map<String,Book> catalog = new HashMap<>();
    private final Map<UUID,Loan> loans = new HashMap<>();
    private final FineCalculator fineCalc = new FineCalculator();
    public void addBook(Book b, int copies){
        catalog.put(b.getIsbn(), b);
        inventory.put(b.getIsbn(), inventory.getOrDefault(b.getIsbn(),0)+copies);
    }
    public Optional<Loan> issueBook(String isbn, Member m){
        Integer c = inventory.getOrDefault(isbn,0);
        if(c<=0) return Optional.empty();
        Book b = catalog.get(isbn);
        Loan loan = new Loan(b,m);
        loans.put(loan.getId(), loan);
        inventory.put(isbn, c-1);
        return Optional.of(loan);
    }
    public double returnBook(UUID loanId){
        Loan loan = loans.remove(loanId);
        if(loan==null) throw new IllegalArgumentException("Loan not found");
        loan.returned();
        // restore copy
        inventory.put(loan.getBook().getIsbn(), inventory.getOrDefault(loan.getBook().getIsbn(),0)+1);
        return fineCalc.calculateFine(loan);
    }
}

class FineCalculator {
    public double calculateFine(Loan loan){
        long days = ChronoUnit.DAYS.between(loan.getDueDate(), LocalDate.now());
        if(days<=0) return 0.0;
        return days * 0.5; // 0.5 EUR per day
    }
}
