import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.Random;

class BinarySearchTest {
    private static int randomValue;
    private static int randomArrUnknownValue;
    private static int randomArrExceptIndex;
    private static int randomArrFromIndex;
    private static int randomArrToIndex;
    private static int[] nullArr;
    private static int[] emptyArr;
    private static final int RANDOM_ARR_LENGTH = 100;
    private static int[] randomArr;

    @BeforeAll
    static void setUp() {
        Random randomIntGenerator = new Random();

        randomValue = randomIntGenerator.nextInt();

        nullArr = null;
        emptyArr = new int[0];

        randomArr = new int[RANDOM_ARR_LENGTH];
        for(int i = 0; i < RANDOM_ARR_LENGTH; i++) {
            randomArr[i] = randomIntGenerator.nextInt();
        }
        Arrays.sort(randomArr);

        randomArrFromIndex = randomIntGenerator.nextInt(RANDOM_ARR_LENGTH);
        randomArrToIndex = randomIntGenerator.nextInt(RANDOM_ARR_LENGTH);
        if (randomArrFromIndex > randomArrToIndex) {
            int tmp = randomArrFromIndex;
            randomArrFromIndex = randomArrToIndex;
            randomArrToIndex = tmp;
        }

        randomArrUnknownValue = randomArr[randomIntGenerator.nextInt(randomArrFromIndex, randomArrToIndex)];
        randomArrExceptIndex = Arrays.binarySearch(randomArr, randomArrUnknownValue);
    }

    @Test
    void testBinarySearch() {
        Assertions.assertEquals(-1, BinarySearch.binarySearch(emptyArr, randomValue));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(emptyArr, 0, 0, randomValue));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(nullArr, randomValue));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(nullArr, 0, 0, randomValue));
        Assertions.assertEquals(randomArrExceptIndex, BinarySearch.binarySearch(randomArr, randomArrUnknownValue));
        Assertions.assertEquals(randomArrExceptIndex, BinarySearch.binarySearch(randomArr, randomArrFromIndex, randomArrToIndex, randomArrUnknownValue));
    }

    @Test
    void testBinarySearchArrayIndexOutOfBounds() throws IndexOutOfBoundsException {
        IndexOutOfBoundsException thrownFromEmptyArrFromLessThanZero = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> BinarySearch.binarySearch(emptyArr, -1, Integer.MAX_VALUE, randomValue)
        );
        IndexOutOfBoundsException thrownFromEmptyArrToMoreThanLength = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> BinarySearch.binarySearch(emptyArr, Integer.MAX_VALUE, 1, randomValue)
        );
        IndexOutOfBoundsException thrownFromRandomArrFromLessThanZero = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> BinarySearch.binarySearch(randomArr, -2, randomArrToIndex, randomArrUnknownValue)
        );
        IndexOutOfBoundsException thrownFromRandomArrToMoreThanLength = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> BinarySearch.binarySearch(randomArr, randomArrFromIndex, Integer.MAX_VALUE, randomArrUnknownValue)
        );
        Assertions.assertTrue(thrownFromEmptyArrFromLessThanZero.getMessage().contains("Array index out of range: -1"));
        Assertions.assertTrue(thrownFromEmptyArrToMoreThanLength.getMessage().contains("Array index out of range: " + 1));
        Assertions.assertTrue(thrownFromRandomArrFromLessThanZero.getMessage().contains("Array index out of range: -2"));
        Assertions.assertTrue(thrownFromRandomArrToMoreThanLength.getMessage().contains("Array index out of range: " + Integer.MAX_VALUE));
    }

    @Test
    void testBinarySearchIllegalArgument() {
        IllegalArgumentException thrownFromEmptyArr = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BinarySearch.binarySearch(emptyArr, 1, 0, randomValue)
        );
        IllegalArgumentException thrownFromRandomArr = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BinarySearch.binarySearch(randomArr, randomArrToIndex, randomArrFromIndex, randomArrUnknownValue)
        );
        Assertions.assertTrue(thrownFromEmptyArr.getMessage().contains("fromIndex(" + 1 + ") > toIndex(" + 0 + ")"));
        Assertions.assertTrue(thrownFromRandomArr.getMessage().contains("fromIndex(" + randomArrToIndex + ") > toIndex(" + randomArrFromIndex + ")"));
    }
}