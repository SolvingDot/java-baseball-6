package baseball.controller;

import baseball.domain.CorrectNumbers;
import baseball.domain.CorrectNumbersGenerator;
import baseball.domain.util.InputValidator;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class GameStartContorller {
    private static final String GAME_OVER = "2";

    private final InputView input;
    private final OutputView output;

    public GameStartContorller(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        input.announceBeginning();

        boolean start = true;
        while (start) {
            CorrectNumbersGenerator generator = new CorrectNumbersGenerator();
            CorrectNumbers correctNumbers = generator.generate();

            GamePlayController gamePlayController = new GamePlayController(input, output);
            gamePlayController.play(correctNumbers);

            start = decideRestartOrGameOver();
        }
    }

    private boolean decideRestartOrGameOver() {
        String decision = askRestartOrGameOver();

        if (decision.equals(GAME_OVER)) {
            return false;
        }
        return true;
    }

    private String askRestartOrGameOver() {
        String decision;
        while (true) {
            try {
                decision = readDecisionInput();
                break;
            } catch (IllegalArgumentException e) {
                //System.out.println(e.getMessage() + ErrorMessage.ASK_INPUT_AGAIN);
                throw e;
            }
        }
        return decision;
    }

    private String readDecisionInput() {
        InputValidator inputValidator = new InputValidator();
        String decision = input.askRestartOrGameOverOnce();
        inputValidator.validateDecision(decision);
        return decision;
    }
}
