package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FiledServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void filed() {
        log.info("main start");

        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("tread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); //동시성 문제 발생 X
        sleep(100); //동시성 문제 발생
        threadB.start();

        sleep(2000); //메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int mllis) {
        try {
            Thread.sleep(mllis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
