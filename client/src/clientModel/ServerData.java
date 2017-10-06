package clientModel;

public class ServerData {
    private String ip;
    private String port;
    private boolean isConnection = true;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setIpNull() {
        ip = null;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPortNull() {
        port = null;
    }

    public void setIsConnectionTrue() {
        isConnection = true;
    }

    public void setIsConnectionFalse() {
        isConnection = false;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public boolean isConnection() {
        return isConnection;
    }
}
