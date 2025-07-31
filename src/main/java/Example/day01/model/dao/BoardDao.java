package Example.day01.model.dao; // 패키지명

import Example.day01.model.dto.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {// class start
    // 싱글톤
    private BoardDao(){ connect(); }
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){ return instance; }

    // db 연동
    private String db_url = "jdbc:mysql://localhost:3306/exam10";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,db_user,db_password);
        } catch (Exception e) { System.out.println(e); }// try end
    }// func end

    // (1) 등록 기능 구현
    public boolean boardWrite(BoardDto dto){
        // boolean      : 해당 메소드 실행 결과를 true(저장성공) false(저장실패) 반환 하기 위한 타입
        // BoardDto dto : controller 로부터 저장할 값들을 dto로 구성해서 받는 매개변수
        try {
            // 1. SQL 작성
            String sql = "insert into board(bcontent,bwriter) values( ? , ? )";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1,dto.getBcontent()); // sql내 1번 ?에 매개변수로 받은 dto의 Bcontent 값 대입
            ps.setString(2,dto.getBwriter()); // sql내 2번 ? 에 매개변수로 받은 dto의 Bwriter 값 대입
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/확인/리턴
            if (count >= 1)return true; // 1개 이상 insert 했으면 저장 성공
            return false; // 1개이상 insert 못했으면 저장 실패
        } catch (Exception e) { System.out.println(e); }// try end
        return false; // 예외 발생시 저장 실패
    }// func end

    // (2) 전체조회 기능 구현
    public ArrayList<BoardDto> boardPrint(){
        // 다른패키지의 Controller 가 접근하기 위해 public 다른패키지 접근 vs private 현재클래스만
        // ArrayList<BoardDto> : 배열 대신에 다양한 편의성 기능을 제공하는 ArrayList 클래스
        //      3=int타입 , 3 5 7 = int int int  --> int[] --> ArrayList<int>
        //      bcontent/bwriter = BoardDto타입 ,
        //      bcontent/bwriter bcontent/bwriter bcontent/bwriter = BoardDto BoardDto BoardDto
        //      ---> BoardDto[] --> ArrayList<BoardDto>
        ArrayList<BoardDto> dtos = new ArrayList<>();
        try{
            // 1. SQL 작성
            String sql = "select * from board";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입 , SQL문법에 ?(매개변수)가 없어서 생략
            // 4. SQL 실행 , select = executeQuery()
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/확인/리턴
            // 1) select 조회 결과 레코드 하나씩 조회
            while (rs.next()){ // rs.next() : ResultSet 인터페이스 갖는 (조회)결과테이블에서 다음레코드 하나씩 이동 뜻
                // 2) 조회중인 레코드를 속성값 호출해서 dto 만들기
                BoardDto dto = new BoardDto();
                dto.setBno(rs.getInt("bno"));
                dto.setBcontent(rs.getString("bcontent"));
                dto.setBwriter(rs.getString("bwriter"));
                // 3) 생성된 dto를 리스트에 담아주기
                dtos.add(dto);
            }// while end
        } catch (Exception e) { System.out.println(e); } // try end
        return dtos;
    }// func end

    // (3) 게시물 삭제 구현
    public boolean boardDelete(int bno){
        try{
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count = ps.executeUpdate();
            if (count >= 1) return true;
            return false;
        } catch (Exception e) { System.out.println(e); }// try end
        return false;
    }// func end

    // (4) 게시물 수정 구현
    public boolean boardUpdate(BoardDto dto){
        try{
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2,dto.getBno());
            ps.setString(1,dto.getBcontent());
            int count = ps.executeUpdate();
            if (count == 1) return true;
            return false;
        } catch (Exception e) { System.out.println(e); } // try end
        return false;
    }// func end
}// class end
