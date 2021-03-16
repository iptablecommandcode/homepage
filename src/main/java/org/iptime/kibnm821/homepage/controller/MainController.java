package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.bean.CONTENT_VO;
import org.iptime.kibnm821.homepage.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class MainController {

    @Autowired
    ContentService contentService;

    //매핑 변수
    private final static String MAPPING = "Main/";

    //template 경로 변경 변수
    private String setViewName;

    //각 필요 전역 변수
    private Object resultWeb;
    private Object resultSecurity = new HashMap<>();

    //VO
    CONTENT_VO content_vo_web = new CONTENT_VO();
    CONTENT_VO content_vo_security = new CONTENT_VO();

    @RequestMapping(value = MAPPING + "MainIndex", method = {RequestMethod.GET})
    public ModelAndView MainIndex(ModelAndView modelAndView) {
        setViewName = MAPPING + "MainIndex";

        try {
            //값 입력
            content_vo_web.setBIGHEADTITLE("WEB");
            content_vo_security.setBIGHEADTITLE("SECURITY");

            //DB요청
            resultWeb = contentService.select_Top3(content_vo_web);
            resultSecurity = contentService.select_Top3(content_vo_security);
        } catch (Exception e) {
            setViewName = "redirect:/error_page";
        } finally {
            //웹 최종값 출력
            modelAndView.addObject("resultWeb", resultWeb);
            modelAndView.addObject("resultSecurity", resultSecurity);
            modelAndView.setViewName(setViewName);
        }

        return modelAndView;
    }
}
