package org.iptime.kibnm821.homepage.repository;

import org.iptime.kibnm821.homepage.bean.CONTENT_VO;

public interface ContentDAO {
    Object SelectContent(String sqlMapId, CONTENT_VO content_vo);
}
