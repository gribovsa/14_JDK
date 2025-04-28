package ru.gb.jdk.one.online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/*todo
    Панель с полем боя.
    Основные графические интерактивности в демонстрационном
    приложении будут сделаны именно на панели. Такую панель с достаточно большой
    функциональностью логично выделить в отдельный класс.
 */
public class Map extends JPanel {

    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 5;

    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    public static final String MSG_WIN_AI = "Победил компьютер!";
    public static final String MSG_DRAW = "Ничья!";


    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private char[][] field;

    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;

    private boolean isGameOver;
    private boolean isInitialized;


    Map() {
        setBackground(Color.LIGHT_GRAY); //создали панель фон светлосерый, разместим её на основном экране GameWindow
        //Обработчик действий мышки
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e); //метод пользователя
            }
        });
        isInitialized = false;
    }


    private void update(MouseEvent e) {
        //пользовательский метод обработки действий мыши,
        //берём координаты и делаем ход
        if(isGameOver || !isInitialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return; //делаем ход
        field[cellY][cellX] = HUMAN_DOT;


        //последние проверки
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }


    private boolean checkEndGame(int dot, int gameOverType) {
        //проверка конца игры
        if (checkWin(dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;

    }


    private void initMap() {
        /*
        Метод инициализации поля – создаётся новый массив и заполняется пустыми
        символами. Его вызов логично сразу разместить в метод старта новой игры.
         */
        fieldSizeY = 3;
        fieldSizeX = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }


    private boolean isValidCell(int x, int y) {
        /*
        Когда кто-то (игрок или компьютер) будет совершать ход, будет важно, попал ли
        игрок в какую-то ячейку поля
         */
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }


    private boolean isEmptyCell(int x, int y) {
        /*
        Когда кто-то (игрок или компьютер) будет совершать ход, будет важно,
        пустота ли она, потому что нельзя ставить крестик
        поверх нолика и наоборот.
         */
        return field[y][x] == EMPTY_DOT;
    }


    private void aiTurn() {
        /*
        Компьютер будет очень примитивный – он будет делать ход в случайные места на
        карте.
         */
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX); //берет координату рандомной ячейки по х
            y = RANDOM.nextInt(fieldSizeY); //берет координату рандомной ячейки по y
        } while (!isEmptyCell(x, y)); //если ячейка не пуста, то ставим значение (AI_DOT=2 т.е ставит компьютер)
        field[y][x] = AI_DOT;
    }


    private boolean checkWin(int c) {
        /*
        Проверка победы одного из игроков
         */
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[1][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    private boolean isMapFull() {
        /*
        Проверка на ничью
         */
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }


    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        //В качестве параметров метод должен принимать какие-то начальные настройки
        //самой игры. Например, будут два режима игры, компьютер против игрока и игрок
        //против игрока, размер поля, число крестиков или ноликов, расположенных подряд
        //на одной прямой для победы
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d", mode, fSzX, fSzY, wLen);

        initMap();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }


    //Рисование

    //Переопределяем родительский стандартный метод рисования
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g); //вызываем пользовательское рисование
    }


    //метод пользовательского рисования
    private void render(Graphics g) {

        if(!isInitialized) return;

        panelWidth = getWidth();
        panelHeight = getWidth();
        cellHeight = panelHeight / 3;
        cellWidth = panelWidth / 3;

        g.setColor(Color.BLACK);
        for (int h = 0; h < 3; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y); //рисуем 3 вертикальные линии
        }

        for (int w = 0; w < 3; w++) {
            int x = w * cellHeight;
            g.drawLine(x, 0, x, panelHeight); //рисуем 3 горизонтальные линии
        }


        //выполняется отрисовка поля (красного или синего кружочка)
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;

                if (field[y][x] == HUMAN_DOT) { //если человек
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING, cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT) { //если машина
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING, cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] + " in cell: x=" + x + " y=" + y);
                }
            }
        }
        repaint();


        repaint();

        if(isGameOver) showMessageGameOver(g);
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW -> {
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            }
            case STATE_WIN_AI -> {
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
                break;
            }
            case STATE_WIN_HUMAN -> {
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            }
            default -> throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
        }
    }


}
