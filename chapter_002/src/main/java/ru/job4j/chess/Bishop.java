package ru.job4j.chess;

public class Bishop extends Figure {

    /**
     * Конструктор фигуры Слон
     * @param x
     * @param y
     */
    public Bishop(int x, int y) {
        super(x, y);
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest.getX(), dest.getY());
    }


    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int numberX = Math.abs(dest.getX() - source.getX()); //length X
        int numberY = Math.abs(dest.getY() - source.getY()); //length Y
        if (numberX != numberY) {
            throw new ImpossibleMoveException("Impossible move!");
        }
        return new Cell [numberX];
    }
}