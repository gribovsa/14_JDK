package ru.gb.jdk.two.online;

/*todo
    Основа - канва - Редкая сетчатая, обычно накрахмаленная хлопчатобумажная (иногда льняная) ткань,
    служащая основой при вышивании крестом
 */

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private final CanvasRepaintListener controller;
    private long lastFrameTime;

    MainCanvas(CanvasRepaintListener controller){
        this.controller = controller;  //и ссылку на основное окно добавляем в конструктор
        //setBackground(Color.BLUE);

    }


    @Override
    //Переопределим метод перерисовки панели
    //В результате создан бесконечный цикл отрисовки, аналогичный циклу do-while,
    //который сам себя заставляет крутиться с некоторой периодичностью и на каждой
    //итерации сообщает контроллеру, что прошло около одной шестидесятой секунды.
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        try {
            //Любой поток возможно заставить какое-то время поспать, для этого
            //вызывается статический метод класса Thread, принимающий в качестве аргумента
            //количество миллисекунд, которое поток должен обязательно поспать.
            //Это даст FPS2 близкий к 60, приемлемый для применения в цифровой технике.
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Вычисление дельты времени между кадрами канвы
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this,g,deltaTime); //вызываем метод из основного окна
        lastFrameTime = System.nanoTime(); //фиксируем время после вызова метода onDrawFrame

        repaint(); //создать постоянно обновляющуюся канву
    }




    //Также для универсализации дальнейших вызовов (удобства взаимодействия с
    //канвой) следует добавить методы, возвращающие границы панели.
    public int getLeft(){
        return 0;
    }

    public int getRight(){
        return getWidth() - 1;
    }

    public int getTop(){
        return 0;
    }

    public int getBottom(){
        return getHeight() - 1;
    }
}
