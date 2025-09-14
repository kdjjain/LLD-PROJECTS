package org.example.models;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;


@Data
public class Track {
    private static final AtomicInteger trackCount = new AtomicInteger(0);
    private int trackId ;
    private String trackName;
    private TrackType trackType;
    private int trackLength;
    private TrackStatus trackStatus;

    public Track (final String trackName, final TrackType trackType , final int trackLength ) {
        this.trackName = trackName;
        this.trackId = trackCount.incrementAndGet();
        this.trackType = trackType;
        this.trackLength = trackLength;
        System.out.println("A new Track is created with Id " + trackId);
    }
}
