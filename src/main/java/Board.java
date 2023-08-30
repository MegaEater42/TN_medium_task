import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Board {
    public final static int BASE_BOARD_SIZE_1D = 9;

    private final int size1D;
    private final char[][] field;

    public Board() {
        this.field = new char[BASE_BOARD_SIZE_1D][BASE_BOARD_SIZE_1D];
        this.size1D = BASE_BOARD_SIZE_1D;
    }

    public Board(int size1D) {
        this.field = new char[size1D][size1D];
        this.size1D = size1D;
    }

    private static void validateSizes(int size, char[][] field) {
        if (field.length != size) {
            throw new IllegalArgumentException("Board's height isn't " + size + "!");
        }
        for(char[] row : field) {
            if(row.length != size) {
                throw new IllegalArgumentException("One of the board's rows size isn't " + size + "!");
            }
        }
    }

    public Board(int size, char[][] field) {
        validateSizes(size, field);
        this.field = new char[size][size];
        for (int i = 0; i < size; i++) {
            this.field[i] = Arrays.copyOf(field[i], size);
        }
        this.size1D = size;
    }

    public int getSize1D(){
        return this.size1D;
    }

    public char[][] getField(){
        return this.field;
    }
    public void fill() {
        try (BufferedReader bufferInput = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine;
            int cells = 0;
            int fieldArea = this.size1D * this.size1D;
            while ((inputLine = bufferInput.readLine()) != null && (inputLine.length() != 0)) {
                List<String> listOfCells = List.of(inputLine.split(" "));
                int i = 0;
                while(i < listOfCells.size() && (cells < fieldArea)) {
                    this.field[cells / this.size1D][cells++ % this.size1D] = listOfCells.get(i++).toCharArray()[0];
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for(int i = 0; i < this.size1D; i++) {
            System.out.println(Arrays.toString(field[i]));
        }
    }


}
