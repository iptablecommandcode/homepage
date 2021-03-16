package org.iptime.kibnm821.homepage.service;

import org.iptime.kibnm821.homepage.bean.CONTENT_VO;
import org.iptime.kibnm821.homepage.bean.PagingVO;

public interface ContentService {
    //메인 상위 3위 호출
    Object select_Top3(CONTENT_VO content_vo);
    //메인 게시판
    Object select_Content(PagingVO pagingVO);
//    게시판 글 개수
    Object count_Content(CONTENT_VO content_vo);
    //검색
    Object search_Content(PagingVO pagingVO);
    //글 상세정보
    Object Content_show(CONTENT_VO content_vo);
    //글 수정
    Object Content_update(CONTENT_VO content_vo);
    //글 생성
    Object Insert_Content(CONTENT_VO content_vo);
}