package org.example;

public class TCPEstablished extends TCPState {

    @Override
    public void open() {
        System.out.println("Não é possível abrir uma conexão que já está estabelecida");
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
