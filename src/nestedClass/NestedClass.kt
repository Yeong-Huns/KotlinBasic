package nestedClass

/**
 *packageName    : nestedClass
 * fileName       : NestedClass
 * author         : Yeong-Huns
 * date           : 2025-02-07
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-07        Yeong-Huns       최초 생성
 */
class NestedClass {
    val outerValue = 10;

    val outerFunc = { println("outerFunc 실행: $outerValue") }

    inner class InnerClass {
        val innerValue = 30;
        val innerFunc = {
            println("innerValue: $innerValue")
            println("outerValue: $outerValue")
            outerFunc()
        }
    }
}

fun main(){
    val outerClass = NestedClass();
    val innerClass = outerClass.InnerClass();

    /* outerClass 변수에 접근 */
    println(outerClass.outerValue) // 10
    /* 메서드에 접근 */
    outerClass.outerFunc() // outerFunc 실행: 10

    innerClass.innerFunc()
    /*innerValue: 30
    outerValue: 10 // innerClass 에서 outerClass 에 접근가능  / 반대는 불가능 (outerClass 에서 innerClass 를 직접 생성해서 접근하면 가능)
    outerFunc 실행: 10

    */
}