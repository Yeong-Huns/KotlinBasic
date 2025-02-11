package kotlinString

/**
 *packageName    : kotlinString
 * fileName       : KotlinString
 * author         : Yeong-Huns
 * date           : 2025-02-11
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-11        Yeong-Huns       최초 생성
 */
fun main(){
    /* Java 와 다르게 문자열 인덱스로 접근가능 */
    val str1 = "hello world!"
    println(str1[0]) // 'h'
    println(str1[2]) // 'l'

    /* substring (지정된 범위의 문자열을 반환) */
    val str2 = "hello world!"
    str2.substring(0..5).let(::println) // hello

    /* compareTo 문자열 비교 (0 이면 동일값) */
    val hello = "hello"
    val world = "world"
    val HELLO = "HELLO"

    hello.compareTo(world).let(::println) // -15
    hello.compareTo(HELLO,true).let(::println) // 0

    /* split 지정된 구분자로 잘라 리스트로 반환 */
    val stringValue = "Java React Kotlin Spring"
    stringValue.split(" ").joinToString(prefix = "<", postfix = ">" , separator = ", ").let(::println) // <Java, React, Kotlin, Spring>

    /* StringBuffer */
    val stringBuffer = StringBuffer()
    stringBuffer.append(33)
    stringBuffer.append("Kotlin")

    stringBuffer.insert(2, "Hello! ")
    stringBuffer.delete(0, 2)

    stringBuffer.let(::println) // Hello! Kotlin
}
