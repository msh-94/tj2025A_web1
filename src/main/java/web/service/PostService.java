package web.service; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dto.PostDto;
import web.model.repository.PostDao;

@Service
@RequiredArgsConstructor // 룸복제공 : final 변수에 대한 생성자 자동 생성
public class PostService {// class start
    // dao 불러오기
    private final PostDao postDao;

    // 게시물 등록 기능
    public int writePost(PostDto dto){
        int result = postDao.writePost(dto);
        return result;
    }// func end

}// class end
