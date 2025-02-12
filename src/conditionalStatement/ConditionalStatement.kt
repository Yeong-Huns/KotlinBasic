package conditionalStatement

/**
 *packageName    : conditionalStatement
 * fileName       : ConditionalStatement
 * author         : Yeong-Huns
 * date           : 2025-02-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-12        Yeong-Huns       최초 생성
 */
class ConditionalStatement {

    fun basicCompare(a: Int, b: Int): Int {
        /* expression 이라 값 자체 리턴 가능 */
        val max: Int = if (a > b) a
        else b
        println("max : $max")
        return max
    }

    fun compactCompare(a: Int, b: Int) : Int = if(a > b) a else b

    fun compareWithPrint(a: Int, b: Int): Int {
        /* if 블록 마지막에 오는 값이 반환되는 값이다. */
        return if(a > b) {
            println("a 가 더 큼")
            a
        } else {
            println("b 가 더 큼")
            b
        }
    }

    /* Range 와 in 을 사용하여 해당범위 내 포함 여부 검사 */
    fun valueInRange(num: Int, range: IntRange): Boolean{
        return num in range
    }

    /* 해당범위 내 포함되지 않는지 검사 */
    fun valueNotInRange(num: Int, range: IntRange): Boolean{
        return num !in range
    }

    /* 리스트 내부 값 포함 여부 검사 */
    fun <T> valueInList (value: T, list: List<T>): Boolean {
        return value in list
    }

    /* 배열 내부 값 포함 여부 검사 */
    fun <T> valueInArray (value: T, array: Array<T>): Boolean {
        return value in array
    }

    /* when 분기처리 */
    fun getAge(name: String) : Int{
        return when(name){
            "kim" -> 10
            "park" -> 20
            "lee" -> 30
            else -> throw IllegalArgumentException("kim, park, lee 외는 알지못합니다.")
        }
    }

    fun scoreToGrades(score: Int): String {
        return when(score){
            in 91..100 -> "A"
            in 81..90 -> "B"
            in 71..80 -> "C"
            in 61..70 -> "D"
            else -> "F"
        }
    }

    fun <T> equality(set1: Set<T>, set2: Set<T>): Boolean {
        return set1 == set2
    }

    fun <T> identity(set1: Set<T>, set2: Set<T>): Boolean {
        return set1 === set2
    }

}