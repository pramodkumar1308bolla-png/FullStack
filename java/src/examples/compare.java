package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Movie implements Comparable<Movie> {
    String MovieName;
    String HeroName;
    double Budget;
    int year;
    double profit;
    int rating;

    public Movie(String movieName, String heroName, double budget, int year, double profit, int rating) {
        MovieName = movieName;
        HeroName = heroName;
        Budget = budget;
        this.year = year;
        this.profit = profit;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie [MovieName=" + MovieName + ", HeroName=" + HeroName + ", Budget=" + Budget + ", year=" + year
                + ", profit=" + profit + ", rating=" + rating + "]";
    }

    public String getMovieName() {
        return MovieName;
    }

    public double getBudget() {
        return Budget;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public int compareTo(Movie o) {
        // Default sorting → Movie name (A-Z)
        return this.MovieName.compareToIgnoreCase(o.MovieName);
    }
}

public class compare {
    public static void main(String[] args) {
        List<Movie> m = new ArrayList<>();
        m.add(new Movie("Bahubali", "Prabhas", 2000700000.00, 2015, 4030000000.00, 5));
        m.add(new Movie("OG", "PK", 4000040000.00, 2018, 8000001000.00, 4));
        m.add(new Movie("Puspha", "Alluarjun", 6000060000.00, 2017, 12020000000.00, 3));
        m.add(new Movie("Yogi", "Prabhas", 80000430000.00, 2016, 16000400000.00, 2));
        m.add(new Movie("Chatrapathi", "Prabhas", 6000006000.00, 2015, 12000005000.00, 4));

        System.out.println("---- Original List ----");
        for (Movie movie : m) {
            System.out.println(movie);
        }

        // 1. Sort by Name (A-Z)
        Collections.sort(m);
        System.out.println("\n---- Movies Sorted by Name (A-Z) ----");
        for (Movie movie : m) {
            System.out.println(movie);
        }

        // 2. Sort by Rating (High → Low)
        Collections.sort(m, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return Integer.compare(m2.getRating(), m1.getRating()); // reversed
            }
        });
        System.out.println("\n---- Movies Sorted by Rating (High → Low) ----");
        for (Movie movie : m) {
            System.out.println(movie);
        }

        // 3. Sort by Budget (Low → High)
        Collections.sort(m, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return Double.compare(m1.getBudget(), m2.getBudget());
            }
        });
        System.out.println("\n---- Movies Sorted by Budget (Low → High) ----");
        for (Movie movie : m) {
            System.out.println(movie);
        }

        // 4. Sort by Year (If Same → Name)
        Collections.sort(m, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                if (m1.getYear() == m2.getYear()) {
                    return m1.getMovieName().compareTo(m2.getMovieName());
                }
                return Integer.compare(m1.getYear(), m2.getYear());
            }
        });
        System.out.println("\n---- Movies Sorted by Year (If Same → Name) ----");
        for (Movie movie : m) {
            System.out.println(movie);
        }
    }
}
