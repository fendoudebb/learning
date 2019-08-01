package learn.spring.cloud.discoveryclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientController {

    @GetMapping("/eureka-client-api")
    public String eurekaClientApi() {
        return "This is eureka client api!";
    }

}
