package learn.dubbo.consumer;

import learn.dubbo.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZookeeperConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(group = "dubbo", version = "1.0.0")
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperConsumerApplication.class, args).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    logger.info(demoService.sayHello("mercyblitz"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
