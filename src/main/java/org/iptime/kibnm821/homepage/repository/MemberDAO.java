package org.iptime.kibnm821.homepage.repository;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface MemberDAO {
    public Object SelectAccount(Map<String,Object> dataMap);
    public void LogOut(HttpSession session);
}