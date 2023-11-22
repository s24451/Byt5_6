import java.util.ArrayList;
import java.util.List;

interface Connection {
    void connect();

    void sendData(String data);

    void disconnect();
}

class NetworkConnection implements Connection {
    private String ipAddress;

    public NetworkConnection(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public void connect() {
        System.out.println("Connected to " + ipAddress);
    }

    @Override
    public void sendData(String data) {
        System.out.println("Sending data over the network: " + data);
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected from " + ipAddress);
    }
}

class ConnectionPool {
    private List<Connection> pool;
    private int maxSize;

    public ConnectionPool(int maxSize) {
        this.maxSize = maxSize;
        this.pool = new ArrayList<>();
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < maxSize; i++) {
            pool.add(new NetworkConnection("Server" + i));
        }
    }

    public Connection acquireConnection() {
        if (pool.isEmpty()) {
            System.out.println("No connections available. Creating a new one.");
            return new NetworkConnection("NewServer");
        } else {
            Connection connection = pool.remove(0);
            System.out.println("Acquired connection from the pool.");
            return connection;
        }
    }

    public void releaseConnection(Connection connection) {
        if (pool.size() < maxSize) {
            System.out.println("Released connection back to the pool.");
            pool.add(connection);
        } else {
            System.out.println("Pool is full. Cannot release connection.");
        }
    }
}

public class ConnectionPoolExample {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool(3);

        Connection connection1 = connectionPool.acquireConnection();
        connection1.connect();
        connection1.sendData("Hello, Server!");
        connection1.disconnect();
        connectionPool.releaseConnection(connection1);

        Connection connection2 = connectionPool.acquireConnection();
        connection2.connect();
        connection2.sendData("How are you?");
        connection2.disconnect();
        connectionPool.releaseConnection(connection2);

        Connection connection3 = connectionPool.acquireConnection();
        Connection connection4 = connectionPool.acquireConnection();
        Connection connection5 = connectionPool.acquireConnection();
        Connection connection6 = connectionPool.acquireConnection();

        connectionPool.releaseConnection(connection3);
        connectionPool.releaseConnection(connection4);
        connectionPool.releaseConnection(connection5);
        connectionPool.releaseConnection(connection6);
    }
}
