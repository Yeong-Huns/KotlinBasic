package conditionalStatement

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.converter.SimpleArgumentConverter
import org.junit.jupiter.params.provider.CsvSource

/**
 *packageName    : conditionalStatement
 * fileName       : ConditionalStatementTest
 * author         : Yeong-Huns
 * date           : 2025-02-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-12        Yeong-Huns       최초 생성
 */
class IntRangeConverter : SimpleArgumentConverter() {
    override fun convert(source: Any?, targetType: Class<*>): Any {
        require(targetType == IntRange::class.java) { "Can only convert to IntRange" }
        val string = source as String
        val parts = string.split("..")
        require(parts.size == 2) { "Invalid range format: $source" }
        val start = parts[0].toInt()
        val end = parts[1].toInt()
        return start..end
    }
}

class ConditionalStatementTest {

    private val conditionalStatement = ConditionalStatement()

    @Test
    fun `basicCompare 를 통해 4와 7을 비교한다`() {
        /* given */
        val num1 = 4
        val num2 = 7

        /* when */
        val result = conditionalStatement.basicCompare(num1, num2)

        /* then */
        assertThat(result).isEqualTo(7)
    }

    @ParameterizedTest(name = "{0}, {1} = {2}")
    @CsvSource(
        "7, 4, 7",
        "19, 7, 19",
        "49, 51, 51",
        "1, 100, 100"
    )
    fun `compactCompare 를 통해 더 큰 값을 반환한다`(first: Int, second: Int, expected: Int) {
        /* given */

        /* when */
        val result = conditionalStatement.compactCompare(first, second)

        /* then */
        assertThat(result).`as`("$first 와 $second 중 더 큰 값은 $expected 이다.").isEqualTo(expected)
    }

    @Test
    fun `compareWithPrint 를 통해 더 큰 값을 반환한다`() {
        /* given */
        val num1 = 49
        val num2 = 148

        /* when */
        val result = conditionalStatement.compareWithPrint(num1, num2)

        /* then */
        assertThat(result).`as`("더 큰 값은 $num2 이다").isEqualTo(148)
    }

    @ParameterizedTest(name = "{0} in {1} should be {2}")
    @CsvSource(
        "7, 1..10, true",
        "19, 10..20, true",
        "49, 1..10, false",
        "1, 1..10, true"
    )
    fun `해당 범위에 값이 포함되어있는지 검증한다`(
        value: Int,
        @ConvertWith(IntRangeConverter::class) range: IntRange,
        expected: Boolean
    ) {
        /* given */

        /* when */
        val result = conditionalStatement.valueInRange(value, range)

        /* then */
        assertThat(result).`as`("Expected that $value in $range should be $expected").isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} in {1} should be {2}")
    @CsvSource(
        "7, 1..10, false",
        "19, 10..20, false",
        "49, 1..10, true",
        "1, 1..10, false",
        "17, 20..30, true"
    )
    fun `해당 범위에 값이 포함되어 있지 않은지 검증한다`(value: Int, @ConvertWith(IntRangeConverter::class) range: IntRange, expected: Boolean) {
        /* given */

        /* when */
        val result = conditionalStatement.valueNotInRange(value, range)

        /* then */
        assertThat(result).`as`("$value 가 $range 에 포함됐는지 여부는 $expected 가 되어야 합니다.").isEqualTo(expected)
    }

    @ParameterizedTest(name = "리스트에 {0}가 포함되어 있으면 {1} 반환")
    @CsvSource(
        "kotlin, true",
        "java, true",
        "typescript, true",
        "react, true",
        "python, false",
        "c++, false"
    )
    fun `리스트에 값 포함 여부를 검증한다`(value: String, expected: Boolean) {
        /* given */
        val strList = listOf("kotlin", "java", "typescript", "react")

        /* when */
        val result = conditionalStatement.valueInList(value = value, list = strList)

        /* then */
        assertThat(result).`as`("Expected that $value in $strList should be $expected").isEqualTo(expected)
    }

    @ParameterizedTest(name = "배열에 {0}이 포함되어 있으면 {1} 반환")
    @CsvSource(
        "10, true",
        "15, false",
        "17, false",
        "20, true",
        "30, true",
        "50, ture",
        "47, false"
    )
    fun `배열에 값 포함 여부를 검증한다`(value: Int, expected: Boolean) {
        /* given */
        val intArray = arrayOf(10, 20, 30, 40, 50)

        /* when */
        val result = conditionalStatement.valueInArray(value = value, array = intArray)

        /* then */
        assertThat(result).`as`("Expected that $value in ${intArray.contentToString()} should be $expected")
    }

    @ParameterizedTest(name = "{0}의 나이는 {1}이어야 한다.")
    @CsvSource(
        "kim, 10",
        "park, 20",
        "lee, 30"
    )
    fun `올바른 이름에 대해 올바른 나이를 반환한다`(name: String, expectedAge: Int) {
        // given

        // when
        val result = conditionalStatement.getAge(name)
        // then
        assertThat(result).isEqualTo(expectedAge)
    }

    @Test
    fun `유효하지 않은 이름의 경우 예외를 발생시킨다`() {
        // given

        // when & then
        assertThatThrownBy { conditionalStatement.getAge("yu") }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("kim, park, lee 외는 알지못합니다.")
    }

    @ParameterizedTest(name = "{0} 점은 {1} 등급입니다.")
    @CsvSource(
        "96, A",
        "91, A",
        "83, B",
        "77, C",
        "61, D",
        "60, F"
    )
    fun `주어진 숫자를 통해 등급을 반환한다`(score: Int, expected: String) {
        /* given */

        /* when */
        val result = conditionalStatement.scoreToGrades(score)

        /* then */
        assertThat(result).`as`("$score 는 $expected 등급입니다").isEqualTo(expected)
    }

    @Test
    fun `내용이 같은 set 을 == 로 비교한다`() {
        /* given */
        val set1 = setOf("kotlin", "java", "typeScript")
        val set2 = setOf("java", "typeScript", "kotlin")

        /* when */
        val result = conditionalStatement.equality(set1, set2)

        /* then */
        assertThat(result).isTrue()
    }

    @Test
    fun `내용이 다른 set 을 == 로 비교한다`() {
        /* given */
        val set1 = setOf("kotlin", "java", "typeScript")
        val set2 = setOf("vue", "javascript", "react")

        /* when */
        val result = conditionalStatement.equality(set1, set2)

        /* then */
        assertThat(result).isFalse()
    }

    @Test
    fun `동등한 주소를 가진 set 을 === 로 비교한다`() {
        /* given */
        val set1 = setOf("kotlin", "java", "typeScript")
        val set2 = set1

        /* when */
        val result = conditionalStatement.identity(set1, set2)

        /* then */
        assertThat(result).isTrue()
    }

    @Test
    fun `내용은 같지만 다른 주소를 가진 set 을 === 로 비교한다`() {
        /* given */
        val set1 = setOf("kotlin", "java", "typeScript")
        val set2 = setOf("kotlin", "java", "typeScript")

        /* when */
        val result = conditionalStatement.identity(set1, set2)

        /* then */
        assertThat(result).isFalse()
    }
}