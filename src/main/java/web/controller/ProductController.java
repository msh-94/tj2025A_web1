package web.controller;// 패키지명

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.ProductDto;
import web.service.FileService;
import web.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController { // class start
    // service 불러오기
    private final ProductService productService;
    private final FileService fileService;
    @Autowired
    public ProductController(ProductService productService , FileService fileService){
        this.productService = productService;
        this.fileService = fileService;
    }
    // [1] 제품 등록
    @PostMapping("/create")
    public int createProduct(@RequestBody ProductDto dto , HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("logMno") == null){
            return 0;
        }// if end
        int mno = (int)session.getAttribute("logMno");
    }
    // [2] 제품 전체 조회

    // [3] 제품 상세 조회


}// class end
