package ru.job4j.chess;

/**
 * Класс описывает абстрактное поведение шахматной доски
 */
public abstract class Figure {
    public abstract Cell position();

    /**
     * Метод задает ячейку куда нужно пойти
     * @param source начальная ячейка где стоит фигура
     * @param dest клетка на которую нужно пойти
     * @return возвращает массив ячеек, которая должна пройти  фигура
     * @throws ImpossibleMoveException исключение, что фигура не может туда пойти
     */
    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * Метод создает новый объект Figure с координатой dest
     * @param dest новая координата
     * @return возвращает фигуру с новой координатой
     */
    public abstract Figure copy(Cell dest);
}
