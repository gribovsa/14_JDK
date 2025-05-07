package chat.server;

import chat.client.Client;
import chat.logger.Logging;

import java.util.ArrayList;
import java.util.List;


/*todo
    В этом классе находятся все методы бизнес логики
 */

public class Server {

    private boolean work; //флаг работы сервера

    private ServerView serverView; //ссылка на интерфейс ServerView
    private Logging logging; //ссылка на интерфейс Logging

    private List<Client> clientList; //список подключённых клиентов



    public Server(ServerView serverView, Logging logging) {
        this.serverView = serverView;
        this.logging = logging;
        clientList = new ArrayList<>(); //инициализация списка
    }


    //геттер состояния сервера
    public boolean isWork() {
        return work;
    }

    //геттер списка клиентов
    public List<Client> getClientList() {
        return clientList;
    }

    //сеттер состояния сервера
    public void setWork(boolean work) {
        this.work = work;
        System.out.println("Server метод setWork, переменная work = " + work);
        System.out.println("Server isWork значение в переменной work = " + isWork());
    }

    //подключение пользователя
    public boolean connectUser(Client client) {
        //метод добавления клиента
        if (work == false) { //если сервер не в работе
            System.out.println("Server метод connectUser, сервер не в работе, work = " + isWork());
            return false; //возвращаем неудачу
        }
        clientList.add(client); //добавляем в общий список клиентов
        return true; //возвращаем успех
    }

    //отключение пользователя
    public void disconnectUser(Client client) {
        //метод отключения клиента
        clientList.remove(client);//удаляем из списка
        if (client != null) { //проверка, если клиент не отключен
            client.disconnect(); //отключаем
        }
    }

    //метод работы с сообщениями от клиентов
    //метод вызывает клиент, когда пишет на сервер
    public void message(String text) {
        if (!work) {      //проверка, что сервер работает
            return;
        }
        text += "";
        serverView.appendLog(text); //метод добавления на панель логов
        answerAll(text); //один написал и все клиенты из списка увидели
        logging.saveInLog(text); //сохранение в лог
    }


    private void answerAll(String text) {
        //широковещательная рассылка текста всем клиентам
        for (Client client : clientList) {
            client.serverAnswer(text);
        }
    }

}
