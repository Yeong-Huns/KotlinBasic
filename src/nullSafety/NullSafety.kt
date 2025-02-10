package nullSafety

/**
 *packageName    : nullSafety
 * fileName       : NullSafety
 * author         : Yeong-Huns
 * date           : 2025-02-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-10        Yeong-Huns       최초 생성
 */
fun main(){
    fun main(){
        /* null 타입을 허용하는 방법 (default : not null) */
        val strValue1: String? = "This is Nullable Value"

        /* 코틀린에서 nullable 한 값을 사용하기 위해선 해당 값이 null 이 아님을 보장해야함 */
        // val length = strValue1.length -> Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type 'kotlin. String?'

        /* smart casting */
        if (strValue1 != null) {
            /* null 추적을 통한 블록범위 not null 보장 */
            println("if 문 null check ${strValue1::class}") // smart cast to Kotlin String
        } else println("null")

        /* Boolean 에서의 nullable */
        val booleanValue1 : Boolean? = null

        /* Boolean 을 nullable 설정하면 3가지 분기가 생긴다. (비권장)*/
        when (booleanValue1) {
            true -> println("This value is true")
            false -> println("This value is false")
            else -> println("This value is null")
        }

        /* safe call operator */
        val nullableString1 : String? = "Hi there"
        val nullableString2: String? = null

        /* 앞의 값이 null 값이 아니면 ?. 뒤의 명령어 실행 / 아니라면 null 반환 */
        println(nullableString1?.length) // 8
        println(nullableString2?.length) // null

        /* scope function 과 조합시, if 문과 유사하게 동작 */
        nullableString1?.let {
            println(it) // Hi there
        }

        nullableString2?.let {
            println(it) // 실행되지 않음
        }

        /* toString() null 비교하는법 */
        val nullValue : String? = null

        println("nullValue.toString() : ${nullValue.toString()}") // null
        println("nullValue.toString() == null : ${nullValue.toString() == null}") // false
        println("nullValue?.toString() == null : ${nullValue?.toString() == null}") // true

        /* null 을 toString() 하면 문자열 "null" 이 됨.*/
        println(nullValue.toString()::class) // class java.lang.String (Kotlin reflection is not available)

        /* Elvis operator (?:)*/
        val notNullValue: String? = "This is Not Null"

        /* 왼쪽이 null 이면 오른쪽 표현식을 반환한다. */
        val afterElvisOperator = { strVal: String? -> strVal ?: "This is Null"}

        afterElvisOperator(notNullValue).let(::println) // This is Not Null
        afterElvisOperator(nullValue).let(::println) // This is Null

        val nullableInt : Int? = null

        /* null 이면 함수를 나가버림 */
        val result : Int = nullableInt ?: return //아래 실행안됨
        println("nullableInt : $result")

        val result2  = nullableInt ?: throw IllegalArgumentException("Null 값")
        println(result2) // Exception in thread "main" java.lang.IllegalArgumentException: Null 값

        val strVal1 : String? = "ABC"
        val strVal2 : String? = null
        println("strVal1 : ${strVal1!!.length}") // 3
        println("strVal2 : ${strVal2!!.length}") // null pointerException
    }
}