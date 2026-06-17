package com.tss.StremAPI;

import java.util.*;
import java.util.stream.Stream;

public class StremTask {
    public static void main(String[] args) {
        List<String> students = Arrays.asList(
                "Amit Tiwari",
                "Rahul Sharma",
                "Sneha Patil",
                "Ankit Verma",
                "Ravi Kumar",
                "Amit Tiwari",
                "Pooja Mehta",
                "Neha Singh"
        );
students.stream().forEach(System.out::println);
Long countStudents= students.stream().count();
        System.out.println(countStudents);

        List<String> uniqStudents = students.stream().distinct().toList();
        System.out.println(uniqStudents);

        List<String> shortList=students.stream().sorted((name,name2)->name.compareTo(name2)).toList();
        System.out.println(shortList);

        students.stream().sorted((name,name2)->name2.compareTo(name)).forEach(System.out::println);

        students.stream().filter((name)->name.startsWith("A")).forEach(System.out::println);

        List<String>ansmorethan10=students.stream().filter((name)->name.length()>10).toList();
        System.out.println(ansmorethan10);

       List<String>ansToupper= students.stream().map(String::toUpperCase).toList();
        System.out.println(ansToupper);

        List<String>ansTolower= students.stream().map(String::toLowerCase).toList();
        System.out.println(ansTolower);

        students.stream().forEach((name) -> System.out.println(Arrays.toString(name.split(" "))));

        Long lenghtuniq=students.stream().distinct().count();
        System.out.println(lenghtuniq);

        String longest = students.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("Stream is empty");

        String shortest = students.stream()
                .min(Comparator.comparingInt(String::length))
                .orElse("Stream is empty");

        System.out.println(longest);
        System.out.println(shortest);

    }
}
