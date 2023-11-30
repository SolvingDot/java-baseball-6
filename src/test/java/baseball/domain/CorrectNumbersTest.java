package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CorrectNumbersTest {
    @DisplayName("세 자리의 숫자가 아닐 경우 예외 발생")
    @Test
    void createCaseOverTheSizeOfNumbers() {
        // Given
        List<Integer> threeNumbers = List.of(1, 2, 3, 4);

        // When, Then
        assertThatThrownBy(() -> new CorrectNumbers(threeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1에서 9까지의 범위를 벗어난 숫자가 있는 경우 예외 발생")
    @Test
    void createCaseOverTheRangeOfNumbers() {
        // Given
        List<Integer> threeNumbers = List.of(1, 0, 3);

        // When, Then
        assertThatThrownBy(() -> new CorrectNumbers(threeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있는 경우 예외 발생")
    @Test
    void createCaseHaveDuplicatedNumbers() {
        // Given
        List<Integer> threeNumbers = List.of(1, 1, 2);

        // When, Then
        assertThatThrownBy(() -> new CorrectNumbers(threeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}