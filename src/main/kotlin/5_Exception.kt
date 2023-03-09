fun main(){
    Thread.sleep(1); //java에서는 예외 발생하는 메소드를 호출했지만, 별도의 처리 안해도 됨
    
    try{
        throw Exception()
    }catch(e : Exception){
        println("에러 발생")
    }finally{
        println("finally 실행됨")
    }

    /**
     * 코틀린의 try~catch는 표현식이다-> 값을 리턴해서 변수에 할당할 수 있음
     */
    val a = try{
        "1234a".toInt()
    }catch (e: Exception){
        0
    }

    println(a)

    /**
     * 예외를 직접 던질 수 있음
     */
    //throw Exception("예외 메시지")

//    failFast("예외 메시지")
//    println("이 메시지는 출력되지 않는다.")

    /**
     * Nothing return 타입과 엘비스 연산자를 함께 사용하는 경우
     *
     * 변수 c에 대해서 좌변이 null이 아니면, 무조건 c는 null이 아니고
     *
     * 좌면이 null이면 우변이 nothing 타입으로 어쨌든 그 이후 코드가 실행되지 않음
     *
     * 그래서 원래는 null 안정성 연산자인 "?."를 사용해서 c의 길이를 구해야 하지만 "?"가 없어도 컴파일 에러가 발생하지 않음
     */
    val b: String? = null
    val c = b ?: failFast("b is null")

    println(c?.length)
    println(c.length)
}

/**
 * 리턴 타입인 Nothing 생략 가능.
 *
 * 코드가 정상적으로 수행되지 않는 것을 보장하는 경우에 사용할 수 있음.->예외를 던지는 경우.
 */
fun failFast(msg: String) :Nothing{
    throw IllegalArgumentException(msg);
}

