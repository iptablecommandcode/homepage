package org.iptime.kibnm821.homepage.service;

import org.iptime.kibnm821.homepage.repository.ContentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    ContentDAO contentDAO;

    @Override
    public Object TopContent(Map<String, Object> dataMap) {
        String sqlMapId = "content.top_notice";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectContent(sqlMapId,dataMap));

        return resultObject;
    }

    @Override
    public Object Notice_Board(Map<String, Object> dataMap) {
        String sqlMapId = "content.notice_board";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectContent(sqlMapId, dataMap));

        return resultObject;
    }
}
