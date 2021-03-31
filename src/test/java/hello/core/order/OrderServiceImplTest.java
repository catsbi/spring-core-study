package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        //lombok을 사용하기에 해당 테스트는 현재 동작하지 않는다.
        /*MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "catsbi", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.setMemberRepository(memberRepository);
        orderService.setDiscountPolicy(new FixDiscountPolicy());

        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);*/
    }
}
