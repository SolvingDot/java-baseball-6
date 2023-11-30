package baseball.controller;

import baseball.domain.CorrectNumbers;
import baseball.domain.Referee;
import baseball.ui.InputView;
import baseball.ui.OutputView;
import baseball.ui.message.ErrorMessage;
import baseball.util.InputConverter;
import baseball.util.InputValidator;
import baseball.util.NumbersValidator;
import java.util.List;

public class GamePlayController {
    private static final int NO_COUNT = 0;
    private static final int FULL_COUNT = 3;

    private final InputView input;
    private final OutputView output;

    public GamePlayController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void play(CorrectNumbers correctNumbers) {
        int strike = NO_COUNT;
        while (strike < FULL_COUNT) {
            List<Integer> numbersOfPlayer = askNumbersOfPlayer();

            Referee referee = new Referee();
            strike = referee.countStrike(numbersOfPlayer, correctNumbers.getCorrectNumbers());
            int ball = referee.countBall(numbersOfPlayer, correctNumbers.getCorrectNumbers());

            output.printHint(strike, ball);
        }
    }

    private List<Integer> askNumbersOfPlayer() {
        List<Integer> numbersOfPlayer;
        while (true) {
            try {
                numbersOfPlayer = readNumbersOfPlayer();
                validateNumbersOfPlayer(numbersOfPlayer);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ErrorMessage.ASK_INPUT_AGAIN);
            }
        }
        return numbersOfPlayer;
    }

    private List<Integer> readNumbersOfPlayer() {
        String inputNumbers = input.askNumbersOnce();
        validateInputNumbers(inputNumbers);
        InputConverter converter = new InputConverter();
        return converter.convertInputToNumbers(inputNumbers);
    }

    private void validateInputNumbers(String inputNumbers) {
        InputValidator validator = new InputValidator();
        validator.ensureInputHaveValues(inputNumbers);
        validator.ensureInputHaveOnlyNumbers(inputNumbers);
        validator.ensureInputSize(inputNumbers);
    }

    private void validateNumbersOfPlayer(List<Integer> numbersOfPlayer) {
        NumbersValidator validator = new NumbersValidator();
        validator.ensureSizeOfNumbers(numbersOfPlayer);
        validator.ensureRangeOfDigits(numbersOfPlayer);
        validator.ensureEachDifferentNumbers(numbersOfPlayer);
    }
}
