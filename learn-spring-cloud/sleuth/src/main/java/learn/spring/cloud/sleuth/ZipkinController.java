package learn.spring.cloud.sleuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinController {

    @GetMapping("/test-zipkin")
    public String test() {
        return "test zipkin";
    }

}
