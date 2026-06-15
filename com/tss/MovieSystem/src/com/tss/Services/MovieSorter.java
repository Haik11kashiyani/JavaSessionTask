package com.tss.Services;

import com.tss.entity.Movies;
import java.util.Comparator;

public class MovieSorter {


    public static class IdComparator implements Comparator<Movies> {
        @Override
        public int compare(Movies m1, Movies m2) {
            return Integer.compare(m1.getId(), m2.getId());
        }
    }


    public static class NameComparator implements Comparator<Movies> {
        @Override
        public int compare(Movies m1, Movies m2) {
            return m1.getMovieName().compareToIgnoreCase(m2.getMovieName());
        }
    }


    public static class YearComparator implements Comparator<Movies> {
        @Override
        public int compare(Movies m1, Movies m2) {
            return m1.getYear().compareTo(m2.getYear());
        }
    }
}
