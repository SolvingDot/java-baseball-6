package baseball.domain;

import baseball.domain.util.NumbersValidator;
import java.util.List;

public class CorrectNumbers {
    private final List<Integer> correctNumbers;

    public CorrectNumbers(List<Integer> threeNumbers) {
        validate(threeNumbers);
        this.correctNumbers = threeNumbers;
    }

    public List<Integer> getCorrectNumbers() {
        return correctNumbers;
    }

    private void validate(List<Integer> threeNumbers) {
        NumbersValidator validator = new NumbersValidator();
        validator.ensureSizeOfNumbers(threeNumbers);
        validator.ensureRangeOfDigits(threeNumbers);
        validator.ensureEachDifferentNumbers(threeNumbers);
    }
}
