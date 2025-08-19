package web.service;// 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.repository.ProductDao;

@Service
public class ProductService { // class start
    // dao 불러오기
    private final ProductDao productDao;
    @Autowired
    public ProductService(ProductDao productDao){
        this.productDao = productDao;
    }
}// class end
