package org.example;

public class StoppedState extends PlayerState {

    private static StoppedState instance = new StoppedState();

    private StoppedState() {}

    public static StoppedState getInstance() {
        return instance;
    }

    public String getState() {
        return "Stopped";
    }

    public boolean play(MusicPlayer player) {
        player.setState(PlayingState.getInstance());
        return true;
    }
}
