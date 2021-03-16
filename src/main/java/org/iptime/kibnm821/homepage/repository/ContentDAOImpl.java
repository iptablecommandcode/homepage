package org.iptime.kibnm821.homepage.repository;

import org.iptime.kibnm821.homepage.bean.CONTENT_VO;
import org.iptime.kibnm821.homepage.bean.PagingVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDAOImpl implements ContentDAO{

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    //상위 3개 요청 쿼리
    @Override
    public Object SelectTopContent(String sqlMapId, CONTENT_VO content_vo) {
        Object resultObject = sqlSessionTemplate.selectList(sqlMapId, content_vo);
        return resultObject;
    }

    //게시판
    @Override
    public Object SelectContent(String sqlMapId, PagingVO pagingVO) {
        Object resultObject = sqlSessionTemplate.selectList(sqlMapId, pagingVO);
        return resultObject;
    }

//    글자 수
    @Override
    public Object CountContent(String sqlMapId, CONTENT_VO content_vo) {
        Object resultObject = sqlSessionTemplate.selectOne(sqlMapId, content_vo);
        return resultObject;
    }
//게시판 상세
    @Override
    public Object Content_show(String sqlMapId, CONTENT_VO content_vo) {
        Object resultObject = sqlSessionTemplate.selectList(sqlMapId, content_vo);
        return resultObject;
    }

    @Override
    public Object Content_update(String sqlMapId, CONTENT_VO content_vo) {
        Object resultObject = sqlSessionTemplate.update(sqlMapId, content_vo);
        return resultObject;
    }

    @Override
    public Object Insert_Content(String sqlMapId, CONTENT_VO content_vo) {
        Object resultObject = sqlSessionTemplate.insert(sqlMapId, content_vo);
        return resultObject;
    }

}