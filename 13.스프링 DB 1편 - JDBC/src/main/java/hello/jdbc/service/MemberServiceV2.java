package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.respository.MemberRepositoryV1;
import hello.jdbc.respository.MemberRepositoryV2;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceV2 {

    private final DataSource dataSource;
    private final MemberRepositoryV2 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {

        Connection con = dataSource.getConnection();
        try{
            con.setAutoCommit(false);
            //비즈니스 로직
            Member fromMember = memberRepository.findById(con, fromId);
            Member toMember = memberRepository.findById(con, toId);

            memberRepository.update(fromId, fromMember.getMoney() - money);
            if(toMember.getMember_id().equals("ex")) {
                throw new IllegalStateException("이체중 예외 발생");
            }
            memberRepository.update(toId, toMember.getMoney() + money);

            con.commit();   //성공시 커밋
        }catch (SQLException e){
            con.rollback();
            throw new IllegalStateException(e);
        }finally {
            if (con != null) {
                try{
                    con.setAutoCommit(true);
                    con.close();
                }catch (Exception e){
                    log.info("error" , e);
                }
            }
        }
    }

}
