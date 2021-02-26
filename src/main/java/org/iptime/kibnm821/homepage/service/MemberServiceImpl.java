package org.iptime.kibnm821.homepage.service;

import org.iptime.kibnm821.homepage.repository.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDAO memberDAO;


    @Override
    public Object LoginCheck(Map<String,Object> dataMap) {
        return memberDAO.SelectAccount(dataMap);
    }

    @Override
    public void LogOut(HttpSession session) {

    }
}
