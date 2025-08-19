package web.model.repository; // 패키지명

import org.springframework.stereotype.Repository;
import web.model.dto.ProductDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class ProductDao extends Dao{ // class start
    // [1-1] 제품 등록
    public int createProduct(ProductDto dto){
        try{
            String sql = "insert into product(pname,pprice,pcomment,plat,plng,mno) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS ); // (1) pk값 리턴받기
            ps.setString(1,dto.getPname());
            ps.setInt(2,dto.getPprice());
            ps.setString(3,dto.getPcomment());
            ps.setDouble(4,dto.getPlat());
            ps.setDouble(5,dto.getPlng());
            ps.setInt(6,dto.getMno());
            int count = ps.executeUpdate();
            if (count == 1){
                ResultSet rs = ps.getGeneratedKeys();// (2) 등록된 레코드의 pk값 가져오기
                if (rs.next())return rs.getInt(1); // (3) 등록된 레코드의 첫번째 pk값 반환(pno)
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return 0;
    }// func end

    // [1-2] 제품 이미지 등록
    public boolean createProductImage(int pno , String fileName){
        try{
            String sql = "insert into productimg(pimgname , pno) values( ? , ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,fileName);
            ps.setInt(2,pno);
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) { System.out.println(e); }
        return false;
    }// func end

}// class end
