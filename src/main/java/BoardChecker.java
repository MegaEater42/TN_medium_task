import java.util.HashSet;
import java.util.Set;

public class BoardChecker {
    private static boolean isSignificantDigit(char token, int maxBoardDigit) {
        return (token >= '1') && (token <= (maxBoardDigit + '0'));
    }

    private static boolean isValidCell(char token, int maxBoardDigit) {
        return isSignificantDigit(token, maxBoardDigit) || (token == '.');
    }

    private static void validateCells(Board board) {
        for(char[] row : board.getField()) {
            for(char token : row) {
                if (!isValidCell(token, board.getSize1D())) {
                    if (Character.isLetter(token)) {
                        throw new IllegalArgumentException("Board contains letters!");
                    }
                }
            }
        }
    }

    private static boolean isValidRow(char[] row, int maxBoardDigit) {
        Set<Character> rowSetOfChars = new HashSet<>();
        for (char token: row) {
            if (!(token == '.')) {
                if (isSignificantDigit(token, maxBoardDigit) && !rowSetOfChars.contains(token)) {
                    rowSetOfChars.add(token);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidColumn(Board board, int column) {
        Set<Character> columnSetOfChars = new HashSet<>();
        for (char[] row : board.getField()) {
            if (!(row[column] == '.')) {
                if (isSignificantDigit(row[column], board.getSize1D()) && !columnSetOfChars.contains(row[column])) {
                    columnSetOfChars.add(row[column]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidBoard(Board board) {
        validateCells(board);
        for(char[] row : board.getField()) {
            if (!isValidRow(row, board.getSize1D())) {
                return false;
            }
        }
        for (int i = 0; i < board.getSize1D(); i++) {
            if (!isValidColumn(board, i)){
                return false;
            }
        }
        return true;
    }
}
