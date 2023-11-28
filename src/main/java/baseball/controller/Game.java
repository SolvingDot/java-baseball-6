package baseball.controller;

import baseball.domain.CorrectNumbers;
import baseball.domain.CorrectNumbersGenerator;
import baseball.domain.Referee;
import baseball.ui.InputConverter;
import baseball.ui.InputView;
import baseball.ui.OutputView;
import java.util.List;

public class Game {
    private static final int NO_COUNT = 0;
    private static final int FULL_COUNT = 3;
    private static final String GAME_OVER = "2";

    public void start(InputView input, OutputView output) {
        input.announceBeginning();
        boolean start = true;
        while (start) {
            CorrectNumbersGenerator generator = new CorrectNumbersGenerator();
            CorrectNumbers correctNumbers = generator.generate();

            play(input, output, correctNumbers);

            start = decisionGameOver(input);
        }
    }

    private void play(InputView input, OutputView output, CorrectNumbers correctNumbers) {
        int strike = NO_COUNT;
        while (strike < FULL_COUNT) {
            InputConverter converter = new InputConverter();
            List<Integer> inputNumbers = converter.convertInputToNumbers(input.readInput());

            Referee referee = new Referee();
            strike = referee.countStrike(inputNumbers, correctNumbers.getCorrectNumbers());
            int ball = referee.countBall(inputNumbers, correctNumbers.getCorrectNumbers());

            output.printHint(strike, ball);
        }
    }

    private boolean decisionGameOver(InputView input) {
        if (input.readDecision().equals(GAME_OVER)) {
            return false;
        }
        return true;
    }
}
