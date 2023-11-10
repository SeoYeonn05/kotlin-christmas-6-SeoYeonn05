package christmas.util.constant

object Constants {
    private const val PROMOTION_MONTH = 12
    private const val promotionDate = 3
    const val START_MESSAGE = "안녕하세요! 우테코 식당 ${PROMOTION_MONTH}월 이벤트 플래너입니다."
    const val REQUEST_RESERVATION_DATE = "${PROMOTION_MONTH}월 중 식당 예약 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
    const val REQUEST_RESERVATION_MENU = "주문하실 메뉴를 메뉴와 개수로 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
    const val INFORM_PROMOTION_BENEFITS = "${PROMOTION_MONTH}월 ${promotionDate}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
    const val ORDERED_MENU = "<주문 메뉴>"
    const val TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>"
    const val GIVEAWAY_MENU = "<증정 메뉴>"
    const val BENEFIT_DETAILS = "<혜택 내역>"
    const val TOTAL_BENEFIT_AMOUNT = "<총혜택 금액>"
    const val EXPECTED_PAYMENT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>"
    const val DECEMBER_EVENT_BADGE = "<12월 이벤트 배지>"
    const val CHRISTMAS_D_DAY_DISCOUNT = "크리스마스 디데이 할인:"
    const val WEEKDAY_DISCOUNT = "평일 할인:"
    const val SPECIAL_DISCOUNT = "특별 할인:"
    const val GIVEAWAY_PROMOTION = "증정 이벤트:"
    const val WON = "원"
}

