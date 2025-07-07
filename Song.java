package MusicPlayerApp;

public class Song {
    String name;
    String artist;
    String duration;
    Song next;
    Song prev;

    public Song(String name, String artist, String duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.next = this.prev = null;
    }
}
