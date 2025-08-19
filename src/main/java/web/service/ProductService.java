package web.service;// 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dto.ProductDto;
import web.model.repository.ProductDao;

import java.util.List;

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

    // [2] 전체 제품 정보 + 이미지포함 조회
    public List<ProductDto> getAllProduct(){
        // 1. 모든 제품의 정보 조회
        List<ProductDto> productDtoList = productDao.getAllProduct();
        // 2.  모든 제품의 이미지 조회
        for (ProductDto dto : productDtoList){// 조회된 모든 제품 dto를 반복
            List<String> images = productDao.getProductImages(dto.getPno()); // 특정한 제품의 pno를 이용하여 모든 제품이미지 조회
            dto.setImages(images); // 조회한 모든 이미지명을 특정한 제품의 dto 포함
        }// for end
        return productDtoList;
    }// func end

    // [3] 제품 개별 조회
    public ProductDto getProduct(int pno){
        ProductDto dto = productDao.getProduct(pno);
        if (dto != null){
            List<String> images = productDao.getProductImages(dto.getPno());
            dto.setImages(images);
        }// if end
        return dto;
    }// func end

}// class end
