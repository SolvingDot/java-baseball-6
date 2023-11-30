package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @DisplayName("같은 자리에 같은 숫자이면 스트라이크 개수에 반영한다.")
    @Test
    void countStrikeTest() {
        // Given
        List<Integer> numbersOfPlayer = List.of(1, 2, 3);
        List<Integer> correctNumbers = List.of(1, 2, 4);

        // When
        Referee referee = new Referee();
        int strike = referee.countStrike(numbersOfPlayer, correctNumbers);

        // Then
        assertThat(strike).isEqualTo(2);
    }

    @DisplayName("다른 자리에 같은 숫자가 있으면 볼 개수에 반영한다.")
    @Test
    void countBallTest() {
        // Given
        List<Integer> numbersOfPlayer = List.of(1, 2, 3);
        List<Integer> correctNumbers = List.of(3, 4, 5);

        // When
        Referee referee = new Referee();
        int ball = referee.countBall(numbersOfPlayer, correctNumbers);

        // Then
        assertThat(ball).isEqualTo(1);
    }
}