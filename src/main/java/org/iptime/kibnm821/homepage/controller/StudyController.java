package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.bean.Paging;
import org.iptime.kibnm821.homepage.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    //매핑 변수
    private String setViewName;
    private final static String MAPPING = "Main/Study/";

    //사용할 전역 변수
    private String TITLE;
    private String SEARCH;
    private String BIGHEADTITLE;

    private Object resultMap = new HashMap<String, Object>();
    private Map<String, Object> dataMap = new HashMap<String, Object>();

    //Search
    @RequestMapping(value = MAPPING + "Search", method = {RequestMethod.GET})
    public ModelAndView Search(ModelAndView modelAndView, HttpServletRequest request) {

        //웹 입력갑 저장 검색시
        TITLE = request.getParameter("TITLE");
        SEARCH = request.getParameter("SEARCH");
        BIGHEADTITLE = request.getParameter("BIGHEADTITLE");

        dataMap.put("TITLE", TITLE);
        dataMap.put("SEARCH", SEARCH);
        dataMap.put("BIGHEADTITLE", BIGHEADTITLE);

        try {
            if (TITLE.equals("선택")) {
                setViewName = "error_page";
            } else if (SEARCH.equals(null)) {
                setViewName = "error_page";
            } else if (((Map<String, Object>) resultMap).get("resultList").equals(null)) {
                setViewName = "error_page";
            } else {
                resultMap = contentService.Search_Board(dataMap);
                setViewName = MAPPING + request.getParameter("BIGHEADTITLE");
            }
        } catch (Exception E) {
            setViewName = "error_page";
        } finally {
            modelAndView.addObject("resultMap", resultMap);
            modelAndView.setViewName(setViewName);
        }

        //        재사용을 위한 초기화
        resultMap = new HashMap<String, Object>();
        dataMap = new HashMap<>();

        return modelAndView;
    }

    //상단 메뉴 Web
    @RequestMapping(value = MAPPING + "WEB", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Web_Content_Board(ModelAndView modelAndView, HttpServletRequest request) {
        setViewName = MAPPING + "WEB";

        //웹 별로 구분
        try {
            //구분 레코드 가져오기
            dataMap.put("BIGHEADTITLE", "WEB");
            //페이징 정보 가져오기
            Paging paging = new Paging("WEB");

            resultMap = contentService.test(paging);

//            resultMap = contentService.Notice_Board(dataMap);
        } catch (Exception e) {
            //에러페이지
            setViewName = "redirect:error_page";
        } finally {
            //최종 값 입력
            modelAndView.addObject("resultMap", resultMap);
            modelAndView.setViewName(setViewName);
        }

        //        재사용을 위한 초기화
        resultMap = new HashMap<String, Object>();
        dataMap = new HashMap<>();

        return modelAndView;
    }

    //상단 메뉴 Web
    @RequestMapping(value = MAPPING + "SECURITY", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Security_Content_Board(ModelAndView modelAndView, HttpServletRequest request) {
        setViewName = MAPPING + "SECURITY";

        //웹 별로 구분
        try {
            //기본 WEB이나 Security페이지
            dataMap.put("BIGHEADTITLE", "SECURITY");
            resultMap = contentService.Notice_Board(dataMap);
        } catch (Exception e) {
            //에러페이지
            setViewName = "redirect:error_page";
        } finally {
            //최종 값 입력
            modelAndView.addObject("resultMap", resultMap);
            modelAndView.setViewName(setViewName);
        }

        //        재사용을 위한 초기화
        resultMap = new HashMap<String, Object>();
        dataMap = new HashMap<>();

        return modelAndView;
    }
}
