package ru.job4j.chess;

public class Pawn extends Figure{
    private final Cell position;

    public Pawn(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Pawn(dest);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (source.getY() + 1 == dest.getY() && source.getX() == dest.getX()) {
            steps = new Cell[] {dest};
        }
        if (source.getY() + 1 != dest.getY() && source.getX() != dest.getX()) {
            throw new ImpossibleMoveException("Impossible move!");
        }
        return steps;
    }
}