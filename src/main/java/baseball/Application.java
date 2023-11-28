package baseball;

import baseball.controller.Game;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        Game game = new Game();
        game.start(input, output);
    }
}
