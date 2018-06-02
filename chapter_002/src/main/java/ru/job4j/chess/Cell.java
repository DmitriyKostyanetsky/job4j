package ru.job4j.chess;

/**
 * Класс описывает ячейки шахматной доски
 */
public class Cell {
    private int x;
    private int y;
    private Figure figure;

    /**
     * Конструктор для установления позиции
     * @param x ячейка х
     * @param y ячейка y
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Cell;
    }

    /**
     * Сеттер для установления позиции
     * @param x координата х
     * @param y координата y
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Геттер для получения координаты х
     * @return возвращает координату х
     */
    public int getX() {
        return this.x;
    }

    /**
     * Геттер для получения координаты у
     * @return возвращает координату у
     */
    public int getY() {
        return this.y;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure setFigure) {
        this.figure = setFigure;
    }
}
