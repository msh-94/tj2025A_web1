package web.controller;// 패키지명

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.net.IPv6Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController // 스프링 컨테이너의 빈 등록
@RequestMapping("/file")
public class FileController {// class start
    // service 가져오기
    private final FileService fileService;
    @Autowired
    public FileController(FileService fileService){
        this.fileService = fileService;
    }
    // [1] 업로드
    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile){
        System.out.println("FileController.fileUpload");
        System.out.println("multipartFile = " + multipartFile);
        String result = fileService.fileUpload(multipartFile);
        return result;
    }// func end

    // [2] 다운로드
    @GetMapping("/download")
    // GET , http://localhost:8080/file/download?fileName=cb4d0a58-415a-4a8c-83b4-17cc3f8ec43e_e8410a597f7093bb10faf9badb7ce223f43ad912ad8dd55b04db6a64cddaf76d.gif
    public void fileDownload(@RequestParam String fileName , HttpServletResponse response){
        fileService.fileDownload( fileName , response );
    }// func end

    // [3] 파일 삭제
    @GetMapping("/delete")
    // GET , http://localhost:8080/file/delete?fileName=cb4d0a58-415a-4a8c-83b4-17cc3f8ec43e_e8410a597f7093bb10faf9badb7ce223f43ad912ad8dd55b04db6a64cddaf76d.gif
    public boolean fileDelete(@RequestParam String fileName){
        boolean result = fileService.fileDelete(fileName);
        return result;
    }// func end




}// class end
