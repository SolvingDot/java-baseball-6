package baseball.ui;

import java.util.ArrayList;
import java.util.List;

public class InputCoverter {
    public List<Integer> convertInputToNumbers(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inputNumbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return inputNumbers;
    }
}
