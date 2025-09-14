package org.example.models;

import java.util.List;

public interface PlaybackStrategy {
    List<Track> generatePlayOrder(List<Track> tracks);
}
