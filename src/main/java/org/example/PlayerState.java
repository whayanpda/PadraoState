package org.example;

public abstract class PlayerState {

    public abstract String getState();

    public boolean play(MusicPlayer player) {
        return false;
    }

    public boolean pause(MusicPlayer player) {
        return false;
    }

    public boolean stop(MusicPlayer player) {
        return false;
    }
}
