package com.tss.mainTest;

import com.tss.Services.fileOperations;
import com.tss.entity.Movies;

import com.tss.Services.MovieSorter;

import java.util.ArrayList;
import java.util.List;

import static com.tss.Validation.ValidationForAll.inputInteger;
import static com.tss.Validation.ValidationForAll.inputString;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------Welcome to Movie System----------------");
        fileOperations fileOps = new fileOperations();
        List<Movies> moviesList = new ArrayList<>();

        boolean temp = true;
        while (temp) {
            System.out.println("\n1.Load movies | 2.Add Movie | 3.Save | 4.Search Movie | 5.Sorting | 6.Exit Menu");
            int choiceMenu = inputInteger();

            switch (choiceMenu) {
                case 1:
                    moviesList = fileOps.loadData();
                    if (moviesList.isEmpty()) {
                        System.out.println("No movies found.");
                    } else {
                        for (Movies movie : moviesList) System.out.println(movie);
                    }
                    break;

                case 2:
                    System.out.println("----------------Enter details Of Movie----------------");
                    System.out.print("Movie ID (Integer): ");
                    int id = inputInteger();
                    System.out.print("Movie Name: ");
                    String name = inputString();
                    System.out.print("Movie Genre: ");
                    String genre = inputString();
                    System.out.print("Movie Year: ");
                    String year = inputString();

                    moviesList.add(new Movies( name, genre, year));
                    break;

                case 3:
                    fileOps.saveDate(moviesList);
                    break;

                case 4:
                    System.out.print("Enter Movie Name to Search: ");
                    String searchName = inputString();
                    fileOps.searchMovieByName(moviesList, searchName);
                    break;

                case 5:
                    boolean shortChoice = true;
                    while (shortChoice) {
                        System.out.println("\n--- Sorting Options ---");
                        System.out.println("1. Id | 2. Name | 3. Year | 4. Exit Sorting");
                        int sortingchoice = inputInteger();

                        switch (sortingchoice) {
                            case 1:
                                moviesList.sort(new MovieSorter.IdComparator());
                                System.out.println("Sorted by ID successfully.");
                                shortChoice = false;
                                break;
                            case 2:
                                moviesList.sort(new MovieSorter.NameComparator());
                                System.out.println("Sorted by Name successfully.");
                                shortChoice = false;
                                break;
                            case 3:
                                moviesList.sort(new MovieSorter.YearComparator());
                                System.out.println("Sorted by Year successfully.");
                                shortChoice = false;
                                break;
                            case 4:
                                shortChoice = false;
                                break;
                            default:
                                System.out.println("Invalid choice for sorting.");
                        }
                    }

                    for (Movies m : moviesList) System.out.println(m);
                    break;

                case 6:
                    temp = false;
                    break;
                default:
                    System.out.println("Invalid Choice...");
            }
        }
    }
}
