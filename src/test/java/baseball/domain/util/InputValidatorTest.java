package baseball.domain.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @DisplayName("입력값이 비었으면 예외가 발생한다.")
    @Test
    void createCaseInputIsEmpty() {
        // Given
        String inputNumbers = "";
        InputValidator validator = new InputValidator();

        // When, Then
        assertThatThrownBy(() -> validator.ensureInputHaveValues(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 세 자리가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"12", "1234"})
    @ParameterizedTest
    void createCaseInputHasWrongSize(String inputNumbers) {
        // Given
        InputValidator validator = new InputValidator();

        // When, Then
        assertThatThrownBy(() -> validator.ensureInputSize(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"abc", "12c"})
    @ParameterizedTest
    void createCateInputIsNotNumber(String inputNumbers) {
        // Given
        InputValidator validator = new InputValidator();

        // When, Then
        assertThatThrownBy(() -> validator.ensureInputHaveOnlyNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 1 또는 2가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"0", "3", "a", "게임시작", "게임종료"})
    @ParameterizedTest
    void createCateInputIsNotNumberOneOrTwo(String inputNumbers) {
        // Given
        InputValidator validator = new InputValidator();

        // When, Then
        assertThatThrownBy(() -> validator.validateDecision(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}