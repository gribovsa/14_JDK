package ru.gb.jdk.two.online;

import java.awt.*;
/*todo
    Интерфейс слушателя событий канвы
    который будет уметь ожидать от канвы вызов метода и реализовывать его.
 */

public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
