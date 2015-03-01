package com.example.sanjana.hackuvamoviereccomendation;

/**
 * Created by Sanjana on 2/28/15.
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie {
    private int id;
    private String title;
    private String releasedate;
    private String videodate;
    private String URL;
    private ArrayList<String> genre;
    private ArrayList<String> possible;

    public Movie(int id) throws Exception {
        // fix to try catch
        URL something = new URL("http://files.grouplens.org/datasets/movielens/ml-100k/u.item");
        Scanner input = new Scanner(something.openStream());

        genre = new ArrayList<String>(); // genre of each movie instance

        possible = new ArrayList<String>(); // list of possible genres
        possible.add("unknown");
        possible.add("Action");
        possible.add("Adventure");
        possible.add("Animation");
        possible.add("Children's");
        possible.add("Comedy");
        possible.add("Crime");
        possible.add("Documentary");
        possible.add("Drama");
        possible.add("Fantasy");
        possible.add("Film-Noir");
        possible.add("Horror");
        possible.add("Musical");
        possible.add("Mystery");
        possible.add("Romance");
        possible.add("Sci-Fi");
        possible.add("Thriller");
        possible.add("War");
        possible.add("Western");
        this.id = -1;

        while (input.hasNextLine() && this.id != id) {
            String[] line = input.nextLine().split("\\|");
            this.id = Integer.parseInt(line[0]);
            if (this.id == id) {
                this.title = line[1];
                this.releasedate = line[2];
                this.videodate = line[3];
                this.URL = line[4];

                for (int i = 5; i < 20; i++) {

                    if (line[i].equals("1")) {
                        genre.add(possible.get(i - 5));
                    }
                }

            }
        }
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", releasedate="
                + releasedate + ", videodate=" + videodate + ", URL=" + URL
                + ", genre=" + genre + "]";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public String getVideodate() {
        return videodate;
    }

    public String getURL() {
        return URL;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public static void main(String[] args) throws Exception {
        Movie m = new Movie(16);
        System.out.print(m.toString());
    }

}