package array

/**
 *packageName    : array
 * fileName       : ArrayMethods
 * author         : Yeong-Huns
 * date           : 2025-02-07
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-07        Yeong-Huns       최초 생성
 */

fun main(){
    /**
     * Array<T>.size
     * @type public val size: Int
     * @description Returns the number of elements in the array.
     */
    val arrayVal = arrayOf<Number>(1, 2, 3, 4, 5);
    println("arrayVal 의 길이 : $arrayVal.size")

    /**
     * <T> Array<T>.plus(element: T)
     * @type public actual operator fun <T> Array<T>.plus(element: T) : Array<T>
     * @description Returns an array containing all elements of the original array and then the given element.
     * @return 원본 배열에 element 를 추가한 *새로운* 배열을 반환
     */
    val originArray = arrayOf<Number>(1, 2, 3, 4, 5);
    val editedArray = originArray.plus(6)

    /* operator 함수이기 때문에, 아래와 같이 사용가능 */
    val editedArray2 = originArray + 6 // [1, 2, 3, 4, 5, 6]

    println("원본 배열의 값 : ${originArray.contentToString()}") // [1, 2, 3, 4, 5]
    println("값이 추가된 새로운 배열 : ${editedArray.contentToString()}") // [1, 2, 3, 4, 5, 6]

    /** @type <T> Array<T>.sliceArray(indices: IntRange)
     * @description Returns an array containing elements at indices in the specified [indices] range.
     * @return 지정된 인덱스 범위에 해당하는 원소로 새로운 배열을 반환
     */
    val beforeSlice = arrayOf<Int>(1, 2, 3, 4, 5);

    /* 인덱스 (0 ~ 1) 까지 반환 */
    val afterSlice1 = beforeSlice.sliceArray(0..1) // [1, 2]

    /* afterSlice1 과 사실상 동일하지만 IntRange 를 사용 */
    val afterSlice2 = beforeSlice.sliceArray(IntRange(0,1)) // [1, 2]


    val newArray = Array<Int>(5){it * 2} // [0, 2, 4, 6, 8]

    /** @type <T> Array<out T>.first(): T
     * @description Returns the first element.
     * @summary 제일 앞의 값을 반환하는 함수
     */
    println("첫번째 값 : ${newArray.first()}") // 첫번째 값 : 0

    /** @type <T> Array<out T>.last(): T
     * @description Returns the last element.
     * @summary 제일 뒤의 값을 반환하는 함수
     */
    println("마지막 값 : ${newArray.last()}") // 마지막 값 : 8

    val newArray1 = arrayOf<Int>(3, 1, 6, 4, 2, 7, 8, 6)

    /** @type  <@kotlin.internal.OnlyInputTypes T> Array<out T>.indexOf(element: T): Int
     * @description Returns first index of element. or -1 if the array does not contain element.
     * @summary 전달받은 값과 일치하는 첫번째 요소의 인덱스를 반환. 존재하지 않는다면 -1 반환
     */
    println("첫번째 6의 인덱스 : ${newArray1.indexOf(6)}") // 2

    /* indexOf 는 첫번째 요소의 인덱스를 반환하기 때문에, 뒤에서 찾고 싶다면 lastIndexOf 함수 사용 */
    println("마지막 6의 인덱스 : ${newArray1.lastIndexOf(6)}") // 7

    /** @type  Array<out Int>.average(): Double
     * @description Returns an average value of elements in the array.
     * @summary 배열 원소들의 평균값을 반환
     */
    println("평균값 : ${newArray1.average()}") // 평균값 : 4.625

    /** @type  <T> Array<out T>.count(): Int
     * @description Returns the number of elements in this array.
     * @summary 배열 원소들의 갯수를 반환 / count() 와 size 의 차이는 추후 정리
     */
    println("원소의 갯수 : ${newArray1.count()}") // 원소의 갯수 : 8

    /** @type  <@kotlin.internal.OnlyInputTypes T> Array<out T>.contains(element: T): Boolean
     * @description Returns true if element is found in the array.
     * @summary 배열에 해당 원소가 존재하면 true 값을 반환
     */
    println("2가 포함되어 있는가? : ${newArray1.contains(2)}") // 2가 포함되어 있는가? : true

    /** @type  <T : Comparable<T>> Array<T>.sortedArray(): Array<T>
     * @description Returns an array with all elements of this array sorted according to their natural sort order.
     * @summary 오름차순으로 정렬한 새로운 배열을 반환.
     */
    println("배열 오름차순 정렬 : ${newArray1.sortedArray().contentToString()}") // 배열 오름차순 정렬 : [1, 2, 3, 4, 6, 6, 7, 8]}

    /** @type  <T : Comparable<T>> Array<T>.sortedArrayDescending(): Array<T>
     * @description Returns an array with all elements of this array sorted descending according to their natural sort order.
     * @summary 내림차순으로 정렬한 새로운 배열을 반환.
     */
    println("배열 내림차순 정렬 : ${newArray1.sortedArrayDescending().contentToString()}") // 배열 내림차순 정렬 : [8, 7, 6, 6, 4, 3, 2, 1]}
}