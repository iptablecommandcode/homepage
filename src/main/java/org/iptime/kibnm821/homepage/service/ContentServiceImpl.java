package org.iptime.kibnm821.homepage.service;

import org.iptime.kibnm821.homepage.bean.CONTENT_VO;
import org.iptime.kibnm821.homepage.bean.PagingVO;
import org.iptime.kibnm821.homepage.repository.ContentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    ContentDAO contentDAO;

    //쿼리 호출
    private String sqlMapId;
    
    //상위 3개 요청
    @Override
    public Object select_Top3(CONTENT_VO content_vo) {
        sqlMapId = "content.top_notice";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectTopContent(sqlMapId, content_vo));

        return resultObject;
    }

    //NAV게시판
    @Override
    public Object select_Content(PagingVO pagingVO) {
        sqlMapId = "content.notice_board";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectContent(sqlMapId, pagingVO));

        return resultObject;
    }

    //글자 수
    @Override
    public Object count_Content(CONTENT_VO content_vo) {
        sqlMapId = "content.board_cnt";
        Object resultObject;

        resultObject = contentDAO.CountContent(sqlMapId, content_vo);

        return resultObject;
    }

    @Override
    public Object search_Content(PagingVO pagingVO) {
        sqlMapId = "content.search_board";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectContent(sqlMapId, pagingVO));

        return resultObject;
    }
//상세 게시판
    @Override
    public Object Content_show(CONTENT_VO content_vo) {
        sqlMapId = "content.board";
        Object resultObject = new HashMap<>();
        ((Map<String, Object>) resultObject).put("resultList", contentDAO.Content_show(sqlMapId, content_vo));

        return resultObject;
    }

    @Override
    public Object Content_update(CONTENT_VO content_vo) {
        sqlMapId = "content.update_board";
        Object resultObject;

        resultObject = contentDAO.Content_update(sqlMapId, content_vo);

        return resultObject;
    }

    @Override
    public Object Insert_Content(CONTENT_VO content_vo) {
        sqlMapId = "content.insert_board";
        Object resultObject;

        resultObject = contentDAO.Content_update(sqlMapId, content_vo);

        return resultObject;
    }
}