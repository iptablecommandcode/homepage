package org.iptime.kibnm821.homepage.controller;

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
public class MainController {

    @Autowired
    ContentService contentService;

    private final static String MAPPING = "Main/";


    @RequestMapping(value = MAPPING + "MainIndex",method = {RequestMethod.GET})
    public ModelAndView home(ModelAndView modelAndView, HttpServletRequest request){
        //변수 선언
        String setViewName = MAPPING + "MainIndex";
        Object resultMap = new HashMap<String,Object>();
        Map<String, Object> BigHeadTitle = new HashMap<String,Object>();

        //web 최상단 3개의 값
        BigHeadTitle.put("BIGHEADTITLE", "WEB");
        resultMap = contentService.TopContent(BigHeadTitle);
        modelAndView.addObject("resultWeb",resultMap);
        BigHeadTitle = new HashMap<String,Object>();


        //security 최상단 3개의 값
        BigHeadTitle.put("BIGHEADTITLE", "SECURITY");
        resultMap = contentService.TopContent(BigHeadTitle);
        modelAndView.addObject("resultSecurity", resultMap);
        BigHeadTitle = new HashMap<String,Object>();


        //최종 리턴
        modelAndView.setViewName(setViewName);
        return modelAndView;
    }
}