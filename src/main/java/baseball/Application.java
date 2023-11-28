package baseball;

import baseball.controller.Game;
import baseball.domain.CorrectNumbers;
import baseball.domain.CorrectNumbersGenerator;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        CorrectNumbersGenerator generator = new CorrectNumbersGenerator();
        CorrectNumbers correctNumbers = generator.generate();

        Game game = new Game();
        game.play(input, output, correctNumbers);
    }
}
