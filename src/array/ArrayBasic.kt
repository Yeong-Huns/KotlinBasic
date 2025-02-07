package array

/**
 *packageName    : array
 * fileName       : ArrayBasic
 * author         : Yeong-Huns
 * date           : 2025-02-07
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-07        Yeong-Huns       최초 생성
 */

fun main(){
    /* Any type 배열(Array)의 생성 */
    val array1 = arrayOf(1,"2",3,4,5, "Hi")
    println(array1) // 해쉬값출력 : [Ljava.lang.Object;@7291c18f
    println(array1.contentToString()) // 값 출력 [1, 2, 3, 4, 5, Hi]

    /* 타입 제한 배열 생성*/
    val array2 = arrayOf<Int>(1,2,3,4,5);
    val array3 = arrayOf<Char>('H','E','L','L','O')

    /* 자료형 + arrayOf 도 가능하다. */
    val array4 = intArrayOf(1,2,3,4,5)
    val array5 = charArrayOf('H','E','L','L','O')

    /* Array 클래스를 통한 생성 */
    val array6 = Array(5){"안뇽"} // [안뇽, 안뇽, 안뇽, 안뇽, 안뇽]

    /* array6 과 사실상 동일함 */
    val array7 = Array(5){index -> "안뇽"} // [안뇽, 안뇽, 안뇽, 안뇽, 안뇽]

    /* 람다식 전달 */
    val array8 = Array(5){index -> index} // [0, 1, 2, 3, 4]

    /* 람다식에서 인자가 하나라면, it 을 사용해 인자를 참조 가능 */
    val array9 = Array(5){it} // [0, 1, 2, 3, 4]

    val array10 = Array(5){it*2} // [0, 2, 4, 6, 8]

    /* array10 과 동일함 */
    val array11 = Array(5){index -> index * 2} // [0, 2, 4, 6, 8]

}