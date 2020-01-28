package com.zlk.web.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com")
@ImportResource("classpath:spring/dubbo/consumer.xml")
public class WebPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebPlatformApplication.class,args);
    }
}
