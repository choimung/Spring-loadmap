package hello.jdbc.exception.basic;

import java.net.ConnectException;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
@Slf4j
public class UnCheckAppTest {


    @Test
    void checked() {
        Controller controller = new Controller();
        Assertions.assertThatThrownBy(() -> controller.request())
                .isInstanceOf(Exception.class);
    }

    @Test
    public void printEx() {
        //given
        Controller controller = new Controller();

        //when
        try{
            controller.request();
        }catch (Exception e) {
            log.info("ex", e);
        }

        //then
    }

    static class Controller {
        Service service = new Service();

        public void request() {
            service.logic();
        }
    }

    static class Service{
        NetworkClient networkClient = new NetworkClient();
        Repository repository = new Repository();

        public void logic() {
            networkClient.call();
            repository.call();
        }
    }

    static class NetworkClient {
        public void call() {
            throw new RuntimeConnectException("연결 실패");
        }
    }

    static class Repository {
        public void call() {
            try {
                runSQL();
            } catch (SQLException e) {
                throw new SQLRuntimeException(e);
            }
        }

        public void runSQL() throws SQLException {
            throw new SQLException("Ex");
        }
    }

    static class RuntimeConnectException extends RuntimeException {
        public RuntimeConnectException(String message) {
            super(message);
        }
    }

    static class SQLRuntimeException extends RuntimeException {
        public SQLRuntimeException(Throwable cause) {
            super(cause);
        }

    }
}
