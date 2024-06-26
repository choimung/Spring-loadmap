package hello.proxy.config;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV3;
import hello.proxy.app.v2.OrderServiceV3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {

    @Bean
    public OrderControllerV2 orderControllerV2() {
        return new OrderControllerV2(orderServiceV2());
    }

    @Bean
    public OrderServiceV3 orderServiceV2() {
        return new OrderServiceV3(orderRepositoryV2());
    }

    @Bean
    public OrderRepositoryV3 orderRepositoryV2() {
        return new OrderRepositoryV3();
    }

}
