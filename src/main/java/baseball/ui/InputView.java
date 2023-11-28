package baseball.ui;

import baseball.ui.message.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String RESTRAT = "1";
    private static final String GAME_OVER = "2";
    private static final int SIZE_OF_CORRECT_NUMBERS = 3;
    private static final String NUMERIC_WITHOUT_ZERO = "^[1-9]*$";

    public void announceBeginning() {
        System.out.println(InputMessage.ANNOUNCE_BEGINNING);
    }

    public String readInput() {
        System.out.print(InputMessage.ASK_NUMBERS);
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public String readDecision() {
        System.out.printf(InputMessage.ASK_DECISION, RESTRAT, GAME_OVER);
        String decision = Console.readLine();
        validateDecision(decision);
        return decision;
    }

    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다. 다시 입력해주세요.");
        }
        if (input.length() != SIZE_OF_CORRECT_NUMBERS) {
            throw new IllegalArgumentException("세 자리가 아닙니다. 다시 입력해주세요.");
        }
        if (!input.matches(NUMERIC_WITHOUT_ZERO)) {
            throw new IllegalArgumentException("1과 9사이의 숫자로 이루어진 값이 아닙니다. 다시 입력해주세요.");
        }
    }

    private void validateDecision(String decision) {
        if (!canBeONlyOneOrTwo(decision)) {
            throw new IllegalArgumentException("1 또는 2가 아닙니다. 다시 입력해주세요.");
        }
    }

    private boolean canBeONlyOneOrTwo(String decision) {
        return decision.equals(RESTRAT) || decision.equals(GAME_OVER);
    }
}
