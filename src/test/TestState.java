import org.example.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestState {

    private TCPConnection connection;

    @BeforeEach
    public void setUp() {
        connection = new TCPConnection();
    }

    @Test
    public void testInitialState() {

        assertTrue(connection.getState() instanceof TCPListen);
    }

    @Test
    public void testOpenInListenState() {

        connection.open();

        assertTrue(connection.getState() instanceof TCPEstablished);
    }

    @Test
    public void testCloseInEstablishedState() {

        connection.open();

        connection.close();

        assertTrue(connection.getState() instanceof TCPClosed);
    }

    @Test
    public void testAcknowledgeInClosedState() {

        connection.open();
        connection.close();

        connection.acknowledge();

    }

    @Test
    public void testInvalidOperations() {
        connection.open();
        connection.close();
        connection.close();
        connection.open();
    }
}
