package chat.client;

public interface ClientView {
    void showMessage(String message);
    void disconnectFromServer();
    void appendLog(String text);
    String getTfLogin();
}
