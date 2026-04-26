package org.example;

public class PlayingState extends PlayerState {

    private static PlayingState instance = new PlayingState();

    private PlayingState() {}

    public static PlayingState getInstance() {
        return instance;
    }

    public String getState() {
        return "Playing";
    }

    public boolean pause(MusicPlayer player) {
        player.setState(PausedState.getInstance());
        return true;
    }

    public boolean stop(MusicPlayer player) {
        player.setState(StoppedState.getInstance());
        return true;
    }
}
