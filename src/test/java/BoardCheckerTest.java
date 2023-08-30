import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoardCheckerTest {
    private static Stream<Arguments> isValidBoardParameterizedTestCases() {
        return Stream.of(
                Arguments.of(new Board(9, new char[][]{
                        new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }), true),
                Arguments.of(new Board(9, new char[][]{
                        new char[]{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                        new char[]{'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                        new char[]{'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                        new char[]{'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                        new char[]{'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                        new char[]{'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                        new char[]{'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                        new char[]{'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                        new char[]{'3', '4', '5', '2', '8', '6', '1', '7', '9'}
                }), true)
        );
    }

    @ParameterizedTest
    @MethodSource("isValidBoardParameterizedTestCases")
    public void isValidBoardTest(Board actual, boolean expected) {
        assertEquals(expected, BoardChecker.isValidBoard(actual));
    }

    @Test
    public void isValidBoardThrowHeightExceptionWhenGetWrongHeightBoardTest() {
        IllegalArgumentException thrown = assertThrows (
                IllegalArgumentException.class,
                () -> new Board(9, new char[][] {new char[]{'.'}})
        );
        assertTrue(thrown.getMessage().contains("Board's height isn't 9!"));
    }
    @Test
    public void isValidBoardThrowWidthExceptionWhenGetWrongWidthBoardTest() {
        IllegalArgumentException thrown = assertThrows (
                IllegalArgumentException.class,
                () -> new Board(9, new char[][] {
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                })
        );
        assertTrue(thrown.getMessage().contains("One of the board's rows size isn't 9!"));
    }
    @Test
    public void isValidBoardThrowLettersExceptionWhenGetBoardWithLettersTest() {
        Board board = new Board(9, new char[][] {
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', 'F', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        });
        IllegalArgumentException thrown = assertThrows (
                IllegalArgumentException.class,
                () -> BoardChecker.isValidBoard(board)
        );
        assertTrue(thrown.getMessage().contains("Board contains letters!"));
    }
}