package ru.gb.jdk.two.online;

import java.awt.*;

public abstract class Sprite implements Interactable {
    /*todo
        Класс Sprite описывает общие для всех рисуемых объектов в программе поведение
        и свойства.
        необходимо условиться, что X и Y – это центр любого визуального объекта на канве.
        И, следовательно, удобно хранить не длину с шириной, а половину длины и половину ширины.
        А границы объекта, соответственно, будут отдаваться через геттеры и сеттеры.
     */

    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;


    protected float getLeft() {
        return x - halfWidth;
    }

    protected void setLeft(float left) {
        x = left + halfHeight;
    }


    protected float getRight() {
        return x + halfWidth;
    }

    protected void setRight(float right) {
        x = right - halfHeight;
    }


    protected float getTop() {
        return y - halfHeight;
    }

    protected void setTop(float top) {
        y = top + halfHeight;
    }


    protected float getBottom() {
        return y + halfHeight;
    }

    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }


    protected float getWidth() {
        return 2f * halfWidth;
    }


    protected float getHeight() {
        return 2f * halfHeight;
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
    }

}
