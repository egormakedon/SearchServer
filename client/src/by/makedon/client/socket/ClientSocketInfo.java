package by.makedon.client.socket;

public class ClientSocketInfo {
    private String ip;
    private int port;
    private boolean connection;

    public void setIpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void setConnectionTrue() {
        connection = true;
    }

    public void setConnectionFalse() {
        connection = false;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public boolean isConnection() {
        return connection;
    }
}