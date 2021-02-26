package org.iptime.kibnm821.homepage.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Object SelectAccount(Map<String,Object> dataMap) {
        String accont = "account.login";

        Object result = sqlSessionTemplate.selectOne(accont,dataMap);

        return result;
    }

    @Override
    public void LogOut(HttpSession session) {

    }
}
