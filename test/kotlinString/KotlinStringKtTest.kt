package kotlinString

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

/**
 *packageName    : kotlinString
 * fileName       : KotlinStringKtTest
 * author         : Yeong-Huns
 * date           : 2025-02-11
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-11        Yeong-Huns       최초 생성
 */
class KotlinStringKtTest {
    @Test
    fun `Index 를 통해 문자열에 접근한다`() {
        /* given */
        val strValue = "Hello World!"

        /* when */
        val str = strValue[2]

        /* then */
        assertThat(str).describedAs("Index 를 통한 문자열 조회").isEqualTo('l')
    }

    @Test
    fun `문자열의 범위를 초과한 Index 에 접근한다`() {
        /* given */
        val strValue = "Hello World!"

        /* when */
        val thrown = assertThatThrownBy { strValue[40] }

        /* then */
        thrown.isExactlyInstanceOf(StringIndexOutOfBoundsException::class.java)
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("Index 40 out of bounds for length 12")
    }

    @Test
    fun `substring 을 통해 지정된 범위의 문자열을 반환한다`() {
        /* given */
        val strValue = "Hello World!"

        /* when */
        val str = strValue.substring(0..4)

        /* then */
        assertThat(str).isEqualTo("Hello")
    }

    @Test
    fun `substring 을 통해 범위에서 벗어난 문자열을 반환한다`() {
        /* given */
        val strValue = "Hello World!"

        /* when */
        val thrown = assertThatThrownBy { strValue.substring(0..40) }

        /* then */
        thrown.isExactlyInstanceOf(StringIndexOutOfBoundsException::class.java)
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("Range [0, 41) out of bounds for length 12")
    }

    @Test
    fun `StringBuffer를 사용해 문자열을 조작한다`() {
        /* given */
        val buf = StringBuffer()

        /* when */
        buf.append("Hello")
        buf.append("Kotlin World!")
        buf.insert(5, "\n")
        buf.delete(6, 12)

        /* then */
        assertThat(buf.toString()).isEqualTo("Hello\n World!")

    }

    @Test
    fun `compareTo 를 통해 문자열을 비교한다`(){
        /* given */
        val str1 = "hello"
        val str2 = "world"
        val str3 = "HELLO"

        /* when */
        val different = str1.compareTo(str2)
        val same = str1.compareTo(str3, true) // 대소문자 무시 true

        /* then */
        assertThat(different).`as`("다른 문자열은 0이 출력되면 안된다.").isNotEqualTo(0)
        assertThat(same).`as`("같은 문자열은 0이 출력되어야 한다.").isEqualTo(0)
    }
}