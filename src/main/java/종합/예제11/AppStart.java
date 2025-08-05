package 종합.예제11; // 패키지명

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트 실행
public class AppStart {// class start
    public static void main(String[] args) { // main start
        SpringApplication.run(AppStart.class);
        // 직접적으로 view 실행하는게 아닌 스프링(부트포함) 실행
        // + 스프링 실행하면 프로젝트내 resources 폴더의 HTML/CSS/JS 프론트엔드 싹 다 등록한다.
    }// main end
}// class end
