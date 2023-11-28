package baseball;

import baseball.domain.CorrectNumbers;
import baseball.domain.CorrectNumbersGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CorrectNumbersGenerator generator = new CorrectNumbersGenerator();
        CorrectNumbers correctNumbers = generator.generate();
    }
}
