import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа реализует алгоритм бинарного поиска в массиве целых.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива целых: ");
        int arrLength = scanner.nextInt();
        int[] arr = new int[arrLength];
        System.out.println("Введите массив целых: ");
        for (int i = 0; i < arrLength; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
        System.out.print("Введите искомое целое: ");
        int key = scanner.nextInt();
        System.out.print("Введите начальный индекс: ");
        int fromIndex = scanner.nextInt();
        System.out.print("Введите конечный индекс: ");
        int toIndex = scanner.nextInt();
        int result = BinarySearch.binarySearch(arr, fromIndex, toIndex, key);
        if ((result >= 0)) {
            System.out.println("Первое искомое целое находится в массиве под индексом " + result);
        } else {
            System.out.println("Искомое целое не найдено!");
        }
    }
}