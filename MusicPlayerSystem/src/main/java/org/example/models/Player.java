package org.example.models;

import java.util.List;

public class Player {
    private PlayList playList;
    private PlaybackStrategy playbackStrategy;
    private List<Track> playOrder;
    private int currentIndex = -1;

    public void loadPlayList(PlayList playList, PlaybackStrategy strategy) {
        this.playList = playList;
        this.playbackStrategy = strategy;
        this.playOrder = strategy.generatePlayOrder(playList.getTracks());
        currentIndex = 0;
    }

    public Track play() {
        if (playOrder == null || playOrder.isEmpty() || currentIndex < 0) return null;
        Track track = playOrder.get(currentIndex);
        track.setTrackStatus(TrackStatus.PLAY);
        System.out.println("Playing: " + track.getTrackName() + " (Id: " + track.getTrackId() + ")");
        return track;
    }

    public Track stop() {
        if (currentIndex < 0) return null;
        Track track = playOrder.get(currentIndex);
        track.setTrackStatus(TrackStatus.STOP);
        System.out.println("Stopped: " + track.getTrackName());
        return track;
    }

    public Track next() {
        if (currentIndex + 1 < playOrder.size()) {
            currentIndex++;
            return play();
        } else {
            currentIndex = -1; // playlist finished
            return null;
        }
    }

    public Track previous() {
        if (currentIndex - 1 >= 0) {
            currentIndex--;
            return play();
        } else return null;
    }

    public void switchStrategy(PlaybackStrategy strategy) {
        if (playOrder == null || playOrder.isEmpty()) return;
        Track current = playOrder.get(currentIndex);
        this.playbackStrategy = strategy;
        this.playOrder = strategy.generatePlayOrder(playList.getTracks());
        currentIndex = playOrder.indexOf(current);
    }

    public Track getCurrentTrack() {
        if (currentIndex < 0 || currentIndex >= playOrder.size()) return null;
        return playOrder.get(currentIndex);
    }
}
