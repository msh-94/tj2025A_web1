package web.service;// 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dto.ProductDto;
import web.model.repository.ProductDao;

@Service
public class ProductService { // class start
    // dao 불러오기
    private final ProductDao productDao;
    @Autowired
    public ProductService(ProductDao productDao){
        this.productDao = productDao;
    }

    // [1-1] 제품 등록
    public int createProduct(ProductDto dto){
        return productDao.createProduct(dto);
    }// func end

    // [1-2] 제품 이미지 등록
    public boolean createProductImage(int pno , String fileName){
        return productDao.createProductImage(pno, fileName);
    }// func end

}// class end
