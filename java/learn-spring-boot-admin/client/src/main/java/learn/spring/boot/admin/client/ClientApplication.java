package learn.spring.boot.admin.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableScheduling
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @GetMapping
    public String test() {
        log.info("current timestamp: " + System.currentTimeMillis());
        return "Hello: " + System.currentTimeMillis();
    }

    @Scheduled(fixedDelay = 5000)
    public void scheduled() {
        log.debug("schedule: " + System.currentTimeMillis());
    }

}
