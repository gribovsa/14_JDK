package chat.logger;

public interface Logging {
    String readLog();
    String getLog();
    void saveInLog(String text);
}
