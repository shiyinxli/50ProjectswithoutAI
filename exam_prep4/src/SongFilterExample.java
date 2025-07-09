import java.util.*;
import java.util.stream.*;

public class SongFilterExample {

    // static nested class
    static class Song {
        private String title;
        private int year;
        private String genre;

        public Song(String title, int year, String genre) {
            this.title = title;
            this.year = year;
            this.genre = genre;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }
        public String getGenre(){
            return genre;
        }
    }

    public static void main(String[] args) {
        // Create a list of songs
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Bohemian Rhapsody", 1975, "pop"));
        songs.add(new Song("Smells Like Teen Spirit", 1991, "dance pop"));
        songs.add(new Song("Hey Ya!", 2003, "pop"));
        songs.add(new Song("Wonderwall", 1995, "Jazz"));
        songs.add(new Song("Rolling in the Deep", 2010, "R&B"));
        songs.add(new Song("Creep", 1993, "pop"));

        // Use stream to filter, map, sort, and collect
        List<String> oldSongTitles = songs.stream()
                .filter(song -> song.getYear() < 2000)
                .map(Song::getTitle)
                .sorted()
                .collect(Collectors.toList());

        // Print result
        System.out.println("Songs before 2000 (alphabetically): " + oldSongTitles);

        long uniqueGenreCount = songs. stream()
                .map(Song::getGenre)
                .distinct()
                .count();
        System.out.println(uniqueGenreCount);
    }
}