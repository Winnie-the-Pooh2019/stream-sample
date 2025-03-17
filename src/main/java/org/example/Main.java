package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

/**
 * есть коллекции
 * - List список
 * - Set множество
 * - Map словарь
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();

        Type typeToken = new TypeToken<List<Visitor>>() {}.getType();

        FileReader reader = new FileReader("books.json");
        List<Visitor> visitorList = gson.fromJson(reader, typeToken);

        visitorList.forEach(visitor -> System.out.println(visitor));

//        2

        List<Book> books = visitorList.stream()
                .flatMap(visitor -> visitor.getBooks().stream())
                .toList();

        System.out.println("Total number of favorite books: " + books.size());

        List<Book> uniqueBooks = books.stream()
                .distinct()
                .toList();

        System.out.println("Total number of unique books: " + uniqueBooks.size());

//        3
        uniqueBooks.stream()
                .sorted(Comparator.comparingInt(Book::getPublishingYear))
                .forEach(System.out::println);

    }
}