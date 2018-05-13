package ru.job4j.chess;

public class Bishop extends Figure {
    private final Cell position;

    public Bishop(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            steps = new Cell[] {dest};
        }
        if (Math.abs(source.getX() - dest.getX()) != Math.abs(source.getY() - dest.getY())) {
            throw new ImpossibleMoveException("Impossible move!");
        }
        return steps;
    }
}