package baseball.domain.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConverterTest {
    @DisplayName("입력 받은 3자리 숫자를 한 자리씩 나누어 담는다.")
    @Test
    void convertInputToNumbersTest() {
        // Given
        String inputNumbers = "123";

        // When
        InputConverter converter = new InputConverter();
        List<Integer> NumbersOfPlayer = converter.convertInputToNumbers(inputNumbers);
        
        // Then
        assertThat(NumbersOfPlayer).isEqualTo(List.of(1, 2, 3));
    }
}