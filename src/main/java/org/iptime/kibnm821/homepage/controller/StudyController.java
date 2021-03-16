package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.bean.CONTENT_VO;
import org.iptime.kibnm821.homepage.bean.PagingVO;
import org.iptime.kibnm821.homepage.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class StudyController {

    @Autowired
    ContentService contentService;

    //매퍼
    private final static String MAPPING = "Main/Study/";
    private String setViewName;

    //변수
    private Object resultMap = new HashMap<>();
    private int Count;

    //웹 페이지 메소드
    @RequestMapping(value = MAPPING + "WEB", method = {RequestMethod.GET})
    public ModelAndView WEB(ModelAndView modelAndView, @RequestParam(defaultValue = "1") int nowPage) {

        //VO
        CONTENT_VO content_vo = new CONTENT_VO();

        //WEB구분
        content_vo.setBIGHEADTITLE("WEB");
        //구분된 웹 총 글자수
        Count = (int) contentService.count_Content(content_vo);

        //페이징(총 페이지 개수, 현재 페이지, 페이지당 보일 글 개수, 웹 구분
        PagingVO pagingVO = new PagingVO(Count, nowPage, 10, content_vo.getBIGHEADTITLE());

        try {
            resultMap = contentService.select_Content(pagingVO);
            setViewName = MAPPING + "StudyPage";
        } catch (Exception e) {
            setViewName = "redirect: error_page";
        } finally {
            modelAndView.addObject("resultMap", resultMap);
            //페이징 번호, 다음 이전 페이지 마지막 페이지 번호
            modelAndView.addObject("start", pagingVO.getStartPage());
            modelAndView.addObject("end", pagingVO.getEndPage());
            modelAndView.addObject("AFTER", pagingVO.getEndPage() + 1);
            modelAndView.addObject("BEFORE", pagingVO.getStartPage() - 1);
            modelAndView.addObject("FINAL", pagingVO.getLastPage());
            //웹 제목
            modelAndView.addObject("TITLE", "WEB");
            modelAndView.setViewName(setViewName);
        }
        return modelAndView;
    }

    //웹 페이지 메소드
    @RequestMapping(value = MAPPING + "SECURITY", method = {RequestMethod.GET})
    public ModelAndView SECURITY(ModelAndView modelAndView, @RequestParam(defaultValue = "1") int nowPage) {
        //VO
        CONTENT_VO content_vo = new CONTENT_VO();

        //WEB구분
        content_vo.setBIGHEADTITLE("SECURITY");
        //구분된 웹 총 글자수
        Count = (int)contentService.count_Content(content_vo);

        //페이징(총 페이지 개수, 현재 페이지, 페이지당 보일 글 개수, 웹 구분
        PagingVO pagingVO = new PagingVO(Count, nowPage, 10, content_vo.getBIGHEADTITLE());

        try {
            resultMap = contentService.select_Content(pagingVO);
            setViewName = MAPPING + "StudyPage";
        } catch (Exception e) {
            setViewName = "redirect: error_page";
        } finally {
            modelAndView.addObject("resultMap", resultMap);
            //페이징 번호, 다음 이전 페이지 마지막 페이지 번호
            modelAndView.addObject("start", pagingVO.getStartPage());
            modelAndView.addObject("end", pagingVO.getEndPage());
            modelAndView.addObject("AFTER", pagingVO.getEndPage() + 1);
            modelAndView.addObject("BEFORE", pagingVO.getStartPage() - 1);
            modelAndView.addObject("FINAL", pagingVO.getLastPage());
            //웹 제목
            modelAndView.addObject("TITLE", "SECURITY");
            modelAndView.setViewName(setViewName);
        }

        return modelAndView;
    }

//    //검색 페이지 메소드
//    @RequestMapping(value = MAPPING + "SEARCH", method = {RequestMethod.GET})
//    public ModelAndView Search(ModelAndView modelAndView, @RequestParam(defaultValue = "1") int nowPage,
//                               @RequestParam String SEARCHTITLE, @RequestParam String SEARCH,
//                               HttpServletRequest request) {
//
//        //VO
//        CONTENT_VO content_vo = new CONTENT_VO();
//
//        //WEB구분
//        content_vo.setBIGHEADTITLE(request.getParameter("BIGHEADTITLE"));
//        //구분된 웹 총 글자수
//        Count = contentService.count_Content(content_vo);
//
//        //페이징(총 페이지 개수, 현재 페이지, 페이지당 보일 글 개수, 웹 구분
//        PagingVO pagingVO = new PagingVO(Count, nowPage, 10, content_vo.getBIGHEADTITLE());
//
//        //웹 검색값 가져오기
//        pagingVO.setSEARCHTITLE(SEARCHTITLE);
//        pagingVO.setSEARCH(SEARCH);
//
//        try {
//            resultMap = contentService.search_Content(pagingVO);
//            setViewName = MAPPING + "StudyPage";
//        } catch (Exception e) {
//            setViewName = "redirect: error_page";
//        } finally {
//            modelAndView.addObject("resultMap", resultMap);
//            //페이징 번호, 다음 이전 페이지 마지막 페이지 번호
//            modelAndView.addObject("start", pagingVO.getStartPage());
//            modelAndView.addObject("end", pagingVO.getEndPage());
//            modelAndView.addObject("AFTER", pagingVO.getEndPage() + 1);
//            modelAndView.addObject("BEFORE", pagingVO.getStartPage() - 1);
//            modelAndView.addObject("FINAL", pagingVO.getLastPage());
//            //웹 제목
//            modelAndView.addObject("TITLE", pagingVO.getBIGHEADTITLE());
//            modelAndView.setViewName(setViewName);
//        }
//
//        return modelAndView;
//    }
}
