package Example.실습2;// 패키지명

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BoardController {// class start
    ArrayList<BoardDto> list = new ArrayList<>();
    int result = 0;
    @PostMapping("/board")
    // http://localhost:8080/board?bcontent=안녕하세요&bwriter=유재석
    public boolean boardWrite(String bcontent , String bwriter){
        System.out.println("BoardController.boardWrite");
        System.out.println("bcontent = " + bcontent + ", bwirter = " + bwriter);
        BoardDto dto = new BoardDto();
        dto.setBno(result+=1);
        dto.setBcontent(bcontent);
        dto.setBwriter(bwriter);
        list.add(dto);
        return true;
    }// func end

    @GetMapping("/board")
    public ArrayList< BoardDto > boardPrint(){
        System.out.println("BoardController.boardPrint");
        System.out.println(list);
        return list;
    }// func end

    @GetMapping("/board/detail")
    // http://localhost:8080/board/detail?bno=1
    public BoardDto boardDetail(int bno){
        System.out.println("BoardController.boardDetail");
        System.out.println("bno = " + bno);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getBno() == bno){
                return list.get(i);
            }// if end
        }// for end
        return null;
    }// func end

    @DeleteMapping("/board")
    public boolean boardDelete(int bno){
        System.out.println("BoardController.boardDelete");
        System.out.println("bno = " + bno);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getBno() == bno){
                list.remove(i);
                return true;
            }// if end
        }// for end
        return false;
    }// func end

    @PutMapping("/board")
    public boolean boardUpdate(@RequestBody BoardDto dto){
        System.out.println("BoardController.boardUpdate");
        System.out.println("dto = " + dto);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getBno() == dto.getBno()){
                list.get(i).setBno(dto.getBno());
                list.get(i).setBwriter(dto.getBwriter());
                list.get(i).setBcontent(dto.getBcontent());
                return true;
            }// if end
        }// for end
        return false;
    }// func end

}// class end
