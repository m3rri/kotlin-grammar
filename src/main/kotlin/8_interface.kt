class Product(val name: String, val price: Int)
interface Cart{
    fun add(product: Product)
    fun rent(){}
}

/**
 * 상속이었으면, Cart() 이렇게 했을텐데, 구현이라서 Cart만 작성하였음.
 * 
 * Cart 인터페이스 자체 그리고 내부에서 add, rent 선언할때, open 키워드를 사용하지 않아도,
 * 
 * Cart를 구현하는 클래스에서는 바로 override 가능하다
 * -> 애초에 클래스에서 구현해야하니까 키워드 작업을 하지 않음
 */
class MyCart : Cart{
    override fun add(product: Product) {
        TODO("Not yet implemented")
    }

}

