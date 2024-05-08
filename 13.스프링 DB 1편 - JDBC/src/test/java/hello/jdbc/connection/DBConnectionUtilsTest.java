package hello.jdbc.connection;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import org.junit.jupiter.api.Test;

class DBConnectionUtilsTest {

    @Test
    void connection() {
        Connection connection = DBConnectionUtils.getConnection();
        assertThat(connection).isNotNull();
    }

}