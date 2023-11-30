package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CorrectNumbersGenerator {
    private static final int SIZE_OF_CORRECT_NUMBERS = 3;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 9;

    public CorrectNumbers generate() {
        List<Integer> threeNumbers = new ArrayList<>();
        while (threeNumbers.size() < SIZE_OF_CORRECT_NUMBERS) {
            addNumbers(threeNumbers);
        }
        return new CorrectNumbers(threeNumbers);
    }

    private void addNumbers(List<Integer> threeNumbers) {
        int number = pickOneNumber();
        if (isUniqueNumber(threeNumbers, number)) {
            threeNumbers.add(number);
        }
    }

    private boolean isUniqueNumber(List<Integer> threeNumbers, int number) {
        return !threeNumbers.contains(number);
    }

    private int pickOneNumber() {
        return Randoms.pickNumberInRange(MINIMUM, MAXIMUM);
    }
}
