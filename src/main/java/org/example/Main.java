package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * есть коллекции
 * - List список
 * - Set множество
 * - Map словарь
 */
public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        String booksJson = "[{\n" +
                "        \"name\": \"The Lord of the Rings\",\n" +
                "        \"author\": \"J.R.R. Tolkien\",\n" +
                "        \"publishingYear\": 1954,\n" +
                "        \"isbn\": \"0395026468\",\n" +
                "        \"publisher\": \"Allen & Unwin\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"To Kill a Mockingbird\",\n" +
                "        \"author\": \"Harper Lee\",\n" +
                "        \"publishingYear\": 1960,\n" +
                "        \"isbn\": \"0446310759\",\n" +
                "        \"publisher\": \"HarperPerennial\"\n" +
                "      }]";

        Type typeToken = new TypeToken<List<Book>>() {}.getType();

        List<Book> bookList = gson.fromJson(booksJson, typeToken);

        bookList.forEach(book -> {
            System.out.println(book.getName());
        });

        Book[] books = gson.fromJson(booksJson, Book[].class);

        for (Book book1 : books) {
            System.out.println(book1.getName());
        }
    }
}