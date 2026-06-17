package com.tss.StremAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class maintest {
    public static void main(String[] args) {
        List<Integer> numberList=new ArrayList<>();
        numberList.add(10);
        numberList.add(11);
        numberList.add(20);
        numberList.add(21);
      Integer evensum= numberList.stream().filter((number)->(number%2==0)).reduce(0,(number1,number2)->number1
      =number2);
        System.out.println(evensum);

        numberList.stream().forEach((number)->System.out.println(number));

//        numberList.stream().map
//        min,max,skipp,limit,count,anymatch,findmtch,distinct

       Optional<Integer> minvalue= numberList.stream().min((number1, number2)->number1.compareTo(number2));

       Optional<Integer> maxvalue= numberList.stream().min((number1, number2)->number1.compareTo(number2));

        List<Integer> limitSize = numberList.stream().limit(2).toList();
        limitSize.forEach(System.out::println);

        numberList.add(10);

        List<Integer>listuniq=numberList.stream().distinct().toList();
        System.out.println(listuniq);

        numberList.stream().skip(1).forEach(System.out::println);

    }
}
