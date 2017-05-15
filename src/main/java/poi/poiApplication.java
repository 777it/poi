package poi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//下記3つのアノテーションをまとめたもの
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class poiApplication {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(poiApplication.class, args);
  }
}
