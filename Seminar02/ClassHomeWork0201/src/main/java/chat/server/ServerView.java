package chat.server;

public interface ServerView {
    void appendLog(String text);//добавляет текст на панель лога
    void createPanel(); //создание панели
}
