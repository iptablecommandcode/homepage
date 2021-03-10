package org.iptime.kibnm821.homepage.repository;

import org.iptime.kibnm821.homepage.bean.CONTENT_VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDAOImpl implements ContentDAO{

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Object SelectContent(String sqlMapId, CONTENT_VO content_vo) {
        Object resultObject = sqlSessionTemplate.selectList(sqlMapId, content_vo);
        return resultObject;
    }
}
