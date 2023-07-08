import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class DuplicatesGetterTest {
    @Test
    public void getDuplicatesReturnsEmptyListForNull() {
        Assertions.assertEquals(new ArrayList<>(), DuplicatesGetter.getDuplicates(null));
    }

    @Test
    public <T> void getDuplicatesReturnsEmptyListForEmptyList() {
        Assertions.assertEquals(new ArrayList<>(), DuplicatesGetter.getDuplicates(new ArrayList<T>()));
    }

    private static Stream<Arguments> getDuplicatesParameterizedTestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 1, 2, 5, 7, 7, 17, 2), List.of(1, 2, 7)),
                Arguments.of(List.of("lamp", "camp", "dump", "camp"), List.of("camp")),
                Arguments.of(List.of(1, 2, 5, 7, 17), new ArrayList<>()),
                Arguments.of(List.of('t', 'n', 't', 'a', 'b', 'c', 'n'), List.of('t', 'n'))
        );
    }

    @ParameterizedTest
    @MethodSource("getDuplicatesParameterizedTestCases")
    public <T> void getDuplicatesParameterizedTest(List<T> inputList, List<T> expectedList) {
        Assertions.assertEquals(expectedList, DuplicatesGetter.getDuplicates(inputList));
    }
}