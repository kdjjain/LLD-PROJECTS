package org.example;

import org.example.models.*;

public class Main {
    public static void main(String[] args) {

        // --- 1️⃣ Create user ---
        User user = new User();

        // --- 2️⃣ Create playlists ---
        int rockPlaylistId = user.createPlayList("Rock Hits");
        int chillPlaylistId = user.createPlayList("Chill Vibes");

        PlayList rockPlaylist = user.getPlayList(rockPlaylistId);
        PlayList chillPlaylist = user.getPlayList(chillPlaylistId);

        // --- 3️⃣ Create tracks ---
        Track t1 = new Track("Rock Song 1", TrackType.SONG, 210);
        Track t2 = new Track("Rock Song 2", TrackType.SONG, 180);
        Track t3 = new Track("Chill Song 1", TrackType.SONG, 200);
        Track t4 = new Track("Chill Song 2", TrackType.SONG, 240);

        // --- 4️⃣ Add tracks to playlists ---
        rockPlaylist.addTrackToPlaylist(t1);
        rockPlaylist.addTrackToPlaylist(t2);

        chillPlaylist.addTrackToPlaylist(t3);
        chillPlaylist.addTrackToPlaylist(t4);

        // --- 5️⃣ Create Player ---
        Player player = new Player();

        // --- 6️⃣ Load playlist in SEQUENCE mode ---
        System.out.println("\n--- Playing Rock Playlist in SEQUENCE mode ---");
        player.loadPlayList(rockPlaylist, new SequentialPlayback());
        player.play();     // Rock Song 1
        player.next();     // Rock Song 2
        player.previous(); // Rock Song 1

        // --- 7️⃣ Switch to SHUFFLE mode ---
        System.out.println("\n--- Switching to SHUFFLE mode ---");
        player.switchStrategy(new ShufflePlayback());
        player.play();     // Random song from Rock Playlist
        player.next();     // Next random song
        player.next();     // If playlist ends → null

        // --- 8️⃣ Load another playlist ---
        System.out.println("\n--- Playing Chill Playlist in SEQUENCE mode ---");
        player.loadPlayList(chillPlaylist, new SequentialPlayback());
        player.play();     // Chill Song 1
        player.next();     // Chill Song 2
        player.previous(); // Chill Song 1
    }
}
