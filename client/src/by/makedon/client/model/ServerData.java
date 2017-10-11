package by.makedon.client.model;

public class ServerData {
    private String ip;
    private Integer port;
    private boolean isConnection;

    public void setIp(String ip) {
        this.ip = ip;
    }
    public void setIpNull() {
        ip = null;
    }
    public void setPort(int port) {
        this.port = port;
    }

    public void setPortNull() {
        port = null;
    }
    public void setConnectionTrue() {
        isConnection = true;
    }
    public void setConnectionFalse() { isConnection = false; }

    public String getIp() { return ip; }
    public int getPort() {
        return port;
    }
    public boolean isConnection() {
        return isConnection;
    }
}