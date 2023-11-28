package baseball.domain;

import java.util.List;

public class Referee {
    public int countStrike(List<Integer> inputNumbers, List<Integer> correctNumbers) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (hasSameNumberAtSamePlace(inputNumbers, correctNumbers, index)) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> inputNumbers, List<Integer> correctNumbers) {
        int ball = 0;
        for (int index = 0; index < 3; index++) {
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
