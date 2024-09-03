package org.example;

public abstract class TCPState {

    protected TCPConnection connection;

    public void setConnection(TCPConnection connection) {
        this.connection = connection;
    }

    public abstract void open();
    public abstract void close();
    public abstract void acknowledge();
}
