package baseball.ui.message;

public enum ErrorMessage {
    EMPTY_VALUE("입력값이 없습니다. 다시 입력해주세요."),
    NOT_NUMBER("숫자가 아닙니다. 다시 입력해주세요."),
    SIZE_OF_NUMBER("3자리의 숫자가 아닙니다."),
    OUT_OF_RANGE("1에서 9까지의 범위를 벗어난 숫자가 있습니다."),
    DUPLICATED_NUMBER("중복된 숫자가 있습니다."),
    ENTER_ONE_OR_TWO("1 또는 2가 아닙니다. 다시 입력해주세요."),
    ASK_INPUT_AGAIN(" 다시 입력해주세요.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
