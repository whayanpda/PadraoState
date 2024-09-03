package org.example;

public class TCPListen extends TCPState {

    @Override
    public void open() {
        System.out.println("Conexão estabelecida com sucesso");
        connection.setState(new TCPEstablished());
    }

    @Override
    public void close() {
        System.out.println("Conexão fechada com sucesso");
        connection.setState(new TCPClosed());
    }

    @Override
    public void acknowledge() {
        System.out.println("ACK");
    }
}
