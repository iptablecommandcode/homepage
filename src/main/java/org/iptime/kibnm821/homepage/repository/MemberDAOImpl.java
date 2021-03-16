package org.iptime.kibnm821.homepage.repository;

import org.iptime.kibnm821.homepage.bean.ACCOUNT_VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;


    @Override
    public Object MemberCheck(String sqlMapId, ACCOUNT_VO account_vo) {
        Object resultObject;
        resultObject = sqlSessionTemplate.selectOne(sqlMapId, account_vo);

        return resultObject;
    }
}
