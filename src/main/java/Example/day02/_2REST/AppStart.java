package Example.day02._2REST;// 패키지명

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {// class start
    public static void main(String[] args) { // main start
        SpringApplication.run(AppStart.class);
        // 1. SpringApplication 클래스
        // 2. .run() : static 선언된 스프링 실행 함수
        // 3. ( 현재클래스.class ) : 현재클래스를 매개변수 전달시 현재 클래스에 주입된 @SpringBootApplication 동작한다
    }// main end
}// class end
