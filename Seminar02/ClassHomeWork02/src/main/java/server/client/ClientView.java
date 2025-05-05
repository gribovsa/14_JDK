package server.client;

public interface ClientView {
    void sendMessage(String message);
    void disconnectFromServer();
}
