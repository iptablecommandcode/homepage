package org.iptime.kibnm821.homepage.service;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface MemberService {
    public Object LoginCheck(Map<String,Object> dataMap);
    public void LogOut(HttpSession session);
}
