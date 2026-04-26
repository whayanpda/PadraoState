package org.example;

public class PausedState extends PlayerState {

    private static PausedState instance = new PausedState();

    private PausedState() {}

    public static PausedState getInstance() {
        return instance;
    }

    public String getState() {
        return "Paused";
    }

    public boolean play(MusicPlayer player) {
        player.setState(PlayingState.getInstance());
        return true;
    }

    public boolean stop(MusicPlayer player) {
        player.setState(StoppedState.getInstance());
        return true;
    }
}
