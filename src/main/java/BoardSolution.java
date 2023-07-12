import java.util.*;

public class BoardSolution {
    private static final int BOARD_SIZE = 9;

    private static boolean isSignificantDigit(char token) {
        return (token >= '1') && (token <= '9');
    }

    private static boolean isValidCell(char token) {
        return isSignificantDigit(token) || (token == '.');
    }

    private static void validateCells(char[][] board) {
        for(char[] row : board) {
            for(char token : row) {
                if (!isValidCell(token)) {
                    if (Character.isLetter(token)) {
                        throw new IllegalArgumentException("Board contains letters!");
                    }
                }
            }
        }
    }

    private static void validateSizes(char[][] board) {
        if (board.length != BOARD_SIZE) {
            throw new IllegalArgumentException("Board's height isn't 9!");
        }
        for(char[] row : board) {
            if(row.length != BOARD_SIZE) {
                throw new IllegalArgumentException("One of the board's rows size isn't 9!");
            }
        }
    }
    private static boolean isValidRow(char[] row) {
        Set<Character> rowSetOfChars = new HashSet<>();
        for (char token: row) {
            if (!(token == '.')) {
                if (isSignificantDigit(token) && !rowSetOfChars.contains(token)) {
                    rowSetOfChars.add(token);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int column) {
        Set<Character> columnSetOfChars = new HashSet<>();
        for (char[] row : board) {
            if (!(row[column] == '.')) {
                if (isSignificantDigit(row[column]) && !columnSetOfChars.contains(row[column])) {
                    columnSetOfChars.add(row[column]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidBoard(char[][] board) {
        validateSizes(board);
        validateCells(board);
        for(char[] row : board) {
            if (!isValidRow(row)) {
                return false;
            }
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (!isValidColumn(board, i)){
                return false;
            }
        }
        return true;
    }
}
