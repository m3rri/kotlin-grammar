fun main(){
    /**
     * java for each와 유사함
     */
    /**
     * 범위 연산자 : ..
     */
    for(i in 0..3){
        println(i)
    }

    /**
     * until 연산자
     */
    for (i in 0 until 3){
        println(i)
    }

    /**
     * step 연산자. 음수는 지원하지 않음
     */
    for (i in 0 .. 6 step 2){
        println(i)
    }

    /**
     * downTo 연산자
     */
    for (i in 3 downTo 1){
        println(i)
    }

    for (i in 9 downTo 0 step 3){
        println(i)
    }

    /**
     * 배열을 순회
     */
    val numbers = arrayOf(1,2,3,4)
    for(i in numbers){
        println(i)
    }
}