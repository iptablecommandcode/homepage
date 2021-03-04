package org.iptime.kibnm821.homepage.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ContentDAOImpl implements ContentDAO {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Object SelectContent(String sqlMapId, Map<String, Object> dataMap) {

        Object resultObject = sqlSessionTemplate.selectList(sqlMapId,dataMap);

        return resultObject;
    }
}
