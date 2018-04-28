package ru.job4j.chess;

public class Board {
    Figure[] figures = new Figure[32];
    private final int sizeBoard;
    private final Cell[][] cels;

    /**
     * Конструктор доски
     */
    public Board() {
        this.sizeBoard = 8;
        this.cels = createBoard();
    }

    /**
     * Создание ячеек
     * @return возвращает шахматную доску 8х8
     */
    private Cell[][] createBoard() {
        Cell[][] board = new Cell[sizeBoard][sizeBoard];
        for (int i = 0; i < this.sizeBoard; i++) {
            for (int j = 0; j < this.sizeBoard; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
        return board;
    }

    /**
     * Метод проверяет возможность движения по ряду условий
     * @param source начальная ячейка где стоит фигура
     * @param dest клетка на которую нужно пойти
     * @return возвращает true если условия выполнены
     * @throws ImpossibleMoveException исключение, что фигура не может туда пойти
     * @throws FigureNotFoundException исключение, что фигура не найдена
     * @throws OccupiedWayException исключение, что полученный путь не занят другими фигурами
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {
        if (source.getFigure() == null) {
            throw new FigureNotFoundException("Figure not found!");
        }
        Figure moveFig = source.getFigure();
        Cell[] arrWay = moveFig.way(source, dest);
        for (Cell current : arrWay) {
            if (current != source) {
                if (current.getFigure() != null) {
                    throw new OccupiedWayException("Way is occupied!");
                }
            }
        }
        source.setFigure(null);
        dest.setFigure(moveFig);
        return true;
    }

    /**`
     * Возвращает ячейки игрового поля.
     * @return масси ячеек
     */
    public Cell[][] getCells() {
        return cels;
    }
}