package hello.itemservice.message;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;

    @Test
    public void helloMessage() {
        String result = messageSource.getMessage("hello", null, null);
        assertThat(result).isEqualTo("안녕");
    }

    @Test
    public void notFoundMessageCode() {
        Assertions.assertThatThrownBy(() -> messageSource.getMessage("no_cde", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    public void notFoundMessageCodeDefaultMessage() {
        String message = messageSource.getMessage("no_cde", null, "기본메세지", null);
        assertThat(message).isEqualTo("기본메세지");
    }

    @Test
    public void argumentMessage() {
        String message = messageSource.getMessage("hello.name", new Object[]{"spring"}, "기본메세지", null);
        assertThat(message).isEqualTo("안녕 spring");
    }

    @Test
    public void defaultLang() {
        assertThat(messageSource.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(messageSource.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
    }

    @Test
    public void enLang() {
        assertThat(messageSource.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }

}
