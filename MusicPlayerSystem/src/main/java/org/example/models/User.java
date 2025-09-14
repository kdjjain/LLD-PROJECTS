package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class User {
    private final Map<Integer, PlayList> playLists = new HashMap<>();

    public int createPlayList (final String name) {
        PlayList playList = new PlayList(name);
        playLists.put(playList.getPlayListId(), playList);
        return playList.getPlayListId();
    }

    public int removePlayList(final int id) {
        playLists.remove(id);
        return id;
    }

    public PlayList getPlayList(int playListId) {
        return playLists.get(playListId);
    }
}
