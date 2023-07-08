import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DuplicatesGetter {
    public static <T> List<T> getDuplicates(List<T> inputList) {
        if (inputList == null) {
            return new ArrayList<>();
        }

        Map<T, Long> elementsCountMap = new HashMap<>();
        inputList.forEach(it -> elementsCountMap.merge(it, 1L, Long::sum));

        List<T> duplicatesList = new ArrayList<>();
        elementsCountMap.forEach((key, value) -> duplicatesList.add((value > 1)? key : null));
        duplicatesList.removeIf(Objects::isNull);
        return duplicatesList;
    }
}
