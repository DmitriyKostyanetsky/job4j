package ru.job4j.chess;

public class Board {
    Figure[] figures = new Figure[32];
    private Cell[][] board = new Cell[8][8];

    /**
     * Конструктор Board
     */
    public Board() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                this.board[i][j] = new Cell(i, j);
            }
        }
    }

    /**
     * Метод добавляет фигуру
     * @param figure добавляемая фигура
     * @return возвращает добавленную фигуру
     */
    public Figure add(Figure figure) {
        return figure;
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
        //Координата начальной позиции фигуры
        Cell sourceFigure = board[source.getY() - 1][source.getX() - 1];
        //Координата конечной позиции фигуры
        Cell destFigure = board[dest.getY() - 1][dest.getX() - 1];

        if (sourceFigure == null) {
            throw new FigureNotFoundException("Figure not found!");
        }
        if (source.getX() < 0 || source.getX() > 7 || source.getY() < 0 || source.getY() > 7 || dest.getX() < 0 || dest.getX() > 7 || dest.getY() < 0 || dest.getY() > 7) {
            throw new ImpossibleMoveException("Impossible move!");
        }
        if (destFigure != null) {
            throw new OccupiedWayException("Way is occupied!");
        }
        return true;
    }
}