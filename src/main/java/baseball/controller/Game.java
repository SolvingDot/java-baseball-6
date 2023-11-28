package baseball.controller;

import baseball.domain.CorrectNumbers;
import baseball.domain.Referee;
import baseball.ui.InputCoverter;
import baseball.ui.InputView;
import baseball.ui.OutputView;
import java.util.List;

public class Game {
    public void play(InputView input, OutputView output, CorrectNumbers correctNumbers) {
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
}
