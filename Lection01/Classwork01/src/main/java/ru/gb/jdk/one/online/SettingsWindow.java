package ru.gb.jdk.one.online;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*todo
    Первое – стартовое окно, где будут задаваться настройки поля и производиться выбор режима игры;
 */

public class SettingsWindow extends JFrame {
    //Конструктор второго окна будет принимать экземпляр игрового
    //окна. В первую очередь это сделано для передачи параметров игры, а во-вторых,
    //чтобы красиво отцентрировать его относительно основного.

    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    JButton btnStart = new JButton("Start new game");

    SettingsWindow(GameWindow gameWindow){
        //В конструкторе окна задаются его размеры и то, что
        //его местоположение должно быть относительным главному окну.
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Окно настроек");




        //В окне настроек описан обработчик нажатия на единственную кнопку, из этого
        //обработчика вызывается единственный доступный метод – «старт новой игры» на
        //основном окне. По факту нажатия, также, целесообразно спрятать окно настроек.

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3,3,3);
            }
        });

        add(btnStart); //Аналогично основному окну добавлена кнопка подтверждения правильности настроек и старта игры
    }
}
