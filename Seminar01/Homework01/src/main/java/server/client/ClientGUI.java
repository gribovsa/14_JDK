package server.client;

import server.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private ServerWindow server; //ссылка на сервер
    private boolean connected; //флаг, что мы подключены
    private String name; //имя пользователя


    private JTextArea log; //текстовое поле log переписки
    private JTextField tfIPAddress, tfPort, tfLogin, tfMessage; //текстовые поля
    private JPasswordField password;
    private JButton btnLogin, btnSend;
    private JPanel headerPanel;

    public ClientGUI(ServerWindow server) {
        this.server = server;

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setLocation(server.getX() - 500, server.getY());

        createPanel();

        setVisible(true);
    }

    public void answer(String text){
        //метод использует сервер, когда хочет послать сообщения от клиентов
        appendLog(text);
    }

    private void connectToServer(){
        //метод подключения к серверу
        if (server.connectUser(this)){ //если метод сервера вернёт true
            appendLog("Вы успешно подключились!\n");
            headerPanel.setVisible(false);
            connected = true;
            name = tfLogin.getText();
            String log = server.getLog(); //получаем историю переписки
            if(log != null){
                appendLog(log); //если получили историю, отображаем её в панели log ов
            }
        }else {
            appendLog("Подключение не удалось");
        }
    }


    public void disconnectFromServer(){
        if (connected){ //если мы подключены
            headerPanel.setVisible(true); //активируем панель с кнопкой подключения (чтобы можно было обратно подкл)
            connected = false;
            server.disconnectUser(this); //вызываем метод у сервера, который исключит из списка
            appendLog("Вы были отключены от сервера");
        }
    }

    public void message(){
        //метод вызывается, когда нажимается клавиша Enter или отправка сообщения
        if (connected){ //если мы подключены
            String text = tfMessage.getText(); //получаем текст из текстового поля
            if(!text.isEmpty()){ //проверяем, что он не пустой
                server.message(name + ": " + text); //добавляем спереди имя отправителя (клиента), вызываем метод сервера и отправляем сообщение
                tfMessage.setText(""); //очищаем текстовое поле
            }
        }else {
            appendLog("Нет подключения к серверу");
        }
    }


    private void appendLog(String text){
        log.append(text + "\n");
    }

    private void createPanel(){
        //создание панели из 3 частей
        add(createHeaderPanel(), BorderLayout.NORTH); //заголовок
        add(createLog()); //средняя часть, сам лог
        add(createFooter(), BorderLayout.SOUTH); //нижняя часть
    }

    private Component createHeaderPanel(){
        //создание заголовка
        headerPanel = new JPanel(new GridLayout(2,3)); //сетка 2 х 3

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
                connectToServer(); //вызов метода connectToserver
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

    private Component createLog(){
        //Создание средней части - там где лог общения
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log); //появится прокрутка
    }

    private Component createFooter(){
        //Создание нижней части
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField(); //текстовое поле
        tfMessage.addKeyListener(new KeyAdapter() { //слушатель нажатий клавиш
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == '\n'){ //если нажата клавиша переноса, т.е Enter, то отправляем сообщение
                    message();
                }
            }
        });
        btnSend = new JButton("send"); //кнопка тоже отправляет сообщение
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
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
        if (e.getID() == WindowEvent.WINDOW_CLOSING){ //если текущее событие это закрытие окна
            disconnectFromServer(); //вызов метода отключения от сервера
        }
    }
}
