package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShufflePlayback implements PlaybackStrategy {

    @Override
    public List<Track> generatePlayOrder(List<Track> tracks) {
        List<Track> shuffled = new ArrayList<>(tracks);
        Collections.shuffle(shuffled);
        return shuffled;
    }
}
