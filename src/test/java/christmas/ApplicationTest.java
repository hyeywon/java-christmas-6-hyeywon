package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("32");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("21", "바비큐립--3");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 정상_주문_테스트() {
        assertSimpleTest(() -> {
            run("17", "타파스-2,");
            assertThat(output()).contains("12월 17일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        });
    }

    @Test
    void 주문_불가능_테스트() {
        assertSimpleTest(() -> {
            runException("9", "제로콜라-3");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 주문_불가능_테스트2() {
        assertSimpleTest(() -> {
            runException("29", "시저샐러드-3, 티본스테이크-4, 크리스마스파스타-5, 제로콜라-6, 아이스크림-7");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
