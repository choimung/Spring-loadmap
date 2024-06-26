package hello.springtx.propagation;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

@Slf4j
@SpringBootTest
class MemberServiceTest {


    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired LogRepository logRepository;

    /**
     * memberService    @Transactional : OFF
     * memberRepository @Transactional : ON
     * logRepository    @Transactional : ON
     */
    @Test
    void outerTxOff_success() {
        //given
        String username = "outerTxOff_success";


        //when
        memberService.joinV1(username);

        //then
        assertTrue(memberRepository.findByUsername(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService    @Transactional : OFF
     * memberRepository @Transactional : ON
     * logRepository    @Transactional : ON RuntimeException
     */
    @Test
    void outerTxOff_fail() {
        //given
        String username = "로그예외_outerTxOff_fail";

        //when
        Assertions.assertThatThrownBy(() -> {
            memberService.joinV1(username);
        }).isInstanceOf(RuntimeException.class);


        //then
        assertTrue(memberRepository.findByUsername(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService    @Transactional : ON
     * memberRepository @Transactional : OFF
     * logRepository    @Transactional : OFF
     */
    @Test
    void singleTx() {
        //given
        String username = "outerTxOff_success";


        //when
        memberService.joinV1(username);

        //then
        assertTrue(memberRepository.findByUsername(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService    @Transactional : ON
     * memberRepository @Transactional : ON
     * logRepository    @Transactional : ON
     */
    @Test
    void outerTxOn_Success() {
        //given
        String username = "outerTxOn_Success";


        //when
        memberService.joinV1(username);

        //then
        assertTrue(memberRepository.findByUsername(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService    @Transactional : ON
     * memberRepository @Transactional : ON
     * logRepository    @Transactional : ON RuntimeException
     */
    @Test
    void outerTxOn_fail() {
        //given
        String username = "로그예외_outerTxOn_fail";

        //when
        Assertions.assertThatThrownBy(() -> {
            memberService.joinV1(username);
        }).isInstanceOf(RuntimeException.class);


        //then
        assertTrue(memberRepository.findByUsername(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService    @Transactional : ON
     * memberRepository @Transactional : ON
     * logRepository    @Transactional : ON RuntimeException
     */
    @Test
    void recoverException_fail() {
        //given
        String username = "로그예외_recoverException_fail";

        //when
        Assertions.assertThatThrownBy(() -> {
            memberService.joinV2(username);
        }).isInstanceOf(UnexpectedRollbackException.class);


        //then
        assertTrue(memberRepository.findByUsername(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService    @Transactional : ON
     * memberRepository @Transactional : ON
     * logRepository    @Transactional : ON(REQUIRED NEW) RuntimeException
     */
    @Test
    void recoverException_success() {
        //given
        String username = "로그예외_recoverException_success";

        //when
        memberService.joinV2(username);

        //then
        assertTrue(memberRepository.findByUsername(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }

}