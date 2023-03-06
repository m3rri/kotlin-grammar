class `1_Variable` {
    main()
}

/**
 * 변수의 top-level 선언. 현재 main() 함수도 마찬가지로 top-level 로 선언되어있는 것임
 *
 * 변수를 선언할 때 꼭 class 내부에 있지 않아도 된다.
 *
 * top level: block안에 종속되지 않고 계층의 최상위에 있다고 받아들이면 될듯
 *
 * 그러면 메모리의 어디에 저장되는걸까?
 */
var x = 5
fun main(){
    x += 1
    println(x)

    /**
     * 변수의 선언 및 할당 그리고 타입 추론
     *
     * 변수 b에서는 할당된 값을 통해서 compiler가 타입을 Int로 추론한뒤 자동으로 할당해줌
     */
    val a : Int = 1
    val b = 1

    /**
     * 지연할당
     *
     * 변수 c와 같이 일단 변수를 선언한 뒤 나중에 값을 할당할 수 있다.
     *
     * 단, 변수 d와 같이 타입을 함께 선언하지 않으면 컴파일 오류가 발생한다.(java 동일)
     */
    val c : Int
    c = 3
    val d
    d = 123

    /**
     * 변수 선언의 두 가지 키워드
     * ```
     * val : value. = java final 과 같이 한번 값이 할당되면 재할당이 불가능하다(변수 e)
     * var : variable. 재할당 가능함.
     * ```
     * 변수 f와 같이 처음에 Int로 타입 추론이 되어 타입이 고정된 변수의 경우, 이후에 다른 타입으로 재할당은 불가능하다.
     */
    val e : String = "Hello"
    e = "World"

    var f = 123
    f = "hi"
}