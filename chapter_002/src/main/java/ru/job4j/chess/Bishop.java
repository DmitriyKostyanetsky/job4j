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

    /**
     * Метод убирает null элементы из массива ячеек
     * @param arr массив с null
     * @return массив без null
     */
    private Cell[] arrayWithoutZeros(Cell[] arr) {
        int nonZeros = 0;

        for (Cell anArr1 : arr) {
            if (anArr1 != null) {
                nonZeros++;
            }
        }
        Cell[] result = new Cell[nonZeros];
        System.arraycopy(arr, 0, result, 0, nonZeros);

        return result;
    }

    /**
     * Метод определяет куда движется фигура и записывает координаты ячеек
     * @param source начальная координата
     * @param dest конечная координата
     * @return возвращает массив ячеек
     */
    private Cell[] checkMoveOfFigure(Cell source, Cell dest) {
        Cell[] coordinates = new Cell[7];
        int numberOfCell = Math.abs(source.getY() - dest.getY());
        int currentGetX = source.getX();
        int currentGetY = source.getY();
        int deltaXY = Integer.compare(source.getX() - dest.getX(), source.getY() - dest.getY());

        for (int i = 0; i != numberOfCell; i++) {
            if (deltaXY == 1) {
                coordinates[i] = new Cell(--currentGetX, ++currentGetY);
                continue;
            }
            if (deltaXY == -1) {
                coordinates[i] = new Cell(++currentGetX, --currentGetY);
                continue;
            }
            if (deltaXY == 0) {
                if (source.getX() < dest.getX()) {
                    coordinates[i] = new Cell(++currentGetX, ++currentGetY);
                }
                if (source.getX() > dest.getX()) {
                    coordinates[i] = new Cell(--currentGetX, --currentGetY);
                }
            }
        }
        return arrayWithoutZeros(coordinates);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[7];
        if (Math.abs(source.getY() - dest.getY()) == Math.abs(source.getX() - dest.getX())) {
            steps = checkMoveOfFigure(source, dest);
        }
        if (Math.abs(source.getY() - dest.getY()) != Math.abs(source.getX() - dest.getX())) {
            throw new ImpossibleMoveException("Impossible move!");
        }
        return steps;
    }
}