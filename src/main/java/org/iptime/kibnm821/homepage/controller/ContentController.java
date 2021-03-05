package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ContentController {

    @Autowired
    ContentService contentService;

    private final static String MAPPING = "Main/Study/Content/";

    //글 생성
    @RequestMapping(value = MAPPING + "Content_new", method = {RequestMethod.GET})
    public ModelAndView Content(ModelAndView modelAndView, HttpServletRequest request) {
        String setViewName = MAPPING + "Content_new";
        Object resultMap = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<>();

        String BIGHEADTITLE = request.getParameter("BIGHEADTITLE");

        dataMap.put("BIGHEADTITLE", BIGHEADTITLE);

        resultMap = contentService.Notice_Board(dataMap);

        //최종 정리
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName(setViewName);
        return modelAndView;
    }

    @RequestMapping(value = MAPPING + "Patch", method = {RequestMethod.POST})
    public ModelAndView Board_Create(ModelAndView modelAndView, HttpServletRequest request) {
        //기본 사용 변수
        String setViewName = MAPPING;
        Object resultMap = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<>();
        //현재 날짜
        LocalDate TIME = LocalDate.now();
        
        String ID = request.getParameter("ID");
        String BIGHEADTITLE = request.getParameter("BIGHEADTITLE");
        String NAME = request.getParameter("NAME");
        String TITLE = request.getParameter("TITLE");
        String HEADTITLE = request.getParameter("HEADTITLE");
        String CONTENTS = request.getParameter("CONTENTS");
        String NUMBER = request.getParameter("NUMBER");

        dataMap.put("ID", ID);
        dataMap.put("BIGHEADTITLE", BIGHEADTITLE);
        dataMap.put("NAME", NAME);
        dataMap.put("TITLE", TITLE);
        dataMap.put("HEADTITLE", HEADTITLE);
        dataMap.put("CONTENT", CONTENTS);
        dataMap.put("NUMBER", NUMBER);
        dataMap.put("TIME", TIME);
        
        //DB처리
        try {
            contentService.update_Board(dataMap);

            resultMap = contentService.Notice_Board(dataMap);

            setViewName = "Main/MainIndex";
        } catch (Exception e) {
//            오류시 처음으로 돌아간다
            setViewName = "redirect: Main/MainIndex";
        } finally {
            if (BIGHEADTITLE.equals("WEB")) {
                setViewName = "Main/Study/WEB";
            } else if (BIGHEADTITLE.equals("SECURITY")) {
                setViewName = "Main/Study/SECURITY";
            }
        }
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName(setViewName);
        return modelAndView;
    }

    //    게시판 보기
    @RequestMapping(value = MAPPING + "Content_show", method = {RequestMethod.POST})
    public ModelAndView Content_show(ModelAndView modelAndView, HttpServletRequest request) {
        String setViewName = MAPPING;
        Object resultMap = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<>();

        //계정정보, 글제목, 구분 머릿말
        String NUMBER = request.getParameter("NUMBER");
        String BIGHEADTITLE = request.getParameter("BIGHEADTITLE");
        String ID = request.getParameter("ID");

        dataMap.put("ID", ID);
        dataMap.put("NUMBER", NUMBER);
        dataMap.put("BIGHEADTITLE", BIGHEADTITLE);


        try {
            //db호출
            resultMap = contentService.Board(dataMap);
            setViewName += "Content_show";
        } catch (Exception e) {
            setViewName = "Main/MainIndex";
        }


        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName(setViewName);
        return modelAndView;
    }

    @RequestMapping(value = MAPPING + "Content_patch", method = {RequestMethod.POST})
    public ModelAndView Content_patch(ModelAndView modelAndView, HttpServletRequest request) {
        String setViewName = MAPPING;
        Object resultMap = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<>();

        //계정정보, 글제목, 구분 머릿말
        String NUMBER = request.getParameter("NUMBER");
        String BIGHEADTITLE = request.getParameter("BIGHEADTITLE");
        String ID = request.getParameter("ID");

        dataMap.put("ID", ID);
        dataMap.put("NUMBER", NUMBER);
        dataMap.put("BIGHEADTITLE", BIGHEADTITLE);

        //db호출
        resultMap = contentService.Board(dataMap);
        setViewName += "Content_patch";

        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName(setViewName);
        return modelAndView;
    }
}
