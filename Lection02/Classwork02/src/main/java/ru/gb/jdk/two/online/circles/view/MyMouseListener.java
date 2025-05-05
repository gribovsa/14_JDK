package ru.gb.jdk.two.online.circles.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
    private MainWindow mainWindow;

    public MyMouseListener(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (e.getButton() == MouseEvent.BUTTON1){
            mainWindow.removeSprite(); //если левая кнопка нажата убираем объект (шарик)
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            mainWindow.addSprite(e.getX(), e.getY()); //если правая, то добавляем
        }
    }
}

