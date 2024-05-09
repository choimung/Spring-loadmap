package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.respository.MemberRepository;
import hello.jdbc.respository.MemberRepositoryV3;
import hello.jdbc.respository.MemberRepositoryV4_1;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberServiceV4 {

    private final MemberRepository memberRepository;

    public MemberServiceV4(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        bizlogic(fromId, toId, money);
    }

    private void bizlogic(String fromId, String toId, int money) {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);
        validate(toMember);
        memberRepository.update(toId, toMember.getMoney() + money);
    }

    private static void validate(Member toMember) {
        if(toMember.getMember_id().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}

