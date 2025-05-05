package server;

import server.client.ClientGUI;
import server.server.ServerWindow;

/*todo
        Модифицировать приложение Сервер-клиент
   Преобразовать божественный класс ClientGUI согласно SOLID
   Преобразовать божественный класс ServerWindow согласно SOLID
   Взаимодействие между новыми классами через интерфейсы.
 */

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow(); //создаём объект сервер
        new ClientGUI(serverWindow); //клиентам передаём ссылку на сервер
        new ClientGUI(serverWindow); //клиентам передаём ссылку на сервер

    }
}
