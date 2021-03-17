package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RateDiscountPolicy 클래스의 ")
class RateDiscountPolicyTest {

    private DiscountPolicy discountPolicy;

    @BeforeEach
    void setup() {
        /*AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        discountPolicy = applicationContext.getBean("discountPolicy", DiscountPolicy.class);
    }

    @Nested
    @DisplayName("discount 메서드는")
    class Describe_discount{
        @Nested
        @DisplayName("VIP회원정보와 10000원을 전달하면")
        class Context_with_vip_and_10000 {
            @DisplayName("10%할인금액을 반환한다.")
            @Test
            void it_is_return_1000() {
                //given
                Member vip = new Member(1L, "VIP_MEMBER", Grade.VIP);

                //when
                int discount = discountPolicy.discount(vip, 10000);

                //then
                assertThat(discount).isEqualTo(1000);
            }
        }

        @Nested
        @DisplayName("BASIC회원정보와 10000원을 전달하면")
        class Context_with_basic_and_10000 {
            @DisplayName("0원을 반환한다.")
            @Test
            void it_is_return_zero() {
                //given
                Member basic = new Member(2L, "BASIC_MEMBER", Grade.BASIC);

                //when
                int discount = discountPolicy.discount(basic, 10000);

                //then
                assertThat(discount).isEqualTo(0);
            }
        }

    }

}
