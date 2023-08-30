import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicatesGetter {
    public static <T> List<T> getDuplicates(List<T> inputList) {
        if (inputList == null) {
            return new ArrayList<>();
        }

        Map<T, Long> elementsCountMap = new HashMap<>();
        inputList.forEach(it -> elementsCountMap.merge(it, 1L, Long::sum));

        return elementsCountMap.entrySet()
                .stream().filter(x -> (x.getValue() > 1))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .keySet().stream().toList();
    }
}
