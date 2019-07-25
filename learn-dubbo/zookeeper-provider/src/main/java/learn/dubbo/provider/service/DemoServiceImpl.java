package learn.dubbo.provider.service;

import learn.dubbo.service.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(group = "dubbo", version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    @Value("${spring.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

}
