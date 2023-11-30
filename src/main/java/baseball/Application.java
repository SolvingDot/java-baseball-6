package baseball;

import baseball.controller.GameStartContorller;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        GameStartContorller gameStartContorller = new GameStartContorller(input, output);
        gameStartContorller.start();
    }
}
