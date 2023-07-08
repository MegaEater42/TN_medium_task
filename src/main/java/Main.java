import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Программа выводит повторяющиеся элементы List на экран.");
        System.out.print("Вводите элементы List через пробел: ");
        BufferedReader bufferInput = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputList = new ArrayList<>(List.of(bufferInput.readLine().split(" ")));
        System.out.println("Повторяющиеся элементы в введённом List:");
        long count = 0;
        for(var it : DuplicatesGetter.getDuplicates(inputList)) {
            System.out.println(it);
            count++;
        }
        if(count == 0) {
            System.out.println("Отсутствуют!");
        }
    }
}
