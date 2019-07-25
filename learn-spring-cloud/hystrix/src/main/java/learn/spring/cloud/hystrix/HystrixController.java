package learn.spring.cloud.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @HystrixCommand //不加参数默认走@DefaultProperties
//    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/hystrix-api")
    public String hystrixApi() {
        return "This is hystrix api";
    }


    /**
     * 超时配置
     * com.netflix.hystrix.HystrixCommandProperties
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("/hystrix-api-3000")
    public String hystrixApi3000() throws InterruptedException {
        Thread.sleep(2000);
        return "This is hystrix api 3000";
    }


    /**
     * 熔断配置
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    @GetMapping("/hystrix-api-circuitBreaker")
    public String hystrixApiCircuitBreaker(@RequestParam("number") Integer number) {
        if (number % 2 == 0) {
            return "success";
        }
        return "This is hystrix api CircuitBreaker";
    }



    private String fallback() {
        return "retry later";
    }

    private String defaultFallback() {
        return "default: retry later";
    }

}
