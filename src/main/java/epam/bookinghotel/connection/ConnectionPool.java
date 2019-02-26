package epam.vakulchyk.bookinghotel.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Vector;

public class ConnectionPool {
    private Vector<Connection> availableConns = new Vector<>();
    private Vector<Connection> usedConns = new Vector<>();
    private static final String HOST_NAME = "localhost";
    private static final String DB_NAME = "bookinghotel";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "pass";
    private static final String URL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DB_NAME;

    public ConnectionPool(int initConnCnt) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < initConnCnt; i++) {
            availableConns.addElement(getConnection());
        }
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    public synchronized Connection retrieve() throws SQLException {
        Connection newConn;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public synchronized void putback(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new NullPointerException("Connection not in the usedConns array");
            }
        }
    }

//    public int getAvailableConnsCnt() {
//        return availableConns.size();
//    }
}
