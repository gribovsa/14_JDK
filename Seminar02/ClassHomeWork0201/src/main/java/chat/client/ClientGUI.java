package chat.client;


import chat.logger.Logger;
import chat.server.Server;
import chat.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame implements ClientView {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;


    private JTextArea log; //текстовое поле log переписки
    private JTextField tfIPAddress, tfPort, tfLogin, tfMessage; //текстовые поля
    private JPasswordField password;
    private JButton btnLogin, btnSend;
    private JPanel headerPanel;

/*todo
    В этом классе находятся все методы относящиеся к графике
 */

    private Client client; //ссылка на клиента
    private ServerWindow serverWindow;


    public ClientGUI(Logger loger, Server server, ServerWindow serverWindow) {

        //вызываю экземпляр класса сервера и передаю ему для работы этот класс, реализующий методы интерфейса
        //долго с этим разбирался (так делается когда классы обращаются друг к другу в своих методах)
        this.client = new Client(this, loger, server);

        this.serverWindow = serverWindow; //требуется для setLocation

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setLocation(serverWindow.getX() - 500, serverWindow.getY());
        createPanel();
        setVisible(true);
    }


    //Имплементируемые методы

    @Override
    public void showMessage(String text) {
        appendLog(text);
    }

    @Override
    public void disconnectFromServer() {
        hideHeaderPanel(true);
        client.disconnect();
    }

    @Override
    public void appendLog(String text) {
        //метод добавления на центр панель сообщения
        log.append(text + "\n");
    }

    @Override
    public String getTfLogin() {
        return tfLogin.getText();
    }



    //Методы представления GUI

    private void hideHeaderPanel(boolean visible) {
        headerPanel.setVisible(visible);
    }


    private void sendMessage() {
        //метод отправки сообщения, который срабатывает при нажатии кнопки отправить
        client.sendMessage(tfMessage.getText());
        tfMessage.setText(" "); //обнуляем графическое окно
    }

    private void createPanel() {
        //создание панели из 3 частей
        add(createHeaderPanel(), BorderLayout.NORTH); //заголовок
        add(createLog()); //средняя часть, сам лог
        add(createFooter(), BorderLayout.SOUTH); //нижняя часть
    }

    private Component createHeaderPanel() {
        //создание заголовка
        headerPanel = new JPanel(new GridLayout(2, 3)); //сетка 2 х 3

        //номинальная часть
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Sergey Gribov");
        password = new JPasswordField("1234");

        //кнопка залогинится
        btnLogin = new JButton("login");
        //действие
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.connectToServer(); //вызов метода connectToServer у клиента
            }
        });

        //добавляем все в виджеты
        headerPanel.add(tfIPAddress);
        headerPanel.add(tfPort);
        headerPanel.add(new JPanel()); //визуальный разделитель
        headerPanel.add(tfLogin);
        headerPanel.add(password);
        headerPanel.add(btnLogin);


        return headerPanel;
    }

    private Component createLog() {
        //Создание средней части - там где лог общения
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log); //появится прокрутка
    }

    private Component createFooter() {
        //Создание нижней части
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField(); //текстовое поле
        tfMessage.addKeyListener(new KeyAdapter() { //слушатель нажатий клавиш
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') { //если нажата клавиша переноса, т.е Enter, то отправляем сообщение
                    sendMessage();
                }
            }
        });
        btnSend = new JButton("send"); //кнопка тоже отправляет сообщение
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        panel.add(tfMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    /*
    Если клиент закроет окно, произойдёт отключение от сервера
     */
    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) { //если текущее событие это закрытие окна
            disconnectFromServer(); //вызов метода отключения от сервера
        }
    }


}
