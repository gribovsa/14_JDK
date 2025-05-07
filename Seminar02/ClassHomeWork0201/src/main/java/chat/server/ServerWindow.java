package chat.server;




import chat.logger.Logging;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/*todo
    В этом классе находятся все методы относящиеся к графике
 */


public class ServerWindow extends JFrame implements ServerView {

    private static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private JButton btnStart, btnStop; //кнопки
    private JTextArea log; //текстовое поле, где отображается лог общения
    private Server server;



    public ServerWindow(Logging logging) {

        //вызываю экземпляр класса сервера и передаю ему для работы этот класс, реализующий методы интерфейса
        //долго с этим разбирался (так делается когда классы обращаются друг к другу в своих методах)
        this.server = new Server(this, logging);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        createPanel();
        setVisible(true);
    }

    //геттер сервера
    public Server getServer() {
        return server;
    }



    //имплементируемые методы
    @Override
    public void appendLog(String text) {
        //добавляет текст на панель лога
        log.append(text + "\n");
    }

    @Override
    public void createPanel() {
        //создание панели
        log = new JTextArea(); //инициализация текстового поля
        add(log); //на панель добавляем это полк
        add(createButtons(), BorderLayout.SOUTH); //добавляем кнопки вниз экрана
    }


    //создание кнопок
    private Component createButtons() {

        JPanel panel = new JPanel(new GridLayout(1, 2)); //создали панель для кнопок
        btnStart = new JButton("Start"); //инициализация кнопок
        btnStop = new JButton("Stop"); //инициализация кнопок

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.isWork()) {
                    appendLog("Сервер уже был запущен");
                } else {
                    server.setWork(true);
                    appendLog("Сервер запущен");
                }
            }

        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.isWork()) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    server.setWork(false);
                    //отключение клиентов циклично
                    while (!server.getClientList().isEmpty()) {
                        server.disconnectUser(server.getClientList().get(server.getClientList().size() - 1)); //начиная с конца
                    }
                    appendLog("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}