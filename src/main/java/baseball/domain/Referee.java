package baseball.domain;

import java.util.List;

public class Referee {
    private static final int FIRST_INDEX = 0;
    private static final int NUMBER_SIZE = 3;
    private static final int NO_COUNT = 0;

    public int countStrike(List<Integer> inputNumbers, List<Integer> correctNumbers) {
        int strike = NO_COUNT;
        for (int index = FIRST_INDEX; index < NUMBER_SIZE; index++) {
            if (hasSameNumberAtSamePlace(inputNumbers, correctNumbers, index)) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> inputNumbers, List<Integer> correctNumbers) {
        int ball = NO_COUNT;
        for (int index = FIRST_INDEX; index < NUMBER_SIZE; index++) {
            if (hasSameNumberAtOtherPlace(inputNumbers, correctNumbers, index)) {
                ball++;
            }
        }
        return ball;
    }

    private boolean hasSameNumberAtOtherPlace(List<Integer> inputNumbers, List<Integer> correctNumbers, int index) {
        return !hasSameNumberAtSamePlace(inputNumbers, correctNumbers, index)
                && correctNumbers.contains(inputNumbers.get(index));
    }

    private boolean hasSameNumberAtSamePlace(List<Integer> inputNumbers, List<Integer> correctNumbers, int index) {
        return inputNumbers.get(index).equals(correctNumbers.get(index));
    }
}
