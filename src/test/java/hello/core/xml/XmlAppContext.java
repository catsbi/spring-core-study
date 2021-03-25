package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("XML을 이용한 스프링 컨테이너 생성을 시도한다.")
public class XmlAppContext {

    @Test
    @DisplayName("XML파일을 설정정보로 넘겨준 뒤 빈을 조회한다.")
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
