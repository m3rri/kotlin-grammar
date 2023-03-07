fun main(){
    val job = "Software Developer"

    if (job == "Software Developer"){
        println("개발자")
    }else{
        println("개발자 아님")
    }

    /**
     * if...else 자체가 "식" 이기 때문에 아래와 같은 형태로 사용할 수 있다.
     */
    val age : Int = 10

    val str = if(age>20){
        "성인"
    }else{
        "아이"
    }

    println(str)

    /**
     * 삼항 연산자가 없는 코틀린
     */
    val a = 1
    val b = 2
    val c = if (b>a) b else a

    println(c)
}