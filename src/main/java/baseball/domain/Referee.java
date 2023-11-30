package baseball.domain;

import java.util.List;

public class Referee {
    private static final int FIRST_INDEX = 0;
    private static final int NUMBER_SIZE = 3;
    private static final int NO_COUNT = 0;

    public int countStrike(List<Integer> NumbersOfPlayer, List<Integer> correctNumbers) {
        int strike = NO_COUNT;
        for (int index = FIRST_INDEX; index < NUMBER_SIZE; index++) {
            if (isSameAtSamePlace(NumbersOfPlayer, correctNumbers, index)) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> NumbersOfPlayer, List<Integer> correctNumbers) {
        int ball = NO_COUNT;
        for (int index = FIRST_INDEX; index < NUMBER_SIZE; index++) {
            if (isSameAtOtherPlace(NumbersOfPlayer, correctNumbers, index)) {
                ball++;
            }
        }
        return ball;
    }

    private boolean isSameAtOtherPlace(List<Integer> NumbersOfPlayer, List<Integer> correctNumbers, int index) {
        return !isSameAtSamePlace(NumbersOfPlayer, correctNumbers, index)
                && correctNumbers.contains(NumbersOfPlayer.get(index));
    }

    private boolean isSameAtSamePlace(List<Integer> NumbersOfPlayer, List<Integer> correctNumbers, int index) {
        return NumbersOfPlayer.get(index).equals(correctNumbers.get(index));
    }
}
