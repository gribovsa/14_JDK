package ru.gb.jdk.one.online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*todo
    Второе – основное окно, где будет происходить собственно игра.
 */
public class GameWindow extends JFrame {
    private static final int WINDOWS_HEIGHT = 555;
    private static final int WINDOWS_WIDTH = 507;
    private static final int WINDOWS_POSX = 800;
    private static final int WINDOWS_POSY = 300;

    JButton btnStart = new JButton("New Game"); //создание объекта кнопка
    JButton btnExit = new JButton("Exit"); //создание объекта кнопка
    Map map = new Map(); //создали объект - наша панель с чёрным фоном
    SettingsWindow settings;

    GameWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Если этого не сделать, то будет использовано поведение по умолчанию, окно сделается невидимым, и приложение не завершится.
        setLocation(WINDOWS_POSX, WINDOWS_POSY); //Положение окна
        setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT); //Позиция
        setTitle("Основное окно");
        setResizable(false);

        //Понадобится поле, класса SettingsWindow, чтобы иметь возможность,
        //экземпляр этого окна показывать когда появится необходимость
        settings = new SettingsWindow(this);
        //Обратите внимание, на этот способ применять this, когда необходимо передать в метод ссылку на объект,
        //который вызывает этот метод. Фактически, основное окно передаёт себя.



        JPanel panBottom = new JPanel(new GridLayout(1,2)); //Создание панели аргументы - количество строк и столбцов
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH); //Добавили кнопки, и выбрали компоновщик BorderLayout, указали место куда вставить кнопки SOUTH

        add(map); //Разместил нашу панель

        setVisible(true); //По умолчанию окно – невидимое, поэтому для его демонстрации в конструкторе вызывается метод setVisible с передаваемым аргументом true.


        //Обработчики кнопок старта новой игры и завершения приложения

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

    //Из метода основного класса startNewGame() вызывается map.startNewGame() класса мэп.
    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
