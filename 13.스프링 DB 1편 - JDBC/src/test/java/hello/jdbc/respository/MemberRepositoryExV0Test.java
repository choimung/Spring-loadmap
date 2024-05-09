package hello.jdbc.respository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import hello.jdbc.domain.Member;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class MemberRepositoryExV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void save() throws SQLException {

        //save
        Member member = new Member("memberV101", 10000);
        repository.save(member);

        //find
        Member findMember = repository.findById(member.getMember_id());
        assertThat(findMember).isEqualTo(member);

        //update
        repository.update(member.getMember_id(), 20000);
        Member updateMember = repository.findById(member.getMember_id());
        assertThat(updateMember.getMoney()).isEqualTo(20000);

        //delete
        repository.delete(member.getMember_id());
        Assertions.assertThatThrownBy(() -> repository.findById(member.getMember_id()))
                .isInstanceOf(NoSuchElementException.class);

    }
}