package org.iptime.kibnm821.homepage.service;

import org.iptime.kibnm821.homepage.bean.ACCOUNT_VO;
import org.iptime.kibnm821.homepage.repository.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDAO memberDAO;

    @Override
    public Object Account_Check(ACCOUNT_VO account_vo) {
        String sqlMapId = "member.login";

        return memberDAO.MemberCheck(sqlMapId, account_vo);
    }

    @Override
    public int Id_Check(String ID) {
        String sqlMapId = "member.idchk";

        return memberDAO.MemberIdCheck(sqlMapId, ID);
    }

    @Override
    public int Create_Member(ACCOUNT_VO account_vo) {
        String sqlMapId = "member.create";

        return memberDAO.CreateMember(sqlMapId, account_vo);
    }
}
