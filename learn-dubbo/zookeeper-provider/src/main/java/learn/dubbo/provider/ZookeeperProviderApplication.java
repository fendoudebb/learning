package learn.dubbo.provider;

import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfigBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@EnableDubboConfig
@EnableDubboConfigBinding(prefix = "dubbo.metrics", type = MetricsConfig.class)
@EnableDubbo //代替dubbo.scan.base-packages配置
@SpringBootApplication
public class ZookeeperProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperProviderApplication.class, args)
                .addApplicationListener((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
                    Environment environment = event.getEnvironment();
                    int port = environment.getProperty("embedded.zookeeper.port", int.class);
                    new EmbeddedZooKeeper(port, false).start();
                });

        /*new SpringApplicationBuilder(ZookeeperProviderApplication.class)
                .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
                    Environment environment = event.getEnvironment();
                    int port = environment.getProperty("embedded.zookeeper.port", int.class);
                    new EmbeddedZooKeeper(port, false).start();
                })
                .run(args);*/

    }

}
