package org.example;

public class TCPConnection {

    private TCPState state;

    public TCPConnection() {
        this.state = new TCPListen();
        this.state.setConnection(this);
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public void acknowledge() {
        state.acknowledge();
    }

    public TCPState getState() {
        return state;
    }

    public void setState(TCPState state) {
        this.state = state;
        this.state.setConnection(this);
    }
}
