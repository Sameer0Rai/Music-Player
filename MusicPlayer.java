package MusicPlayerApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class MusicPlayer {
    private Song allSongsHead = null;
    private Song likedSongsHead = null;
    private Song current = null;
    private int totalSongs = 0;

    // Load songs from CSV
    public void initializeAllSongsFromCSV(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            boolean isFirstLine = true; // to skip header
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine().trim();
                // Skip the header
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length >= 3) {
                        String name = parts[0].trim();
                        String artist = parts[1].trim();
                        String duration = parts[2].trim();
                        addSongToAll(name, artist, duration);
                    }
                }
            }
            current = allSongsHead;
            System.out.println("All songs loaded from CSV.");
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found: " + e.getMessage());
        }
    }

    // Add song to all songs list
    private void addSongToAll(String name, String artist, String duration) {
        Song newSong = new Song(name, artist, duration);
        totalSongs++;

        if (allSongsHead == null) {
            allSongsHead = newSong;
            newSong.next = newSong.prev = newSong;
        } else {
            Song tail = allSongsHead.prev;
            tail.next = newSong;
            newSong.prev = tail;
            newSong.next = allSongsHead;
            allSongsHead.prev = newSong;
        }
    }

    public void playCurrent() {
        if (current != null) {
            System.out.println("Now Playing:");
            System.out.println("   Name: " + current.name);
            System.out.println("   Artist: " + current.artist);
            System.out.println("   Duration: " + current.duration);
        }
    }

    public void nextSong() {
        if (current != null) {
            current = current.next;
            playCurrent();
        }
    }

    public void previousSong() {
        if (current != null) {
            current = current.prev;
            playCurrent();
        }
    }

    public void shuffleSong() {
        if (current == null || totalSongs == 0)
            return;
        Random rand = new Random();
        int steps = rand.nextInt(totalSongs);
        for (int i = 0; i < steps; i++) {
            current = current.next;
        }
        playCurrent();
    }

    public void likeCurrentSong() {
        if (current == null)
            return;
        Song liked = new Song(current.name, current.artist, current.duration);
        if (likedSongsHead == null) {
            likedSongsHead = liked;
            liked.next = liked.prev = liked;
        } else {
            Song tail = likedSongsHead.prev;
            tail.next = liked;
            liked.prev = tail;
            liked.next = likedSongsHead;
            likedSongsHead.prev = liked;
        }
        System.out.println("Liked: " + current.name);
    }

    public void showLikedSongs() {
        if (likedSongsHead == null) {
            System.out.println("No liked songs yet.");
            return;
        }

        System.out.println("Liked Songs:");
        Song temp = likedSongsHead;
        do {
            System.out.println("- " + temp.name + " by " + temp.artist + " (" + temp.duration + ")");
            temp = temp.next;
        } while (temp != likedSongsHead);
    }
}
