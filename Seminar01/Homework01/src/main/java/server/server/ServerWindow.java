package server.server;

import server.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {

    private static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public static final String LOG_PATH = "src/main/java/server/log.txt";

    private List<ClientGUI> clientGUIList; //список подключённых клиентов

    private JButton btnStart, btnStop; //кнопки
    private JTextArea log; //текстовое поле, где отображается лог общения
    private boolean work; //флаг работы сервера




    public ServerWindow() {
        clientGUIList = new ArrayList<>(); //инициализация списка

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }




    public boolean connectUser(ClientGUI clientGUI){
        //метод добавления клиента
        if(!work){ //если сервер не в работе
            return false; //возвращаем неудачу
        }
        clientGUIList.add(clientGUI); //добавляем в общий список клиентов
        return true; //возвращаем успех
    }


    public void disconnectUser(ClientGUI clientGUI){
        //метод отключения клиента
        clientGUIList.remove(clientGUI);//удаляем из списка
        if (clientGUI != null){ //проверка, если клиент не отключен
            clientGUI.disconnectFromServer(); //отключаем
        }
    }





    private void appendLog(String text) {
        //добавляет текст на панель лога
        log.append(text + "\n");
    }


    private String readLog(){
        //подключаемся к файлу, читаем его, возвращаем строку
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)){
            int c;
            while ((c = reader.read()) != 1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getLog(){
        //метод запрашивает историю переписки
        return readLog();
    }





    public void message(String text){
        //метод работы с сообщениями от клиентов
        //метод вызывает клиент, когда пишет на сервер
        if(!work){      //проверка, что сервер работает
            return;
        }
        text += "";
        appendLog(text); //метод добавления на панель логов
        answerAll(text); //один написал и все клиенты из списка увидели
        saveInLog(text); //сохранение в лог
    }

    private void answerAll(String text){
        //широковещательная рассылка текта всем клиентам
        for (ClientGUI clientGUI : clientGUIList) {
            clientGUI.answer(text);
        }
    }

    private void saveInLog(String text){
        try(FileWriter writer = new FileWriter(LOG_PATH,true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void createPanel() {
        //создание панели
        log = new JTextArea(); //инициализация текстового поля
        add(log); //на панель добавляем это полк
        add(createButtons(), BorderLayout.SOUTH); //добавляем кнопки вниз экрана
    }



    private Component createButtons() {
        //создание кнопок
        JPanel panel = new JPanel(new GridLayout(1, 2)); //создали панель для кнопок
        btnStart = new JButton("Start"); //инициализация кнопок
        btnStop = new JButton("Stop"); //инициализация кнопок


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (work) {
                    appendLog("Сервер уже был запущен");
                } else {
                    work = true;
                    appendLog("Сервер запущен");
                }
            }

        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!work) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    work = false;
                    //отключение клиентов циклично
                    while (!clientGUIList.isEmpty()){
                        disconnectUser(clientGUIList.get(clientGUIList.size()-1)); //начиная с конца
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