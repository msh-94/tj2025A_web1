package web.model.repository; // 패키지명

import org.springframework.stereotype.Repository;
import web.model.dto.ProductDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    // [2-1] 제품 전체 조회
    public List<ProductDto> getAllProduct(){
        List<ProductDto> list = new ArrayList<>();
        try{
            String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDto dto = new ProductDto();
                dto.setPno(rs.getInt("pno"));
                dto.setPname(rs.getString("pname"));
                dto.setPprice(rs.getInt("pprice"));
                dto.setPcomment(rs.getString("pcomment"));
                dto.setPdate(rs.getString("pdate"));
                dto.setPlat(rs.getDouble("plat"));
                dto.setPlng(rs.getDouble("plng"));
                dto.setMno(rs.getInt("mno"));
                list.add(dto);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

    // [2-2] 특정한 제품의 제품이미지명 전체 조회
    public List<String> getProductImages(int pno){
        List<String> list = new ArrayList<>();
        try{
            String sql = "select * from productimg where pno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String pimgname = rs.getString("pimgname");
                list.add(pimgname);
            }// while end
        } catch (Exception e) { System.out.println(e); }
        return list;
    }// func end

    // [3] 제품 개별 조회
    public ProductDto getProduct(int pno){
        try{
            String sql = "select * from product where pno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                ProductDto dto = new ProductDto();
                dto.setPno(rs.getInt("pno"));
                dto.setPname(rs.getString("pname"));
                dto.setPprice(rs.getInt("pprice"));
                dto.setPcomment(rs.getString("pcomment"));
                dto.setPdate(rs.getString("pdate"));
                dto.setPlat(rs.getDouble("plat"));
                dto.setPlng(rs.getDouble("plng"));
                dto.setMno(rs.getInt("mno"));
                return dto;
            }// if end
        } catch (Exception e) { System.out.println(e); }
        return null;
    }// func end

}// class end
