/**
 * keyword : enum class
 * enum 생성자 : ??
 * 생성자가 있으면 enum에 똑같이 label 달아줘야함
 */
enum class PaymentStatus(val label: String): Payable{
    UNPAID("미지급"){
        override fun isPayable(): Boolean = true
    },
    PAID("지급완료"){
        override fun isPayable(): Boolean = false
    },
    FAILED("지급실패"){
        override fun isPayable(): Boolean = false
    },
    REFUNDED("환불"){
        override fun isPayable(): Boolean = false
    },
    ;

    //abstract fun isPayable(): Boolean
}

/**
 * 위에 abstract 키워드 붙인 isPayable 추상 메소드 대신에
 * 이 인터페이스를 만들어서 enum에서 구현하도록 할 수 있다.
 */
interface Payable {
    fun isPayable(): Boolean
}

fun main(){
    if(PaymentStatus.UNPAID.isPayable()){
        println(PaymentStatus.UNPAID.label)
    }
    /**
     * java와 동일하게 enum.valueOf 사용 가능
     */
    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    /**
     * 동등성 비교
     */
    if(paymentStatus == PaymentStatus.PAID) println("결제 완료 상태")

    /**
     * values() 메소드 사용
     * name, ordinal : enum에서 기본으로 제공하는 property
     * name : enum 이름 / ordinal : 정의된 순서
     */
    for(status in PaymentStatus.values()){
        println("[${status.name}] (${status.label}) : ${status.ordinal}")
    }
}