fun main(){
    /**
     * 아래와 같이 kotlin에서는 null을 _받을 수 없는_ 타입이 있다
     */
//    val a: String = null
//    var b: String = "bac"
//    b = null

    /**
     * nullable한 타입이 별도로 존재한다
     *
     * ?. : safety call
     */
    var _a: String? = null
    //_a.length
    _a?.length //출력 결과 : null

    val _b : Int = if(_a!= null) _a.length else 0
    println(_b) //0

    /**
     * 엘비스 연산자
     */
    val c = _a?.length ?: 0
    println(c) //0
}