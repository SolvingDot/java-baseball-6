package baseball.domain.util;

import baseball.ui.message.ErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    private static final String RESTRAT = "1";
    private static final String GAME_OVER = "2";
    private static final int SIZE_OF_CORRECT_NUMBERS = 3;

    public void ensureInputHaveValues(String inputNumbers) {
        if (inputNumbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.getMessage());
        }
    }

    public void ensureInputSize(String inputNumbers) {
        if (inputNumbers.length() != SIZE_OF_CORRECT_NUMBERS) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_OF_NUMBER.getMessage());
        }
    }

    public void ensureInputHaveOnlyNumbers(String inputNumbers) {
        if (!NUMERIC_PATTERN.matcher(inputNumbers).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public void validateDecision(String decision) {
        if (!canBeONlyOneOrTwo(decision)) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_ONE_OR_TWO.getMessage());
        }
    }

    private boolean canBeONlyOneOrTwo(String decision) {
        return decision.equals(RESTRAT) || decision.equals(GAME_OVER);
    }
}
