package kotlinLoop

/**
 *packageName    : kotlinLoop
 * fileName       : KotlinLoop
 * author         : Yeong-Huns
 * date           : 2025-02-13
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-13        Yeong-Huns       최초 생성
 */
fun main() {
    /* 리스트에 있는 값을 하나씩 사용 */
    val memberList: List<String> = listOf("kim", "park", "lee")
    for (member in memberList) {
        println(member) // kim park lee
    }

    /* 리스트의 인덱스를 가져와서 사용 */
    for (index in memberList.indices) {
        println(memberList[index]) /* 인덱스로 접근 */ // kim park lee
    }

    /* 리스트의 인덱스와 값을 같이 가져와서 사용 */
    for ((index, member) in memberList.withIndex()) {
        println("인덱스 = $index , 멤버 = $member") // 인덱스 = 0 , 멤버 = kim, 인덱스 = 1 , 멤버 = park, 인덱스 = 2 , 멤버 = lee
    } /* 인덱스와 값을 모두 사용하는 경우 가장 권장됨 */

    /* (..)를 사용해서 숫자 범위로 for 문 실행 */
    for (i in 1..10) { /* 1<= .. <= 10 */
        println(i) // 1 ~ 10
    }

    /* ..<(until) 를 사용해서 마지막 숫자를 포함하지 않음 */
    for (i in 1..<10) {
        println(i) // 1 ~ 9
    }

    /* step 을 사용해서 숫자를 2씩 증가 */
    for (i in 1..10 step 2) {
        println(i) // 1, 3, 5, 7, 9
    }

    /* downTo 를 활용한 역순 출력 */
    for (i in 10 downTo 1) {
        println(i) // 10 ~ 1
    }

    /* 문자도 지원하는 Range */
    for (c in 'a'..'z') {
        println(c) // a ~ z
    }

    for (c in 'e' downTo 'a' step 2) {
        println(c) // e c a
    }

    /* return 기본적으로 가장 가까운 함수 또는 익명 함수에서 반환*/
    fun loop() {
        for (i in 0..3) {
            for (j in 0..3) {
                if (j == 2) return
                println("i = $i, j = $j")
            }
        }
    }

    loop() // i = 0, j = 0, i = 0, j = 1 -> 함수 (loop() ) 자체가 종료
    println()

    /* break 가장 가까운 반복문을 종료 */
    fun loopBreak() {
        for (i in 0..3) {
            for (j in 0..3) {
                if (j == 2) break
                println("i = $i, j = $j")
            }
        }
    }
    loopBreak()
    println()

    fun loop2() {
        for (i in 0..3) {
            for (j in 0..3) {
                if (j == 2) continue
                println("i = $i, j = $j")
            }
        }
    }

    /* 가장 가까운 반복문을 다음단계로 진행 */
    loop2()
    println()
    fun loop3() {
        loop@ for (i in 0..3) {
            for (j in 0..3) {
                if (j == 2) break@loop
                println("i = $i, j = $j")
            }
        }
    }

    /* 라벨이 표시된 위치를 종료 */
    loop3()
    println()

    fun loop4() {
        for (i in 0..3) {
            loop@ for (j in 0..3) {
                if (j == 2) break@loop
                println("i = $i, j = $j")
            }
        }
    }

    loop4()

}