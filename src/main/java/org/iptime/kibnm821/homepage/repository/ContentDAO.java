package org.iptime.kibnm821.homepage.repository;

import org.iptime.kibnm821.homepage.bean.CONTENT_VO;
import org.iptime.kibnm821.homepage.bean.PagingVO;

public interface ContentDAO {
    Object SelectTopContent(String sqlMapId, CONTENT_VO content_vo);
    Object SelectContent(String sqlMapId, PagingVO pagingVO);
    Object CountContent(String sqlMapId, CONTENT_VO content_vo);
    Object Content_show(String sqlMapId, CONTENT_VO content_vo);
    Object Content_update(String sqlMapId, CONTENT_VO content_vo);
    Object Insert_Content(String sqlMapId, CONTENT_VO content_vo);
}