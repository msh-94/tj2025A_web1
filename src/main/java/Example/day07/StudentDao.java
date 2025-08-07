package Example.day07; // 패키지명

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDao { // class start
    // 싱글톤
    @Getter // 롬복 : 해당하는 멤버변수에만 getter 제공받을수 있다.
    private static final StudentDao instance = new StudentDao();
    private StudentDao(){connect();}
    // db 정보
    private String db_url = "jdbc:mysql://localhost:3306/spring07";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    // db연동 코드
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,db_user,db_password);
        } catch (Exception e) { System.out.println(e); }
    }// func end

    // 1. 등록
    public boolean save(StudentDto studentDto){
        try{
            String sql = "insert into student(sname,skor,smath) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,studentDto.getSname());
            ps.setInt(2,studentDto.getSkor());
            ps.setInt(3,studentDto.getSmath());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

    // 2. 전체조회
    public ArrayList<StudentDto> find(){
        ArrayList<StudentDto> list = new ArrayList<>();
        try{
            String sql = "select * from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                StudentDto dto = new StudentDto();
                dto.setSno(rs.getInt("sno"));
                dto.setSname(rs.getString("sname"));
                dto.setSkor(rs.getInt("skor"));
                dto.setSmath(rs.getInt("smath"));
                dto.setSdate(rs.getString("sdate"));
                list.add(dto);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

}// class end
