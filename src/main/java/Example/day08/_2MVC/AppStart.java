package Example.day08._2MVC; // 패키지명

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {// class start
    public static void main(String[] args) { // main start
        SpringApplication.run(AppStart.class);
        // Web server failed to start. Port 8080 was already in use 웹서버가 2개이상 켜져있다
    }// main end
}// class end
