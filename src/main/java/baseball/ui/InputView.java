package baseball.ui;

import baseball.ui.message.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String RESTART = "1";
    private static final String GAME_OVER = "2";

    public void announceBeginning() {
        System.out.println(InputMessage.ANNOUNCE_BEGINNING);
    }

    public String askNumbersOnce() {
        System.out.print(InputMessage.ASK_NUMBERS);
        return Console.readLine();
    }

    public String askRestartOrGameOverOnce() {
        System.out.printf(InputMessage.ASK_DECISION, RESTART, GAME_OVER);
        return Console.readLine();
    }
}
