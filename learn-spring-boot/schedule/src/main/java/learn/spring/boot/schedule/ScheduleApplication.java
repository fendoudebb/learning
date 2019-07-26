package learn.spring.boot.schedule;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            while (true) {
                Thread.sleep(50000);
//                System.out.println("runner: [" + Thread.currentThread().getName() + "-" + Thread.currentThread().getId() + "]");
            }
        };
    }

}
