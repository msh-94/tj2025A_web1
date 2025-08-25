package web.service; // 패키지명

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dto.PostDto;
import web.model.repository.PostDao;

@Service
public class PostService {// class start
    // dao 불러오기
    private final PostDao postDao;
    @Autowired
    public PostService(PostDao postDao){
        this.postDao = postDao;
    }

    // 게시물 등록 기능
    public int writePost(PostDto dto){
        int result = postDao.writePost(dto);
        return result;
    }// func end

}// class end
