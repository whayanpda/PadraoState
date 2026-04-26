package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MusicPlayerTest {

    private MusicPlayer player;

    @BeforeEach
    void setUp() {
        player = new MusicPlayer();
    }

    @Test
    void shouldStartInStoppedState() {
        assertEquals("Stopped", player.getStateName());
    }

    @Test
    void shouldTransitionFromStoppedToPlayingWhenPlayIsCalled() {
        boolean result = player.play();

        assertTrue(result);
        assertEquals("Playing", player.getStateName());
    }

    @Test
    void shouldTransitionFromPlayingToPausedWhenPauseIsCalled() {
        player.play();

        boolean result = player.pause();

        assertTrue(result);
        assertEquals("Paused", player.getStateName());
    }

    @Test
    void shouldTransitionFromPausedToPlayingWhenPlayIsCalled() {
        player.play();
        player.pause();

        boolean result = player.play();

        assertTrue(result);
        assertEquals("Playing", player.getStateName());
    }

    @Test
    void shouldTransitionFromPlayingToStoppedWhenStopIsCalled() {
        player.play();

        boolean result = player.stop();

        assertTrue(result);
        assertEquals("Stopped", player.getStateName());
    }

    @Test
    void shouldTransitionFromPausedToStoppedWhenStopIsCalled() {
        player.play();
        player.pause();

        boolean result = player.stop();

        assertTrue(result);
        assertEquals("Stopped", player.getStateName());
    }

    @Test
    void shouldReturnFalseWhenPauseIsCalledInStoppedState() {
        boolean result = player.pause();

        assertFalse(result);
        assertEquals("Stopped", player.getStateName());
    }

    @Test
    void shouldReturnFalseWhenStopIsCalledInStoppedState() {
        boolean result = player.stop();

        assertFalse(result);
        assertEquals("Stopped", player.getStateName());
    }

    @Test
    void shouldReturnFalseWhenPlayIsCalledInPlayingState() {
        player.play();

        boolean result = player.play();

        assertFalse(result);
        assertEquals("Playing", player.getStateName());
    }

    @Test
    void shouldReturnFalseWhenPauseIsCalledInPausedState() {
        player.play();
        player.pause();

        boolean result = player.pause();

        assertFalse(result);
        assertEquals("Paused", player.getStateName());
    }

    @Test
    void shouldReturnFalseWhenStopIsCalledRepeatedlyAfterAlreadyStopped() {
        player.play();
        player.stop();

        boolean result = player.stop();

        assertFalse(result);
        assertEquals("Stopped", player.getStateName());
    }

    @Test
    void shouldPreserveExpectedStateAcrossMultipleValidTransitions() {
        assertTrue(player.play());
        assertEquals("Playing", player.getStateName());

        assertTrue(player.pause());
        assertEquals("Paused", player.getStateName());

        assertTrue(player.play());
        assertEquals("Playing", player.getStateName());

        assertTrue(player.stop());
        assertEquals("Stopped", player.getStateName());
    }
}
