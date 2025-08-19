package web.controller;// 패키지명

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.model.dto.ProductDto;
import web.service.FileService;
import web.service.ProductService;

import java.util.List;

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
    public int createProduct( ProductDto dto , HttpServletRequest request){
        // 1. 로그인상태 확인후 , 비로그인이면 0 반환
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("logMno") == null){
            return 0;
        }// if end
        // 2. 제품정보를 DB 처리한다.
        int mno = (int)session.getAttribute("logMno");
        dto.setMno(mno);
        int result = productService.createProduct(dto);
        // 3. 만약에 업로드 파일이 존재하면 업로드서비스 호출하여 업로드 처리
            // 3-1 만약에 제품등록 했으면서 첨부파일이 비어있지 않고 첨부파일 목록에서 첫번째 첨부파일이 비어있지 않으면
        if (result > 0 && !dto.getUploads().isEmpty() && !dto.getUploads().get(0).isEmpty()){
            // 3-2 파일 업로드
            for (MultipartFile multipartFile : dto.getUploads()){
                // 3-3 업로드 서비스
                String fileName = fileService.fileUpload(multipartFile);
                if (fileName == null) return 0; // 만약에 파일명이 null 이면 업로드 실패 0 반환
                // 3-4 업로드 성공시 , 업로드 된 파일명을 db에 저장
                boolean result2 = productService.createProductImage(result,fileName); // result : 제품등록(pno) , fileName : 업로드파일명
                if (result2 == false) return 0; // 만약에 db에 이미지 저장 실패시 0 반환
            }// for end
        }// if end
        // 4. 처리된 업로드파일 DB 처리한다
        return result;
    }// func end

    // [2] 제품 전체 조회
    @GetMapping("/list")
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }// func end

    // [3] 제품 상세 조회
    @GetMapping("/find")
    public ProductDto getProduct(@RequestParam int pno){
        return productService.getProduct(pno);
    }// func end


}// class end
