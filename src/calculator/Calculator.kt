package calculator

/**
 *packageName    : calculator
 * fileName       : Calculator
 * author         : Yeong-Huns
 * date           : 2025-02-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-10        Yeong-Huns       최초 생성
 */
class Calculator {

    val add = { x: Int, y: Int -> x + y }

    fun divide(x: Int, y: Int): Double {
        assert(y!=0) { "divide by zero" }
        return x / y * 1.0
    }
}