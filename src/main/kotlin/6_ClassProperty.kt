/**
 * 클래스를 선언하는 방법 : class 예약어 사용
 * 
 * 클래스 명 우측으로 생성자 예약어와 생성자 함수의 파라미터를 작성한다
 * 
 * 근데 생성자 예약어는 특정 어노테이션을 사용해야 하는 경우를 제외하고는 생략해서 사용하는 것이 일반적이라고 함
 */
//class Coffee constructor(val name: String){
class Coffee(var name: String? = "")
//Coffee 클래스 처럼 {} 내부에 정의된 내용이 없으면 생략할 수 있다.
//아래의 EmtpyClass랑은 다름. 걔는 생성자 파라미터도 없는 상태라서 class property가 없어 진짜 비어있는 객체임
/**
 * class property는 var, val 타입 모두 선언 가능하다.
 */

/**
 * trailing comma (후행 쉼표)
 *
 * TrailingCoffee 클래스의 파라미터 부분을 보면, price 파라미터 선언줄 끝에 ","가 남아 있어도 컴파일 에러가 발생하지 않는 것을 볼 수 있음
 *
 * 여러개를 열거하는 경우에는 어떤 상황에서도 사용할 수 있다.
 *
 * class 생성자 파라미터, method 파라미터, enum class, ...
 *
 * code diff시 변경점을 명확하게 볼 수 있다는 작지만 큰 차이점이...
 */
class TrailingCoffee(
    val name: String,
    val price: Int,
){
    /**
     * custom getter setter
     */
    val brand: String
        get() = "starbucks"

    var quantity: Int = 0
        set(value){
            if(value>0){
                field = value
                //quantity = value
            }
        }
    /**
     * backing field
     * 여기서 field 대신에 quantity를 사용하게 되면 stackoverflow 에러가 발생하게 된다.
     * getter, setter에 custom logic이 필요한 경우에 이 개념을 사용해야 한다.
     * quantity는 property이기 때문에 accessor안에서 property에 접근하면, accessor가 또 다시 호출되어 위같은 에러가 발생하는 것.
     * backing field는 property의 accessor안에서 사용하기 위해 생성된다.
     *
     * field vs property
     * field : 값을 가지고 있는 그냥 class 멤버 변수. 읽기만 가능하거나, 수정도 가능하다 (var, val)
     * public일 수도 있고, private일 수도 있다.
     * property : private field와 accessors를 가지는 좀더 복잡한 element이다.
     *
     * read-only property = private field + getter
     * mutable property = private field + getter + setter
     * https://proandroiddev.com/backing-properties-in-kotlin-cb78dfebfd90
     *
     * backing property
     * ??? 모르겠음..
     */
}

class EmptyClass

fun main(){
    val coffee = Coffee(null)
    println(coffee.name)  //그냥 변수에 접근하는 것 같지만 실제로는 Coffee class의 getName()을 호출한 것과 같다.
    coffee.name = "아바라" //마찬가지로 Coffee class의 setName()을 실행한 것과 같다.
    // java로 decompile 해보면 getter, setter 다 있다고 함
    // 변수를 val type으로 선언하면, 변수 선언시 값도 할당되기 때문에, 별도의 setter가 없고 getter만 생성되어 사용가능해진다.

    val trailingCoffee = TrailingCoffee("아아", 1000);
    println(trailingCoffee.brand)
    trailingCoffee.quantity = 1
    println(trailingCoffee.quantity)
    trailingCoffee.quantity = -1
    println(trailingCoffee.quantity)
    trailingCoffee.quantity = 10
    println(trailingCoffee.quantity)
}