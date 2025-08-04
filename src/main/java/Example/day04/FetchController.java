package Example.day04;// 패키지명

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // @Controller(+Component) + @ResponseBody
// HTTP(클라이언트)의 요청 과 응답 처리 담당
public class FetchController {// class start
    // ======================== 요청에 따른 매개변수 [ ()안에 ] 없고 , 반환값 [ VOID ] 도 없다 ========================
    // 1. HTTP 정의 , METHOD : GET , URL : /day04/exam1
    @GetMapping("/day04/exam1") // Talend API : GET , http://localhost:8080/day04/exam1
    public void method1(){ System.out.println("FetchController.method1"); // soutm
    }// func end

    // 2. HTTP 정의 , METHOD : POST , URL : /day04/exam2
    @PostMapping("/day04/exam2") // Talend API : POST , http://localhost:8080/day04/exam2
    public void method2(){ System.out.println("FetchController.method2");
    } // func end

    // 3. HTTP 정의 , METHOD : PUT , URL : /day04/exam3
    @PutMapping("/day04/exam3") // Talend API : PUT , http://localhost:8080/day04/exam3
    public void method3(){ System.out.println("FetchController.method3");
    }// func end

    // 4. HTTP 정의 , METHOD : DELETE , URL : /day04/exam4
    @DeleteMapping("/day04/exam4") // Talend API : DELETE , http://localhost:8080/day04/exam4
    public void method4(){ System.out.println("FetchController.method4");
    }// func end

    // ========================  ========================
    // 5. 매개변수( 쿼리스트링 ) 반환값(JSON)
    // http://localhost:8080/day04/exam5?name=유재석&age=10
    // response : 200 , true
    @GetMapping("/day04/exam5")
    public boolean method5( @RequestParam String name , @RequestParam int age){
        System.out.println("FetchController.method5");
        System.out.println("name = " + name + ", age = " + age); // soutp
        boolean result = true; // 임의의 값
        System.out.println("result = " + result); // 가장 가까운 지역변수 출력함수
        return result;
    }// func end

    // 6. 매개변수(HTTP본문) 반환타입(JSON)
    // http://localhost:8080/day04/exam6 , BODY : { "name" : "유재석" , "age" : "40" }
    // response : 200 , 20
    @PostMapping("/day04/exam6")
    public int method6( @RequestBody Map<String,String> map){
        System.out.println("FetchController.method6");
        System.out.println("map = " + map);
        int result = 20;
        return result;
    }// func end

    // 7.
    // http://localhost:8080/day04/exam7 , BODY : { "name" : "유재석" , "age" : "40" }
    // response : 200 , { "name" : "강호동" , "age" : "40" }
    @PutMapping("/day04/exam7")
    public TaskDto method7( @RequestBody TaskDto dto ){
        System.out.println("FetchController.method7");
        System.out.println("dto = " + dto);
        TaskDto result = new TaskDto("강호동",40); // 임의 값
        return result;
    }// func end

    // 8.
    // request : http://localhost:8080/day04/exam8?name=유재석&age=10
    // response : [ { "name": "강호동", "age": 10 }, { "name": "유재석", "age": 20 } ]
    @DeleteMapping("/day04/exam8")
    public List<TaskDto> method8( @RequestParam String name , @RequestParam int age ){
        System.out.println("FetchController.method8");
        System.out.println("name = " + name + ", age = " + age);
        List<TaskDto> result = new ArrayList<>(); // 임의 값
        result.add(new TaskDto("강호동",10));
        result.add(new TaskDto("유재석",20));
        return result;
    }// func end

}// class end
