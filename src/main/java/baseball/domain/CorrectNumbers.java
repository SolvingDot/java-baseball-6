package baseball.domain;

import java.util.List;

public class CorrectNumbers {
    private static final int SIZE_OF_CORRECT_NUMBERS = 3;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 9;
    private static final String NUMERIC_WITHOUT_ZERO = "^[1-9]*$";

    private final List<Integer> correctNumbers;

    public CorrectNumbers(List<Integer> threeNumbers) {
        validate(threeNumbers);
        this.correctNumbers = threeNumbers;
    }

    private void validate(List<Integer> threeNumbers) {
        ensureSizeOfNumbers(threeNumbers);
        ensureRangeOfDigits(threeNumbers);
        ensureDifferentNumbers(threeNumbers);
    }

    private void ensureSizeOfNumbers(List<Integer> threeNumbers) {
        if (threeNumbers.size() != SIZE_OF_CORRECT_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    private void ensureRangeOfDigits(List<Integer> threeNumbers) {
        if (threeNumbers.stream().allMatch(digit -> digit >= MINIMUM && digit <= MAXIMUM)) {
            throw new IllegalArgumentException();
        }
    }

    private void ensureDifferentNumbers(List<Integer> threeNumbers) {
        if (!haveUniqueDigits(threeNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean haveUniqueDigits(List<Integer> threeNumbers) {
        return threeNumbers.size() == threeNumbers.stream().distinct().count();
    }

    public List<Integer> getCorrectNumbers() {
        return correctNumbers;
    }
}
