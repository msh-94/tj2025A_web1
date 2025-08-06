package Example.day06; // 패키지명

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fetchController { // class start

    // (1)
    @GetMapping("/day06/exam1")
    public boolean method1(){
        return true;
    }// func end


}// class end
