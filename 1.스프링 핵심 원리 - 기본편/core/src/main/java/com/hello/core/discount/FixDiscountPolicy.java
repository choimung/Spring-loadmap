package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1000; // 1,000원 할인
    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
