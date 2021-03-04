package org.iptime.kibnm821.homepage.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Object SelectAccount(Map<String,Object> dataMap) {
        String callquery = "account.login";

        return sqlSessionTemplate.selectOne(callquery,dataMap);
    }
}
