package baseball.ui;

import baseball.ui.message.OutputMessage;

public class OutputView {
    private static final int NO_COUNT = 0;
    private static final int FULL_COUNT = 3;

    public void printHint(int strike, int ball) {
        if (strike == NO_COUNT && ball == NO_COUNT) {
            System.out.println(OutputMessage.NOTHING);
        }
        if (strike == FULL_COUNT) {
            System.out.printf(OutputMessage.STRIKE, strike);
            System.out.println(OutputMessage.CORRECT_ANSWER);
        }
        if (strike < FULL_COUNT && strike != NO_COUNT && ball == NO_COUNT) {
            System.out.printf(OutputMessage.STRIKE, strike);
        }
        if (strike == NO_COUNT && ball != NO_COUNT) {
            System.out.printf(OutputMessage.BALL, ball);
        }
        if (strike != NO_COUNT && ball != NO_COUNT) {
            System.out.printf(OutputMessage.BALL_AND_STRIKE, ball, strike);
        }
    }
}
