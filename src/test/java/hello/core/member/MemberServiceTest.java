package hello.core.member;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MemberService 클래스의")
public class MemberServiceTest {

    private MemberService memberService;

    @BeforeEach
    void setup() {
        /*AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
    }

    @DisplayName("join 메서드는")
    @Nested
    class Describe_join {
        @DisplayName("만약 아이디기 중복되지 않은 멤버를 저장할 경우")
        @Nested
        class Context_with_saved_valid_member {
            @DisplayName("회원 정보를 저장한다.")
            @Test
            void join() {
                //given
                Member memberA = new Member(1L, "memberA", Grade.VIP);

                //when
                memberService.join(memberA);
                Member findMember = memberService.findMember(memberA.getId());

                //then
                assertThat(findMember).isEqualTo(findMember);
            }
        }
    }



}
