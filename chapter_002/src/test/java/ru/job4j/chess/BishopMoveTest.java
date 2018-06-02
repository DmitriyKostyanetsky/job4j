package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopMoveTest {
    private Board board;
    private Figure bishop;

    @Before
    public void setUp() {
        board = new Board();
        bishop = new Bishop(new Cell(4, 2));
        bishop.position().setFigure(bishop);
    }

    @Test
    public void whenBishopMoveUpLeftValidThenReturnTrue() {
        Cell newPosition = new Cell(1, 5);
        Cell[] result = bishop.way(bishop.position(), newPosition);
        Cell[] expect = new Cell[] {new Cell(3, 3), new Cell(2, 4), new Cell(1, 5)};
        boolean checkMove = board.move(bishop.position(), newPosition);
        assertThat(checkMove, is(true));
        assertThat(result, is(expect));
    }

    @Test
    public void whenBishopMoveUpRightValidThenReturnTrue() {
        Cell newPosition = new Cell(7, 5);
        Cell[] result = bishop.way(bishop.position(), newPosition);
        Cell[] expect = new Cell[] {new Cell(5, 3), new Cell(6, 4), new Cell(7, 5)};
        boolean checkMove = board.move(bishop.position(), newPosition);
        assertThat(checkMove, is(true));
        assertThat(result, is(expect));
    }

    @Test
    public void whenBishopMoveDownRightValidThenReturnTrue() {
        Cell newPosition = new Cell(6, 0);
        Cell[] result = bishop.way(bishop.position(), newPosition);
        Cell[] expect = new Cell[] {new Cell(5, 1), new Cell(6, 0)};
        boolean checkMove = board.move(bishop.position(), newPosition);
        assertThat(checkMove, is(true));
        assertThat(result, is(expect));
    }

    @Test
    public void whenBishopMoveDownLeftValidThenReturnTrue() {
        Cell newPosition = new Cell(2, 0);
        Cell[] result = bishop.way(bishop.position(), newPosition);
        Cell[] expect = new Cell[] {new Cell(3, 1), new Cell(2, 0)};
        boolean checkMove = board.move(bishop.position(), newPosition);
        assertThat(checkMove, is(true));
        assertThat(result, is(expect));
    }
}