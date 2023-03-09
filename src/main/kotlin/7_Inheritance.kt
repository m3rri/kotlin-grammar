/**
 * 코틀린의 클래스는 기본적으로 final class이고, 상속할 클래스에 open keyword를 사용해준다.
 *
 * property의 경우에도, 상속받을 클래스에서 재정의(override)가 필요한 경우 property 선언할 때 open keyword를 사용한다.
 */
open class Dog {
    open var age: Int = 0;
    
    open fun bark(){
        println("몽몽")
    }
}

//Dog를 상속한 것이다.
//class Bulldog: Dog() {
//    override var age: Int = 0
//    override fun bark() {
//        println("컹컹")
//    }
//}

/**
 * 위 코드에서, property는 상속받은 하위 클래스의 기본 생성자에서 override 할 수도 있다.
 * 그리고 상위 클래스에서 open이어서 override했던 property는 자동으로 open으로 정의된다.
 * (class는 자동으로 open안됨)
 * 하위 클래스에서 override 할 수 없도록 하려면 그 앞에다가 다시 final keyword를 사용한다.
 */
open class Bulldog(override var age: Int = 0): Dog() {
    final override fun bark() {
        super.bark() //상위 클래스의 property에 접근하는 방법
        println("컹컹")
    }
}

class ChildBullDog: Bulldog(){
    override var age: Int = 0

//    override fun bark(){
//        super.bark()
//    }
}

/**
 * 추상 클래스
 */
abstract class Developer{
    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int) : Developer(){
    override fun code(language: String) {
        println("code with $language")
    }
}

fun main(){
    val dog = Bulldog(age = 3)
    println(dog.age)
    dog.bark() //하위 클래스에서 override 한 대로 "컹컹"이 나옴

    val backendDeveloper = BackendDeveloper(30)
    println(backendDeveloper.age)
    backendDeveloper.code("Kotlin")
}