public class Main {
    public static void main(String[] args) {
        System.out.println("Программа проверяет матрицу 9 на 9 на валидность.");
        System.out.println("Вводите значения ячеек матрицы через пробел/перенос строки/т.п.:");
        Board board = new Board();
        board.fill();
        System.out.println("Введённая матрица:");
        board.print();
        if (BoardChecker.isValidBoard(board)) {
            System.out.println("Матрица валидна!");
        } else {
            System.out.println("Матрица не валидна!");
        }
    }
}
