package baseball.util;

import baseball.ui.message.ErrorMessage;
import java.util.List;

public class NumbersValidator {
    private static final int SIZE_OF_CORRECT_NUMBERS = 3;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 9;

    public void ensureSizeOfNumbers(List<Integer> threeNumbers) {
        if (threeNumbers.size() != SIZE_OF_CORRECT_NUMBERS) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_OF_NUMBER.getMessage());
        }
    }

    public void ensureRangeOfDigits(List<Integer> threeNumbers) {
        if (!threeNumbers.stream().allMatch(digit -> digit >= MINIMUM && digit <= MAXIMUM)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    public void ensureEachDifferentNumbers(List<Integer> threeNumbers) {
        if (!haveUniqueDigits(threeNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    private boolean haveUniqueDigits(List<Integer> threeNumbers) {
        return threeNumbers.size() == threeNumbers.stream().distinct().count();
    }
}
