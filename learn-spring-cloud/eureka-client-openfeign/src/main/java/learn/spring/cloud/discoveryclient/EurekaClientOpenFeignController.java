package learn.spring.cloud.discoveryclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EurekaClientOpenFeignController {

    @Resource
    private EurekaClientApi eurekaClientApi;

    @GetMapping("/eureka-client-openfeign")
    public String requestEurekaClientOpenFeign() {
        return "Content: " + eurekaClientApi.requestFromEurekaClientApi();
    }

}
