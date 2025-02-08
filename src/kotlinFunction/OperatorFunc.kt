package kotlinFunction

import javax.swing.plaf.basic.BasicComboPopup

/**
 *packageName    : kotlinFunction
 * fileName       : OperatorFunc
 * author         : Yeong-Huns
 * date           : 2025-02-08
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-08        Yeong-Huns       최초 생성
 */
fun main(){
    val money1 = Money(10000);
    val money2 = Money(5000);

    // 기존 자바식 로직
    val sum1 = money1.sum(money2)
    println("sum1: $sum1") // sum1: Money(amount=15000)

    /* 연산자 함수를 활용 */
    /* 덧셈 */
    val plus = money1 + money2
    println("plus: $plus") // plus: Money(amount=15000)
    /* 뺄셈 */
    val minus = money1 - money2
    println("minus: $minus") // minus: Money(amount=5000)
    /* 곱셈 */
    val times = money1 * money2
    println("times: $times") // times: Money(amount=50000000)
    /* 나눗셈 */
    val divide = money1 / money2
    println("divide: $divide") // divide: Money(amount=2)

}

data class Money(private val amount: Int){

    /* 자바식 덧셈 로직 */
    fun sum(money: Money): Money{
        return Money(this.amount+money.amount)
    }

    /* 로직을 operator 함수로 구현 */
    operator fun plus(money: Money): Money = Money(this.amount + money.amount)
    operator fun minus(money: Money): Money = Money(amount-money.amount)
    operator fun times(money: Money): Money = Money(amount*money.amount)
    operator fun div(money: Money): Money = Money(amount/money.amount)

}