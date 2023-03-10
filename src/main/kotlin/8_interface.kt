class Product(val name: String, val price: Int)

interface Wheel{
    fun roll()
}

interface Cart : Wheel{

    /**
     * 추상 Property
     */
    var coin: Int

    /**
     * interface의 property는 backing field를 가질 수 없다!
     * weight 변수를 20KG로 초기화 하려고 하면 컴파일 에러가 발생함
     */
    val weight: String
        get() = "20KG"

    fun add(product: Product)
    fun rent(): Boolean{
        if(coin>0){
            println("카트를 대여합니다.")
            return true
        }else{
            println("코인을 넣어주세요")
            return false
        }
    } //이미 함수 블록이 생성되어있기 때문에 MyCart에서는 따로 override 안해도 됨

    override fun roll() {
        if(coin>0) println("카트가 굴러갑니다")
    }

    /**
     * 구현할 인터페이스 2개 모두에 동일한 구현 메소드가 있는 경우 (1)
     */
    fun printId() = println("c-1234")
}

interface Order{
    fun add(product: Product){
        println("${product.name} 주문이 완료되었습니다.")
    }

    /**
     * 구현할 인터페이스 2개 모두에 동일한 구현 메소드가 있는 경우 (2)
     */
    fun printId() = println("o-1234")
}

/**
 * 상속이었으면, Cart() 이렇게 했을텐데, 구현이라서 Cart만 작성하였음.
 * 
 * Cart 인터페이스 자체 그리고 내부에서 add, rent 선언할때, open 키워드를 사용하지 않아도,
 * 
 * Cart를 구현하는 클래스에서는 바로 override 가능하다
 * -> 애초에 클래스에서 구현해야하니까 키워드 작업을 하지 않음
 */
class MyCart(override var coin: Int) : Cart, Order{
    override fun add(product: Product) {
        //TODO("Not yet implemented")
        if(coin>0){
            println("${product.name}이(가) 카트에 추가됐습니다.")
            super<Order>.add(product)
            //두 개 이상의 인터페이스를 구현하려고 하는데, 메소드 및 그 파라미터가 동일한 경우 위와 같이 super 키워드를 통해 구분하여준다.
        }
    }

    /**
     * 구현할 인터페이스 2개 모두에 동일한 구현 메소드가 있는 경우 (3)
     *
     * 2개를 모두 구현할 수는 없고, 같은 이름의 메소드 1개만 구현한다.
     * 메소드 안에서 각각의 인터페이스 메소드에 접근하려면 add 메소드에서 했던 것처럼 super 키워드를 사용한다.
     */
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}

fun main(){
    val myCart = MyCart(coin = 1)

    if(myCart.rent()){
        myCart.printId()
        myCart.roll()
        myCart.add(Product(name="장난감", price=1000))
    }
}