package companionObject

/**
 *packageName    : companionObject
 * fileName       : CompanionObject
 * author         : Yeong-Huns
 * date           : 2025-02-06
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-06        Yeong-Huns       최초 생성
 */

fun main(){
    println(Student.national) // Korea
    Student.printNational(); // Korea
    /* companion object region 변수 할당 */
    Student.region = "경기도"

    /* 기본 생성자 이용 */
    val student1 = Student("홍길동", 18);
    student1.printInfo(); // 이름: 홍길동, 나이: 18, 국적: Korea, 거주지: 경기도

    /* Companion object 함수로 생성 */
    val student2 = Student.setStudent("홍성주", 15)
    student2.printInfo() // 이름: 홍성주, 나이: 15, 국적: Korea, 거주지: 경기도

    /* Companion object 의 region 변경 */
    Student.setRegion("강원도")

    /* 기존 학생들의 거주지도 변경됨 */
    student1.printInfo() // 이름: 홍길동, 나이: 18, 국적: Korea, 거주지: 강원도
    student2.printInfo() // 이름: 홍성주, 나이: 15, 국적: Korea, 거주지: 강원도

    /* 생성된 instance 에선 companion object 변수 접근 불가 */
    // student1.setRegion("경상도") // 오류


}

class Student(var name: String, var age: Int) {

    companion object {
        const val national : String = "Korea"
        lateinit var region : String

        val printNational = { println(national) }
        val setRegion = {str:String -> region = str}
        val setStudent = { name: String, age: Int -> Student(name, age) }
    }

    /* Class 에서 companion object 내부 변수 사용 가능 */
    val printInfo = { println("이름: ${this.name}, 나이: ${this.age}, 국적: $national, 거주지: $region") }
}