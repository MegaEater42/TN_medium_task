public class BinarySearch {
    private static int binarySearchInner(int[] sortedArr, int fromIndex, int toIndex, int key) {
        if (sortedArr.length == 0) {
            return -1;
        }

        int lowIndex = fromIndex;
        int highIndex = toIndex - 1;

        while(lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) >>> 1;
            if(sortedArr[middleIndex] < key) {
                lowIndex = middleIndex + 1;
            } else {
                if(sortedArr[middleIndex] > key) {
                    highIndex = middleIndex - 1;
                } else {
                    return middleIndex;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int[] sortedArr, int key) {
        if (sortedArr == null) {
            return -1;
        }
        return binarySearchInner(sortedArr, 0, sortedArr.length, key);
    }

    private static void rangeCheck(int arrLength, int fromIndex, int toIndex) {
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
    }

    public static int binarySearch(int[] sortedArr, int fromIndex, int toIndex, int key) {
        if (sortedArr == null) {
            return -1;
        }
        rangeCheck(sortedArr.length, fromIndex, toIndex);
        return binarySearchInner(sortedArr, fromIndex, toIndex, key);
    }
}