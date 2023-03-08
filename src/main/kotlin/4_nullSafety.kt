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
     * ? : nullable하게 변수를 선언한다
     * ?. : safety call
     */
    var _a: String? = null
    //_a.length
    _a?.length //출력 결과 : null

    val _b : Int = if(_a!= null) _a.length else 0
    println(_b) //0

    /**
     * 엘비스 연산자 : 엘비스 구렛나루 같이 생겨서 그렇게 부른다고함...;
     */
    val c = _a?.length ?: 0
    println(c) //0

    /**
     * safe cast 연산자 : as?
     */
    val d = null
    //val dInt: Int = d as Int;   //NPE 발생한다. null을 not-null type으로 cast 할 수 없기 때문. not-null type은 as 우측에 정의한 Int를 얘기한다.
    //val dInt: Int? = d as Int?; //NPE 발생을 피하기 위해서 as 우측에 nullable한 Int?로 cast 한다고 명령한 내용
    val dInt: Int? = d as? Int;   //위의 내용은 이렇게 사용하게 된다. as? 를 사용하면 not-null type 이어도 nullable하게 cast 해준다.
    println("type of d : "+dInt); //type of d : null

    /**
     * is 와 !is 연산자
     * 
     * 연산자 우측에 정의한 타입이 맞는지 확인하는 역할
     *
     * 동시에 연산 결과가 true인 경우 해당 타입으로 cast 한다. (down casting)
     */
    val e: Int = eval(Sum(Num(1), Num(3)))
    println(e) //4

    /**
     * collections of nullable type
     */
    var nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()
    nullableList = nullableList.map { item->item ?: 3 }
    println(intList)
    println(nullableList)
}

//https://hongku.tistory.com/352
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int = when(e){
    is Num -> e.value                     // e is Num 을 확인하면서 e가 Num class로 casting 되었음
    is Sum -> eval(e.left)+eval(e.right)  // e is Sum 을 확인하면서 e가 Sum class로 casting 되었음
    else -> throw IllegalArgumentException("Unknown expr")
}