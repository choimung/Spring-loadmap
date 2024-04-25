package com.hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member hello = new Member("hello", 20);

        //when
        Member savemdMember = memberRepository.save(hello);

        //then
        Member findMember = memberRepository.findById(savemdMember.getId());
        assertThat(findMember).isEqualTo(savemdMember);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }

}