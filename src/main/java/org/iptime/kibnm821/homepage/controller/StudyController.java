package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StudyController {

    @Autowired
    ContentService contentService;

    private final static String MAPPING = "Main/Study/";

    //상단 메뉴 Web
    @RequestMapping(value = MAPPING + "{action}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView Check_Content_Board(@PathVariable String action, ModelAndView modelAndView, HttpServletRequest request) {
        String setViewName = MAPPING + action;
        Object resultMap = new HashMap<String, Object>();
        Map<String, Object> dbRequest = new HashMap<String, Object>();

        //웹 별로 구분
        try {
            if (action.equals("Search")) {
                //웹 입력갑 저장 검색시
                String TITLE = request.getParameter("TITLE");
                String SEARCH = request.getParameter("SEARCH");
                String BIGHEADTITLE = request.getParameter("BIGHEADTITLE");

                dbRequest.put("TITLE", TITLE);
                dbRequest.put("SEARCH", SEARCH);
                dbRequest.put("BIGHEADTITLE", BIGHEADTITLE);

                resultMap = contentService.Search_Board(dbRequest);

                setViewName = MAPPING + request.getParameter("BIGHEADTITLE");
            } else {
                //기본 WEB이나 Security페이지
                dbRequest.put("BIGHEADTITLE", action);

                resultMap = contentService.Notice_Board(dbRequest);
            }
        } catch (Exception e) {
            //에러페이지
            setViewName = "redirect:Main/MainIndex";
        }

        //최종 값 입력
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName(setViewName);
        return modelAndView;
    }
}
