package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {
    @Test
    void whenPositionTestIsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        assertThat(bishopBlack.position()).isEqualTo(Cell.F1);
    }

    @Test
    void whenCopyTestIsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        assertThat(bishopBlack.copy(Cell.D3).position()).isEqualTo(Cell.D3);
    }

    @Test
    void whenWayTestIsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps = new Cell[4];
        steps = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).containsAll(Arrays.asList(steps));
    }

    @Test
    void whenWayTestNotCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C2);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.G5)
        );
        String expected = "Could not move by diagonal from C2 to G5";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}