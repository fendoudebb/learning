package learn.spring.cloud.discoveryclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * zbj: created on 2019/7/14 12:48.
 */
@FeignClient(name = "EUREKA-CLIENT", fallback = EurekaClientApi.EurekaClientApiFallback.class)
public interface EurekaClientApi {

    @GetMapping("/eureka-client-api")
    String requestFromEurekaClientApi();

    @Component
    class EurekaClientApiFallback implements EurekaClientApi{

        @Override
        public String requestFromEurekaClientApi() {
            return null;
        }
    }

}
