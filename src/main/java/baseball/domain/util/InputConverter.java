package baseball.domain.util;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {
    private static final int FIRST_INDEX = 0;
    private static final int NUMBER_SIZE = 3;

    public List<Integer> convertInputToNumbers(String inputNumbers) {
        List<Integer> NumbersOfPlayer = new ArrayList<>();
        for (int index = FIRST_INDEX; index < NUMBER_SIZE; index++) {
            NumbersOfPlayer.add(Character.getNumericValue(inputNumbers.charAt(index)));
        }
        return NumbersOfPlayer;
    }
}
