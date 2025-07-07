package MusicPlayerApp;

import java.util.Scanner;

public class MusicPlayerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicPlayer player = new MusicPlayer();

        // System.out.print("Enter path to your CSV file (e.g. songs.csv): ");
        // String filename = sc.nextLine();
        String filename = "SongCSV.csv";

        player.initializeAllSongsFromCSV(filename);

        int choice;
        do {
            System.out.println("\n=== Music Player Menu ===");
            System.out.println("1. Play Current");
            System.out.println("2. Next Song");
            System.out.println("3. Previous Song");
            System.out.println("4. Shuffle");
            System.out.println("5. Like Current Song");
            System.out.println("6. Show Liked Songs");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            while (!sc.hasNextInt())
                sc.next();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> player.playCurrent();
                case 2 -> player.nextSong();
                case 3 -> player.previousSong();
                case 4 -> player.shuffleSong();
                case 5 -> player.likeCurrentSong();
                case 6 -> player.showLikedSongs();
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
