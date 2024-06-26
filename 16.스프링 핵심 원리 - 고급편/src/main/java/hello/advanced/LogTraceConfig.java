package hello.advanced;

import hello.advanced.trace.hellotrace.logtrace.FiledLogTrace;
import hello.advanced.trace.hellotrace.logtrace.LogTrace;
import hello.advanced.trace.hellotrace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
//        return new FiledLogTrace();
        return new ThreadLocalLogTrace();
    }
}
