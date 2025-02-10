package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 *packageName    : calculator
 * fileName       : CalculatorTest
 * author         : Yeong-Huns
 * date           : 2025-02-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-10        Yeong-Huns       최초 생성
 */
class CalculatorTest {
    @Test
    fun `1 + 1 = 2` (){
        /* given */
        val num1 = 1;
        val num2 = 1;
        val calculator = Calculator()

        /* when */
        val result = calculator.add(num1, num2)

        /* then */
        assertThat(result)
            .`as`("$num1 + $num2 = ${num1+num2} 이 나와야 한다.")
            .isEqualTo(num1 + num2)
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(
        "0, 1, 1",
        "1, 2, 3",
        "49, 51, 100",
        "1, 100, 101"
    )
    fun add(first: Int, second: Int, expectedResult: Int) {
        /* given */
        val calculator = Calculator()

        /* when */
        val result = calculator.add(first, second)

        /* then */
        assertThat(result)
            .`as`("$first + $second = $expectedResult 가 나와야 한다.")
            .isEqualTo(expectedResult)
    }

    @Test
    fun divisionByZero() {
        /* given */
        val num = 1
        val zero = 0
        val calculator = Calculator()

        /* when */
        val thrown = assertThatThrownBy { calculator.divide(num, zero) }

        /* then */
        thrown
            .isExactlyInstanceOf(AssertionError::class.java)
            .isInstanceOf(Error::class.java)
            .hasMessage("divide by zero")

    }

}