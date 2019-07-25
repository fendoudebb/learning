package learn.spring.cloud.discoveryclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientOpenFeignApplication.class, args);
    }

}
