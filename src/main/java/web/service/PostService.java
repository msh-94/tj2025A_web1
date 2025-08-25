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
    public PageDto findAllPost(int cno , int page , int count){
        // cno : 카테고리번호 , page : 현재페이지번호 , count : 페이지당 게시물수
        // 1. 페이지별 조회할 시작(인덱스)번호 계산
        /* 페이지당 5개씩 조회 한다는 가정 : 1페이지 -> 0 , 2페이지 -> 5 , 3페이지 -> 10 */
        int startRow = ( page -1 ) * count; // 현재페이지 -1 하고 페이지당 게시물수 곱한다.
        /* 1페이지 -> 1-1*5 -> 0   ,   2페이지 -> 2-1*5 -> 5  ,   3페이지 -> 3-1*5 -> 10 */
        // 2. 자료의 (게시물총)개수 구하기 , 카테고리별 , 이유 : 전체 페이지수 계산하기 위해
        int totalCount = postDao.getTotalCount(cno);
        // 3. 전체 페이지수 구하기
        int totalPage = totalCount%count == 0 ? totalCount/count : totalCount/count+1; // 나머지가 존재하면 +1
        int btnCount = 5; // 한 화면에 보여지는 최대 버튼수
        // 4. 시작버튼 구하기
        int startBtn = ((page-1)/btnCount)*btnCount + 1;
        // 5. 끝버튼 구하기
        int endBtn = startBtn + btnCount -1;
        if ( endBtn > totalPage) endBtn = totalPage; // 만약에 끝버튼수가 총페이지수 보다 커지면 끝번호는 총페이지수
        /* 총 페이지수가 13일때 , 현재페이지가 3이면 시작버튼 : 1 끝버튼 : 5 */
        // 6. 자료 요청 , cno:카테고리번호 , startRow(시작인덱스) , count(페이지당게시물수)
        List<PostDto> postList = postDao.findAll(cno,startRow,count);
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
