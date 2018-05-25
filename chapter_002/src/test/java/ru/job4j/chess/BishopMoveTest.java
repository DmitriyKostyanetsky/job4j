package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopMoveTest {
    @Test
    public void whenBishopMoveValidThenReturnTrue() {
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(0, 0));
        bishop.position().setFigure(bishop);
        boolean result = board.move(bishop.position(), new Cell(7, 7));
        assertThat(result, is(true));
    }

    @Test
    public void whenBishopMoveUpLeftValidThenReturnTrue() {
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(4, 2));
        bishop.position().setFigure(bishop);
        boolean result = board.move(bishop.position(), new Cell(1, 5));
        assertThat(result, is(true));
    }

    @Test
    public void whenBishopMoveUpRightValidThenReturnTrue() {
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(4, 2));
        bishop.position().setFigure(bishop);
        boolean result = board.move(bishop.position(), new Cell(7, 5));
        assertThat(result, is(true));
    }

    @Test
    public void whenBishopMoveDownRightValidThenReturnTrue() {
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(4, 2));
        bishop.position().setFigure(bishop);
        boolean result = board.move(bishop.position(), new Cell(6, 0));
        assertThat(result, is(true));
    }

    @Test
    public void whenBishopMoveDownLeftValidThenReturnTrue() {
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(4, 2));
        bishop.position().setFigure(bishop);
        boolean result = board.move(bishop.position(), new Cell(2, 0));
        assertThat(result, is(true));
    }
}