package ol.kankan.kankan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"ol.kankan.kankan.mybatis.dao"})
@SpringBootApplication
public class KankanApplication {

    public static void main(String[] args) {
        SpringApplication.run(KankanApplication.class, args);
    }
}
