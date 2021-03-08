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

    //공통 사용 변수 전역 선언
    private String setViewName = MAPPING;
    private Object resultMap = new HashMap<String, Object>();
    private Map<String, Object> dataMap = new HashMap<String, Object>();

    //현재 날짜
    private LocalDate TIME = LocalDate.now();

    //        웹 데이터 가져올 변수
    private String ID;
    private String BIGHEADTITLE;
    private String HEADTITLE;
    private String TITLE;
    private String CONTENTS;
    private String NAME;
    private String NUMBER;

    @RequestMapping(value = MAPPING + "Content_new", method = {RequestMethod.GET})
    public ModelAndView Content(ModelAndView modelAndView, HttpServletRequest request) {
        //각 페이지 이동 변수 초기화
        setViewName = MAPPING;

        BIGHEADTITLE = request.getParameter("BIGHEADTITLE");

        dataMap.put("BIGHEADTITLE", BIGHEADTITLE);

        try {
            resultMap = contentService.Notice_Board(dataMap);
            setViewName += "Content_new";
        } catch (Exception e) {
            
        } finally {
            //Front_End 출력
            modelAndView.addObject("resultMap", resultMap);
            modelAndView.setViewName(setViewName);
        }
//        재사용을 위한 초기화
        resultMap = new HashMap<String, Object>();
        dataMap = new HashMap<>();
        
        return modelAndView;
    }

    @RequestMapping(value = MAPPING + "Patch", method = {RequestMethod.POST})
    public ModelAndView Board_Create(ModelAndView modelAndView, HttpServletRequest request) {
        //기본 사용 변수
        setViewName = MAPPING;

        //웹 정보 받기
        ID = request.getParameter("ID");
        BIGHEADTITLE = request.getParameter("BIGHEADTITLE");
        NAME = request.getParameter("NAME");
        TITLE = request.getParameter("TITLE");
        HEADTITLE = request.getParameter("HEADTITLE");
        CONTENTS = request.getParameter("CONTENTS");
        NUMBER = request.getParameter("NUMBER");

        dataMap.put("ID", ID);
        dataMap.put("BIGHEADTITLE", BIGHEADTITLE);
        dataMap.put("NAME", NAME);
        dataMap.put("TITLE", TITLE);
        dataMap.put("HEADTITLE", HEADTITLE);
        dataMap.put("CONTENTS", CONTENTS);
        dataMap.put("NUMBER", NUMBER);
        dataMap.put("TIME", TIME);

        //DB처리
        try {
            contentService.update_Board(dataMap);

            resultMap = contentService.Notice_Board(dataMap);

            //새 글 생성후 돌아갈 페이지 결정
            if (BIGHEADTITLE.equals("WEB")) {
                setViewName = "Main/Study/WEB";
            } else if (BIGHEADTITLE.equals("SECURITY")) {
                setViewName = "Main/Study/SECURITY";
            }
        } catch (Exception e) {
//            오류시 처음으로 돌아간다
            setViewName = "redirect: error_page";
        } finally {
            modelAndView.addObject("resultMap", resultMap);
            modelAndView.setViewName(setViewName);
        }

//        재사용을 위한 초기화
        resultMap = new HashMap<String, Object>();
        dataMap = new HashMap<>();
        
        return modelAndView;
    }

    //    게시판 보기
    @RequestMapping(value = MAPPING + "Content_show", method = {RequestMethod.POST})
    public ModelAndView Content_show(ModelAndView modelAndView, HttpServletRequest request) {
        //각 페이지 이동 변수 초기화
        setViewName = MAPPING;

        //계정정보, 글제목, 구분 머릿말
        NUMBER = request.getParameter("table");

        dataMap.put("NUMBER", NUMBER);

        try {
            //db호출
            resultMap = contentService.Board(dataMap);
            setViewName += "Content_show";
        } catch (Exception e) {
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

    @RequestMapping(value = MAPPING + "Content_patch", method = {RequestMethod.POST})
    public ModelAndView Content_patch(ModelAndView modelAndView, HttpServletRequest request) {
        //각 페이지 이동 변수 초기화
        setViewName = MAPPING;

        //계정정보, 글제목, 구분 머릿말
        NUMBER = request.getParameter("NUMBER");

        dataMap.put("NUMBER", NUMBER);

        try {
            //db호출
            resultMap = contentService.Board(dataMap);
            setViewName += "Content_patch";

        } catch (Exception e) {
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

    @RequestMapping(value = MAPPING + "Save", method = {RequestMethod.POST})
    public ModelAndView Save(ModelAndView modelAndView, HttpServletRequest request) {
        //각 페이지 이동 변수 초기화
        setViewName = MAPPING;

//        웹 데이터 가져오기
        ID = request.getParameter("ID");
        BIGHEADTITLE = request.getParameter("BIGHEADTITLE");
        HEADTITLE = request.getParameter("HEADTITLE");
        TITLE = request.getParameter("TITLE");
        CONTENTS = request.getParameter("CONTENTS");
        NAME = request.getParameter("NAME");

        dataMap.put("ID", ID);
        dataMap.put("BIGHEADTITLE", BIGHEADTITLE);
        dataMap.put("HEADTITLE", HEADTITLE);
        dataMap.put("TITLE", TITLE);
        dataMap.put("CONTENTS", CONTENTS);
        dataMap.put("NAME", NAME);
        dataMap.put("TIME", TIME);

        //글 저장문실행 오류시 오류 페이지로 넘어감
        try {
            contentService.insert_Board(dataMap);

//            처리 후 게시판 자료 가져오기
            resultMap = contentService.Notice_Board(dataMap);

        } catch (Exception e) {
            setViewName = "error_page";
        } finally {
            if (BIGHEADTITLE.equals("WEB")) {
                setViewName = "Main/Study/WEB";
            } else if (BIGHEADTITLE.equals("SECURITY")) {
                setViewName = "Main/Study/SECURITY";
            }

            //최종 값 저장
            modelAndView.addObject("resultMap",resultMap);
            modelAndView.setViewName(setViewName);
        }

        //        재사용을 위한 초기화
        resultMap = new HashMap<String, Object>();
        dataMap = new HashMap<>();

        return modelAndView;
    }
}
