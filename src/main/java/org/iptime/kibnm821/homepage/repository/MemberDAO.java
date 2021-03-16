package org.iptime.kibnm821.homepage.repository;

import org.iptime.kibnm821.homepage.bean.ACCOUNT_VO;

public interface MemberDAO {
    Object MemberCheck(String sqlMapId, ACCOUNT_VO account_vo);
}
