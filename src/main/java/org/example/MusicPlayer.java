package org.example;

public class MusicPlayer {

    private PlayerState state;

    public MusicPlayer() {
        this.state = StoppedState.getInstance();
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public boolean play() {
        return state.play(this);
    }

    public boolean pause() {
        return state.pause(this);
    }

    public boolean stop() {
        return state.stop(this);
    }

    public String getStateName() {
        return state.getState();
    }
}
