package org.iptime.kibnm821.homepage.service;

import org.iptime.kibnm821.homepage.bean.CONTENT_VO;
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
    public Object select_Top3(CONTENT_VO content_vo) {
        String sqlMapId = "content.top_notice";
        Object resultObject = new HashMap<>();

        ((Map<String, Object>) resultObject).put("resultList", contentDAO.SelectContent(sqlMapId, content_vo));

        return resultObject;
    }
}
