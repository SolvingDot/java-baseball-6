package baseball;

import baseball.controller.GameStartController;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        GameStartController gameStartController = new GameStartController(input, output);
        gameStartController.start();
    }
}
