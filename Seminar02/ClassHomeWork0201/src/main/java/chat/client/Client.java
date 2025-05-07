package chat.client;

import chat.logger.Logging;
import chat.server.Server;


/*todo
    В этом классе находятся все методы бизнес логики
 */

public class Client {


    private  ClientView clientView; // ссылка на интерфейс ClientView
    private  Logging logging; // ссылка на интерфейс Logging

    private Server server;


    private  boolean connected; //флаг, что мы подключены
    private  String name; //имя пользователя


    public Client(ClientView clientView, Logging logging, Server server) {
        this.clientView = clientView;
        this.logging = logging;
        this.server = server;
    }


    //соединение с сервером
    public boolean connectToServer() {
        //метод подключения к серверу
        if (server.connectUser(this)) { //если метод сервера вернёт true
            printText("Вы успешно подключились!\n");
            connected = true;
            this.name = clientView.getTfLogin(); //получаю имя через интерфейс
            String log = logging.getLog();  //получаем историю переписки
            if (log != null) {
                clientView.appendLog(log); //если получили историю, отображаем её в панели log ов
                return true;
            }
        } else {
            printText("Подключение не удалось");

        }return false;
    }


    public void disconnect() {
        if (connected) { //если мы подключены
            clientView.disconnectFromServer(); //активируем панель с кнопкой подключения (чтобы можно было обратно подключиться)
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
                server.message(name + ": " + message); //добавляем спереди имя отправителя (клиента), вызываем метод сервера и отправляем сообщение
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
        clientView.showMessage(text);
    }
}
