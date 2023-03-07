fun main(){
    /**
     * when == java switch (java에서는 return을 안해준다(jdk11까지))
     * https://ugo04.tistory.com/37
     * https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8192963
     * https://blogs.oracle.com/javamagazine/post/new-switch-expressions-in-java-12
     */
    val day = 2

    val result = when (day){
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        else -> "기타"
    }
    println(result)

    /**
     * else를 생략
     */
    when(getColor()){
        Color.RED -> println("red")
        Color.GREEN -> println("green")
        else -> println("blue") //생략 가능. 단, else가 진짜로 안나오는게 확실한 경우에만. 그렇지 않으면 모든 경우에 대해서 처리해줘야한다.
    }

    /**
     * 여러개의 조건을 한번에 처리할 수 있다.
     */
    when (getNumber()){
        0, 1 -> println("0 or 1") //이런 화살표 형태로 간결하게 하는것도 12부터 가능함.
        2 -> println("not 0 and 1")
    }
}

enum class Color {
    RED, GREEN, BLUE
}

fun getColor() = Color.RED

fun getNumber() = 2