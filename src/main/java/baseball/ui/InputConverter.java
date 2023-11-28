package baseball.ui;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {
    private static final int FIRST_INDEX = 0;
    private static final int NUMBER_SIZE = 3;

    public List<Integer> convertInputToNumbers(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (int index = FIRST_INDEX; index < NUMBER_SIZE; index++) {
            inputNumbers.add(Character.getNumericValue(input.charAt(index)));
        }
        return inputNumbers;
    }
}
