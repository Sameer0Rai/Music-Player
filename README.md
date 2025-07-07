# 🎵 Java Music Player (Doubly Circular Linked List)

This is a **simple terminal-based music player simulation** built in Java using a **doubly circular linked list**. It allows users to play, navigate, shuffle, and like songs from a playlist loaded via a CSV file.

---

## 🧠 Features

* 🎧 Load songs from a CSV file
* ▶️ Play current song
* ⏭️ Play next or previous song
* 🔀 Shuffle to a random song
* ❤️ Like current song (adds to liked playlist)
* 📃 View liked songs
* 💾 Easily extendable with artist/duration fields

---

## 📂 Project Structure

```
Java_Project/
├── MusicPlayerApp.java     # Main driver with menu interface
├── MusicPlayer.java        # Core music player logic
├── Song.java               # Node class for each song
├── songs.csv               # Song list in CSV format
└── README.md               # This file
```

---

## 📄 CSV Format

Ensure your `songs.csv` file follows this format:

```csv
Song,Artist,Duration
Tum Hi Ho,Arijit Singh,262
Zara Sa,KK,270
Kun Faya Kun,AR Rahman,435
...
```

* **Duration** is in seconds
* **No commas** inside fields unless you're using a proper CSV parser

---

## 🚀 How to Run

### ✅ Prerequisites

* JDK 8 or above installed
* A terminal or VS Code

### 🛠️ Steps

1. **Clone the repository** or download source files.
2. Place your `songs.csv` in the root folder.
3. Compile the program:

```bash
javac *.java
```

4. Run the program:

```bash
java MusicPlayerApp
```

---

## 🖥️ Menu Options

```
--- Music Player ---
1. Play Current Song
2. Next Song
3. Previous Song
4. Shuffle
5. Like Current Song
6. Show Liked Songs
0. Exit
```

---

## 🦖 Data Structure Used

* The playlist is implemented using a **Doubly Circular Linked List**
* Each `Song` node points to:

  * `next` (next song)
  * `prev` (previous song)
* Liked songs use a separate linked list

---

## 📌 Future Improvements

* GUI version using JavaFX
* Playlist management (create/remove)
* CSV export for liked songs
* Search functionality

---

## 👨‍💼 Author

Built with ❤️ by Sameer

---

## 📜 License

This project is open source and available under the [MIT License](LICENSE).
