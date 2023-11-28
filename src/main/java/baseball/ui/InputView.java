package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void announceBeginning() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String readInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String readDecision() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String decision = Console.readLine();
        validateDecision(decision);
        return decision;
    }

    private void validateDecision(String decision) {
        if (!canBeONlyOneOrTwo(decision)) {
            throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
        }
    }

    private boolean canBeONlyOneOrTwo(String decision) {
        return decision.equals("1") || decision.equals("2");
    }
}
