package array

/**
 *packageName    : array
 * fileName       : MultiDemensionArray
 * author         : Yeong-Huns
 * date           : 2025-02-07
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-07        Yeong-Huns       최초 생성
 */

fun main() {
    val array1 = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
    println(array1.contentToString()) // 내부 배열의 해쉬값 출력 [[Ljava.lang.Integer;@7291c18f, [Ljava.lang.Integer;@34a245ab, [Ljava.lang.Integer;@7cc355be]
    println(array1.contentDeepToString()) // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

    /* array1 과 사실상 동일함 */
    val gridData = Array(3) { outerIndex -> Array(3) { index -> outerIndex * 3 + index + 1 } }
    println(gridData.contentDeepToString()) // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]


    /*    1 2 3
          4 5 6
          7 8 9    */
    for (row in gridData) {
        for (col in row) {
            print("$col ")
        }
        println()
    }

    /* 배열 원소 접근 */
    println(gridData[0][2]) // 자바와 동일한 방식 : 3
    println(gridData.get(0).get(2)) // get 을 통한 접근 : 3

    /* 배열 요소 수정 */
    gridData[2][2] = 0
    println("자바 방식 : ${gridData.contentDeepToString()}") // 자바 방식 : [[1, 2, 3], [4, 5, 6], [7, 8, 0]]

    gridData[0].set(0, 0)
    println("set을 통한 값 수정 ${gridData.contentDeepToString()}") // set을 통한 값 수정 [[0, 2, 3], [4, 5, 6], [7, 8, 0]]

}