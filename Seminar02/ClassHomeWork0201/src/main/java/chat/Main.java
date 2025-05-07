package chat;



/*todo
        Модифицировать приложение Сервер-клиент
   Преобразовать божественный класс ClientGUI согласно SOLID
   Преобразовать божественный класс ServerWindow согласно SOLID
   Взаимодействие между новыми классами через интерфейсы.
 */


import chat.client.ClientGUI;
import chat.logger.Logger;
import chat.server.Server;
import chat.server.ServerWindow;


public class Main {
    public static void main(String[] args) {

        Logger logger = new Logger();
        ServerWindow serverWindow = new ServerWindow(logger);
        Server server = serverWindow.getServer();   //кривенько конечно, но создавать второй экземпляр server нельзя
                                                    //первый экземпляр создан в serverWindow

        new ClientGUI(logger, server, serverWindow);
        new ClientGUI(logger, server, serverWindow);

    }
}
