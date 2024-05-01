package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        System.out.println("name = " + name);

        log.trace("Trace log = {}", name);
        log.debug("Debug log = {}" ,name);
        log.info("Info log = {}", name);
        log.warn("Warn log = {}" ,name);
        log.error("Error log = {}" ,name);

        return "ok";
    }
}
