package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PawnMoveTest {

    @Test
    public void whenPawnMoveValidThenReturnTrue() {
        Board board = new Board();
        Figure pawn = new Pawn(new Cell(2, 0));
        pawn.position().setFigure(pawn);
        boolean result = board.move(pawn.position(), new Cell(2, 1));
        assertThat(result, is(true));
    }
}