package ru.gb.jdk.two.online.sprites;

import ru.gb.jdk.two.online.Interactable;
import ru.gb.jdk.two.online.MainCanvas;

import java.awt.*;

public class Background implements Interactable {
    /*todo
        Фон, как наследник спрайта
     */
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    @Override
    void update(MainCanvas canvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);

    }
    @Override
    void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}
