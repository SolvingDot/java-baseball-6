package baseball.controller;

import baseball.domain.CorrectNumbers;
import baseball.domain.CorrectNumbersGenerator;
import baseball.domain.Referee;
import baseball.ui.InputCoverter;
import baseball.ui.InputView;
import baseball.ui.OutputView;
import java.util.List;

public class Game {
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
        int strike = 0;
        while (strike < 3) {
            InputCoverter converter = new InputCoverter();
            List<Integer> inputNumbers = converter.convertInputToNumbers(input.readInput());

            Referee referee = new Referee();
            strike = referee.countStrike(inputNumbers, correctNumbers.getCorrectNumbers());
            int ball = referee.countBall(inputNumbers, correctNumbers.getCorrectNumbers());

            output.printHint(strike, ball);
        }
    }

    private boolean decisionGameOver(InputView input) {
        if (input.readDecision().equals("2")) {
            return false;
        }
        return true;
    }
}
