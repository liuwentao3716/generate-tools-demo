package com.test.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.lwt.tools", "**.mapper"})
@Slf4j
public class GenerateCodeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateCodeDemoApplication.class, args);
        log.debug("启动成功！");
    }

}
