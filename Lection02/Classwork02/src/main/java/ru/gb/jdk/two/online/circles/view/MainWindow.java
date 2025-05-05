package ru.gb.jdk.two.online.view;

import ru.gb.jdk.two.online.CanvasRepaintListener;
import ru.gb.jdk.two.online.MainCanvas;
import ru.gb.jdk.two.online.Sprite;
import ru.gb.jdk.two.online.sprites.Background;
import ru.gb.jdk.two.online.sprites.Ball;

import javax.swing.*;
import java.awt.*;

/*todo
    Основное окно программы
    Напомню, что самое главное, что необходимо понять из этого приложения – это
    взаимодействия и взаимовлияния объектов. Наследование, полиморфизм,
    инкапсуляция поведений и свойств.
 */

public class MainWindow extends JFrame implements CanvasRepaintListener {
    public static final int POS_X = 400;
    public static final int POS_Y = 200;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    /*
    В основном классе делается очень прямолинейно – создаётся массив из спрайтов, способный
    удержать десять шариков.
     */
    private final Sprite[] sprites = new Sprite[10];


    private MainWindow()  {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        //обратимся к канве
        MainCanvas canvas = new MainCanvas(this); //передаем в аргумент самого же себя (т.е MainWindow)
        //добавим канву на главное окно
        add(canvas);

        setVisible(true);

        //Инициализация фона
        sprites[0] = new Background();

        //В конструкторе добавляется простой цикл инициализирующий приложение
        //десятью шариками.
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

    }


    /* todo
        Описать в основном окне метод onDrawFrame(), который будет периодически вызываться канвой
        в нём будет описываться бизнес-логика
    */
    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        /*
        Метод onDrawFrame() будет обновлять сцену и заставлять объекты на ней рисовать
        самих себя (рендерить сцену). Для обновления сцены, привязанного ко времени
        физического мира необходимо знать дельту времени, то есть период времени,
        прошедший с появления предыдущего кадра.
        Метод onDrawFrame() должен принимать от канвы ряд параметров и распределять
        их по методам обновления и рендеринга.
        */
        update(canvas, deltaTime); //будет изменять состояние приложения
        render(canvas, g); //будет отдавать команды рисующимся компонентам
    }


    private void update(MainCanvas canvas, float deltaTime) {
        //изменяет состояние приложения
        //В методе обновления каждый шарик из массива
        //необходимо попросить обновиться, а в методе рендеринга – дать команду на
        //отрисовку.

        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }

    }

    private void render(MainCanvas canvas, Graphics g) {
        //перерисовывает компоненты

        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }


    public static void main(String[] args) {
        new MainWindow();
    }

}

