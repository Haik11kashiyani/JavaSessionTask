package com.tss.Services;

import com.tss.entity.Movies;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileOperations {
    private final String filename = "movie.ser";


    public void saveDate(List<Movies> moviesList) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(moviesList);
            System.out.println("Data successfully saved to " + filename);

        } catch (IOException e) {
            System.out.println("Error saving movie data: " + e.getMessage());
        }
    }



    public List<Movies> loadData() {
        File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            return (List<Movies>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading movie data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    public void searchMovieByName(List<Movies> moviesList, String searchName) {
        boolean found = false;
        for (Movies movie : moviesList) {
            if (movie.getMovieName().equalsIgnoreCase(searchName)) {
                System.out.println("Match Found -> " + movie);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movie found with the name: " + searchName);
        }
    }
}
