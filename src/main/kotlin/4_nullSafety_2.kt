fun getNullStr(): String? = null

fun getLengthIfNotNull(str: String?) = str?.length ?: 0

fun main(){

    val nullableStr = getNullStr()

    //val nullableStrLength = nullableStr.length
//    val nullableStrLength = nullableStr?.length ?: "null인 경우 반환".length
    val nullableStrLength = getLengthIfNotNull(nullableStr)

    println(nullableStrLength)


    /**
     * 코틀린에서 NPE가 발생하는 경우
     */
    //throw NullPointerException()

//    val c: String? = null
//    val d = c!!.length //단언 연산자(not-null assertion operator)
//    println(d)

    println(Four_JavaNullSafety.getNullStr()?.length) //null
    println(Four_JavaNullSafety.getNullStr().length)  //NPE
    //이 코드의 경우 java에서 분명히 null을 리턴하도록 되어있지만 코틀린 컴파일러가 여기까지 파악하지 않기 때문에 실행시 NPE 가 발생한다.
}