package ru.gb.jdk.two.online;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite{
    /*todo
        Конкретный рисуемый объект, класс шарика,
        который будет перемещаться по экрану. В конструкторе шарику задаются
        случайные размеры с определённым разбросом. Чтобы не усложнять пример
        отдельным объектами, описывающими физику мира, непосредственно объекту
        шарика будут заданы скорости по осям X и Y, и цвет.
     */

    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    public Ball() {
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }

    @Override
    /*
    В методе обновления к текущим координатам шарика прибавляется расстояние,
    которое должен был преодолеть шарик за то время пока канва спала и
    рендерилась.
    Дополнительно, обрабатываются отскоки от границ панели, то есть описаны четыре
    условия, что при достижении границы меняется направление вектора.
     */
    void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft()){
            setLeft(canvas.getLeft());
            vX = -vX;
        }

        if (getRight() > canvas.getRight()){
            setRight(canvas.getRight());
            vX = -vX;
        }

        if (getTop() < canvas.getTop()){
            setTop(canvas.getTop());
            vY = -vY;
        }

        if (getBottom() > canvas.getBottom()){
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    /*
    В классе шарика переопределяются методы обновления и рендеринга. Самый
    простой рендер – объекту графики задаётся цвет текущего шарика и вызывается
    метод fillOval(), которому передаются левая и верхняя координаты, ширина и
    высота. Несмотря на то, что объекты содержат поля типа float, работа происходит с
    пиксельной системой координат, а значит необходимо переводить в целые числа
     */
    void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int)  getTop(), (int) getWidth(), (int) getHeight());
    }
}
