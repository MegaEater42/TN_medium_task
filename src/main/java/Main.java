import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа проверяет матрицу 9 на 9 на валидность.");
        System.out.println("Вводите значения ячеек матрицы через пробел/еренос строки/т.п.:");
        char[][] board = new char[9][9];
        try (BufferedReader bufferInput = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine;
            int cells = 0;
            while ((inputLine = bufferInput.readLine()) != null && (inputLine.length() != 0)) {
                List<String> listOfCells = List.of(inputLine.split(" "));
                int i = 0;
                while(i < listOfCells.size() && (cells < 81)) {
                    board[cells / 9][cells++ % 9] = listOfCells.get(i++).toCharArray()[0];
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введённая матрица:");
        for(int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        if (BoardSolution.isValidBoard(board)) {
            System.out.println("Матрица валидна!");
        } else {
            System.out.println("Матрица не валидна!");
        }
    }
}
