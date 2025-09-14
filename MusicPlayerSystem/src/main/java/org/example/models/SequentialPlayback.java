package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class SequentialPlayback implements PlaybackStrategy {

    @Override
    public List<Track> generatePlayOrder(List<Track> tracks) {
        return new ArrayList<>(tracks);
    }
}
