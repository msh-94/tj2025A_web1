package web.service; // 패키지명

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.model.repository.PostDao;

import java.util.List;

@Service
@RequiredArgsConstructor // 룸북제공 : final 변수에 대한 생성자 자동 생성 , @Autowired 생략해도 자동으로 의존성이 처리된다
public class PostService {// class start
    // dao 불러오기
    private final PostDao postDao;

    // 게시물 등록 기능
    public int writePost(PostDto dto){
        int result = postDao.writePost(dto);
        return result;
    }// func end

    // 게시물 전체조회 *페이징*
    public PageDto findAllPost(int cno , int page , int count ,String key , String keyword){
        // 1. 페이지별 조회할 시작(인덱스)번호 계산
        int startRow = ( page -1 ) * count; // 현재페이지 -1 하고 페이지당 게시물수 곱한다.
        // 2/3 번만 검색이 있을때 없을때 나눠서 totalCount 와 postList 구해보자
        // 2. 자료의 (게시물총)개수 구하기 , 카테고리별 , 이유 : 전체 페이지수 계산하기 위해
        // 3. 자료 구하기
        int totalCount;
        List<PostDto> postList;
        if (key != null && !key.isEmpty() && keyword != null && !keyword.isEmpty()){ // (1) 검색일때
            // 만약에 key와 keyword가 null 아니면서 .isEmpty() : 비어있으면 true 반환 함수 [!부정문]
            // .(도트/접근)연산자는 변수가 NULL 일때 사용 안된다 (NullPointerException)
            totalCount = postDao.getTotalCountSearch(cno,key,keyword);
            postList = postDao.findAllSearch(cno,startRow,count,key,keyword);
        }else{ // (2) 검색아닐때
            totalCount = postDao.getTotalCount(cno);
            postList = postDao.findAll(cno,startRow,count);
        }// if end
        // 4. 전체 페이지수 구하기
        int totalPage = totalCount%count == 0 ? totalCount/count : totalCount/count+1; // 나머지가 존재하면 +1
        int btnCount = 5; // 한 화면에 보여지는 최대 버튼수
        // 5. 시작버튼 구하기
        int startBtn = ((page-1)/btnCount)*btnCount + 1;
        // 6. 끝버튼 구하기
        int endBtn = startBtn + btnCount -1;
        if ( endBtn > totalPage) endBtn = totalPage; // 만약에 끝버튼수가 총페이지수 보다 커지면 끝번호는 총페이지수
        // pageDto 구성하기
        PageDto pageDto = new PageDto();
        pageDto.setCurrentPage(page); // 현재페이지 번호
        pageDto.setTotalPage(totalPage); // 전체페이지 수
        pageDto.setPerCount(count); // 한페이지당 게시물 수
        pageDto.setTotalCount(totalCount); // 전체 게시물 수
        pageDto.setStartBtn(startBtn); // 시작 페이징 번호
        pageDto.setEndBtn(endBtn); // 끝 페이징 번호
        pageDto.setData(postList); // 페이징한 게시물 리스트
        return pageDto; // 반환
    }// func end


}// class end
