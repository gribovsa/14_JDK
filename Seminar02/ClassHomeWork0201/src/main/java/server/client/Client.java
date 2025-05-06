package server.client;

import server.server.Server;


public class Client {
    //Логика работы

    private Server server; //ссылка на сервер
    private boolean connected; //флаг, что мы подключены
    private String name; //имя пользователя
    private ClientView view; //теперь появилась ссылка на интерфейс ClientView

    public Client(ClientView view, Server server) { //в конструкторе принимаем объект интерфейса
        this.view = view;
        this.server = server;
    }


    public boolean connectToServer(String name) {
        this.name = name;
        //метод подключения к серверу
        if (server.connectUser(this)) { //если метод сервера вернёт true
            printText("Вы успешно подключились!\n");
            connected = true;
            name = tfLogin.getText();
            String log = server.getLog(); //получаем историю переписки
            if (log != null) {
                appendLog(log); //если получили историю, отображаем её в панели log ов
                return true;
            }
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }


    public void disconnect() {
        if (connected) { //если мы подключены
            view.disconnectFromServer(); //активируем панель с кнопкой подключения (чтобы можно было обратно подключиться)
            connected = false;
            server.disconnectUser(this); //вызываем метод у сервера, который исключит из списка
            printText("Вы были отключены от сервера");
        }
    }


    public String getName() {
        return name;
    }


    //мы посылаем сообщение
    public void sendMessage(String message) {
        if (connected) { //если мы подключены
            if (!message.isEmpty()) { //проверяем, что он не пустой
                server.sendMessage(name + ": " + message); //добавляем спереди имя отправителя (клиента), вызываем метод сервера и отправляем сообщение
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }


    //нам посылают сообщение
    public void serverAnswer(String answer) {
        printText(answer);
    }


    //метод работающий через созданный нами интерфейс
    private void printText(String text) {
        view.sendMessage(text);
    }
}
