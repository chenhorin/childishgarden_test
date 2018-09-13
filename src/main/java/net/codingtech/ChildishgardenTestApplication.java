package net.codingtech;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "net.codingtech.dao.mapper")
public class ChildishgardenTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChildishgardenTestApplication.class, args);
    }
}
