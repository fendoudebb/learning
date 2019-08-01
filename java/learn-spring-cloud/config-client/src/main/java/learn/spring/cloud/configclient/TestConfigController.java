package learn.spring.cloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestConfigController {

    @Value("${config-client-test}")
    private String content;

    @GetMapping("/config-client-test-api")
    public String configClientTest() {
        return "This is config client test: " + content;
    }

}
