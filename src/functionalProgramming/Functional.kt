package functionalProgramming

/**
 *packageName    : functionalProgramming
 * fileName       : Functional
 * author         : Yeong-Huns
 * date           : 2025-02-06
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-06        Yeong-Huns       최초 생성
 */

fun main() {
    /* 람다식 정의 (타입 생략 가능) */
    val lambdaVal1 = { num1: Int, num2: Int -> num1 + num2 }
    println(lambdaVal1(3, 7)) // 10

    /* 람다식 정의 (타입 정의) */
    val lambdaVal2: (String, String) -> Unit = { str1: String, str2: String -> println("$str1 + $str2") }
    lambdaVal2("Hello", "World!") // Hello World!

    /* 문자열 배열 선언 */
    val stringArrayVal = arrayOf("Functional", "Programming", "Kotlin")

    /* Extension 함수 호출
     * 기존 클래스에 새로운 함수가 추가된 것 처럼 사용할 수 있다. (*실제로는 아님*)
     */
    stringArrayVal.printToString() //[Functional, Programming, Kotlin]

    /* 고차함수호출1 (기본적인 형태) */
    highFunction1(3,5, {num1, num2 -> num1 + num2}) //고차함수호출 : 8

    /* 고차함수호출2 (트레일링 람다)
    * @description 트레일링 람다란?
    * 함수의 마지막 인자가 람다식인 경우, 람다식을 괄호 밖으로 빼내어 코드의 가독성을 높일 수 있는 문법
    * */
    highFunction1(4,7){ num1, num2 -> num1 + num2 } //고차함수호출 : 11
}

/* Extension 함수 */
fun Array<String>.printToString() {
    return println(this.contentToString())
}

/*
 * 고차 함수
 * @description 함수를 매개변수로 받거나, 리턴 타입이 함수인 함수
 */
fun highFunction1(num1: Int, num2: Int, func: (Int, Int)-> Int) {
    return println("고차함수호출 : ${func(num1, num2)}")
}