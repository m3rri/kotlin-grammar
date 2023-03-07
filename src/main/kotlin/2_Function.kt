class `2_Function` {
}

/**
 * 코틀린은 함수 지향 프로그래밍언어이기 때문에 객체화 없이 바로 호출할 수 있음
 */
/**
 * __1. 기본적인 함수 선언 스타일__
 * - fun : 키워드
 * - sum : 함수 이름
 * - a, b : 함수 파라미터 및 그 타입
 * - Int : 리턴 타입
 *    - void인 경우 생략하거나(printSum), Unit 으로 지정하면 된다.
 */
fun sum(a: Int, b: Int) : Int {
    return a+b;
}

fun printSum(a: Int, b: Int) {
    println("$a + $b = ${a+b}")
}

/**
 * __2. 표현식 스타일__
 *
 * 단일 표현식 함수라고하여 중괄호를 생략하고 바로 함수 결과를 반환할 수 있다.
 */
fun sum2(a: Int, b: Int) : Int = a + b

/**
 * __3. 표현식 & 반환타입 생략__
 *
 * 변수의 타입을 추론하듯 함수의 리턴 타입을 추론할 수 있다면 생략할 수 있다.
 */
fun sum3(a: Int, b: Int) = a + b

/**
 * __4. 표현식 스타일이 아닌 경우 반환 타입을 생략하면 컴파일 오류가 발생함__
 *
 * 단, Unit인 경우에는 가능 (위의 printSum 참조)
 */
//fun sum4(a: Int, b: Int) {
//    return a+b
//}

/**
 * __5. default parameter__
 *
 * java에서는 없는 기능임
 * ```
 * public void greeting(String msg){
 *      if("".equals(msg) || msg.length==0){
 *          System.out.println("안녕하세요");
 *          return;
 *      }
 *      System.out.println(msg);
 * }
 * ```
 */
fun greeting(msg : String = "안녕하세요") {
    println(msg)
}

//fun main(){
//    greeting()
//    greeting("Hi")
//}

/**
 * named argument
 *
 * 함수 호출할 때 파라미터의 순서를 지키지 않아도 name = value 이런식으로 넘길 수 있다.
 */
fun log(level: String = "INFO", msg: String){
    println("[$level]$msg")
}

fun main(){
    log(msg="인포 로그")
    log(level = "DEBUG", "디버그 로그")
    log("WARN", "워닝 로그")
    log(level = "ERROR", msg="에러 로그")
}