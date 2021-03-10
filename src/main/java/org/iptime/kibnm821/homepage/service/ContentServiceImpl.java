package org.iptime.kibnm821.homepage.service;

import org.iptime.kibnm821.homepage.bean.Paging;
import org.iptime.kibnm821.homepage.repository.ContentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    ContentDAO contentDAO;
    
    //순위
    @Override
    public Object TopContent(Map<String, Object> dataMap) {
        String sqlMapId = "content.top_notice";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectContent(sqlMapId,dataMap));

        return resultObject;
    }

    //게시판 표현
    @Override
    public Object Notice_Board(Map<String, Object> dataMap) {
        String sqlMapId = "content.notice_board";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectContent(sqlMapId, dataMap));

        return resultObject;
    }

    //검색
    @Override
    public Object Search_Board(Map<String, Object> dataMap) {
        String sqlMapId = "content.search_board";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectContent(sqlMapId, dataMap));

        return resultObject;
    }
    
    //게시판 상세 화면 출력
    @Override
    public Object Board(Map<String, Object> dataMap) {
        String sqlMapId = "content.board";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectContent(sqlMapId, dataMap));

        return resultObject;
    }
    
    //새 글 추가
    public void insert_Board(Map<String, Object> dataMap) {
        String sqlMapId = "content.insert_board";
        contentDAO.InsertContent(sqlMapId, dataMap);
    }

    //글 수정
    @Override
    public void update_Board(Map<String, Object> dataMap) {
        String sqlMapId = "content.update_board";
        contentDAO.UpdateContent(sqlMapId, dataMap);
    }

    //글 개수 검색
    @Override
    public Object Count_Board(Map<String, Object> dataMap) {
        String sqlMapId = "content.board_cnt";
        Object resultObject = contentDAO.SelectOne(sqlMapId,dataMap);

        return resultObject;
    }

    @Override
    public Object test(Paging paging) {
        String sqlMapId = "content.test";
        Object resultObject = new HashMap<>();
        resultObject = ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectText(sqlMapId, paging));
        return resultObject;
    }

}
