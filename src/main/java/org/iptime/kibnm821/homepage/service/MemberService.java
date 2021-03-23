package org.iptime.kibnm821.homepage.service;

import org.iptime.kibnm821.homepage.bean.ACCOUNT_VO;

public interface MemberService {
    Object Account_Check(ACCOUNT_VO account_vo);
    int Id_Check(String ID);
    int Create_Member(ACCOUNT_VO account_vo);
}
