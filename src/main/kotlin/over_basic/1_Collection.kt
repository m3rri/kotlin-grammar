import java.util.*

fun main() {
    //immutable
    val currencyList = listOf("달러", "유로", "원")
    //currencyList.add("??")

    //mutable - add 같은 메소드로 요소를 추가해나갈 수 있음
    val mutableCurrencyList = mutableListOf<String>()
    mutableCurrencyList.add("달러")
    mutableCurrencyList.add("유로")
    mutableCurrencyList.add("원")

    //inline으로 add 하는 방법 : 변수 호출 없이 바로 method에 접근할 수 있다. (this. 가 생략됨)
    val mutableCurrencyList2 = mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("원")
    }

    //immutable set
    val numberSet = setOf(1, 2, 3, 4)

    //mutable set
    val mutableNumberSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    //immutable map
    val numberMap = mapOf("one" to 1, "two" to 2)

    //mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1    //권장
    mutableNumberMap.put("two", 2) //권장하지 않음

    /**
     * collection builder
     * builder 내부에서는 Mutable List를 가지고 작업을 하지만
     * 최종적으로 리턴하는 객체는 Immutable List임
     */

    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }
    //numberList.add(4)

    //linkedList
    val linkedList = LinkedList<Int>().apply {
        add(2)
        addLast(1)
        addFirst(3)
    }
    println(linkedList)

    //arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    //iterator
    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("=====for loop======")

    //for loop
    for (currency in currencyList) {
        println(currency)
    }

    println("======stream=======")
    currencyList.forEach {
        println(it) //lambda에서 자세하게 학습 예정
    }

    println("======for loop -> map=======")
    //for loop -> map
    //map을 안쓰는 경우
    val lowerList = listOf("a", "b", "C")
    var upperList = mutableListOf<String>()
    for (lowerCase in lowerList) {
        upperList.add(lowerCase.uppercase())
    }
    println(upperList)

    upperList = lowerList.map{it.uppercase()}.toMutableList()
    println(upperList)

    println("======filter======")
    var filteredList = mutableListOf<String>()
    for(upperCase in upperList){
        if(upperCase != "B"){
            filteredList.add(upperCase)
        }
    }
    println(filteredList)

    filteredList = upperList.filter{it != "B"}.toMutableList()
    println(filteredList)

    /**
     * java 8 stream같은 경우 terminal operator가 있어야 동작을 함
     * upperList._stream()_.filter()._collect()_
     *
     * 유사한 동작으로 .asSequence()~.toList() 가 있음 (메모리적으로는 toList가 좋다고 하는데 엄청 많은 데이터를 다루지 않는 경우에는 메리트 없음)
     * 이거 안쓰면 inline 함수라고 부른다.
     */
}