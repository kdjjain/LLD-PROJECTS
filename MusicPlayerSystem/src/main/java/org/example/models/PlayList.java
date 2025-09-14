package org.example.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class PlayList {
    private static final AtomicInteger playListCount = new AtomicInteger(0);

    private int playListId;
    private String playListName;
    private List<Track> tracks;

    public PlayList(final String playListName) {
        this.playListId = playListCount.incrementAndGet();
        this.playListName = playListName;
        this.tracks = new ArrayList<>();
    }

    public void addTrackToPlaylist(final Track track) {
        tracks.add(track);
    }

    public void removeTrackFromPlayList(final Track track) {
        tracks.remove(track);
    }

    public void moveTrack(final int oldIndex, final int newIndex) {
        if (oldIndex < 0 || oldIndex >= tracks.size() ||
                newIndex < 0 || newIndex >= tracks.size()) {
            throw new IndexOutOfBoundsException("Invalid index for reordering");
        }
        Track track = tracks.remove(oldIndex);
        tracks.add(newIndex, track);
    }
}
