package baseball.ui;

import baseball.ui.message.OutputMessage;

public class OutputView {
    private static final int NO_COUNT = 0;
    private static final int FULL_COUNT = 3;

    public void printHint(int strike, int ball) {
        printWhenNothing(strike, ball);
        printWhenCorrect(strike);
        printWhenOnlyStrike(strike, ball);
        printWhenOnlyBall(strike, ball);
        printWhenBallAndStrike(strike, ball);
    }

    private void printWhenNothing(int strike, int ball) {
        if (strike == NO_COUNT && ball == NO_COUNT) {
            System.out.println(OutputMessage.NOTHING);
        }
    }

    private void printWhenCorrect(int strike) {
        if (strike == FULL_COUNT) {
            System.out.printf(OutputMessage.STRIKE, strike);
            System.out.println();
            System.out.println(OutputMessage.CORRECT_ANSWER);
        }
    }

    private void printWhenOnlyStrike(int strike, int ball) {
        if (strike < FULL_COUNT && strike != NO_COUNT && ball == NO_COUNT) {
            System.out.printf(OutputMessage.STRIKE, strike);
            System.out.println();
        }
    }

    private void printWhenOnlyBall(int strike, int ball) {
        if (strike == NO_COUNT && ball != NO_COUNT) {
            System.out.printf(OutputMessage.BALL, ball);
            System.out.println();
        }
    }

    private void printWhenBallAndStrike(int strike, int ball) {
        if (strike != NO_COUNT && ball != NO_COUNT) {
            System.out.printf(OutputMessage.BALL_AND_STRIKE, ball, strike);
            System.out.println();
        }
    }
}
