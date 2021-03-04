package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StudyController {

    @Autowired
    ContentService contentService;

    private final static String MAPPING = "Main/Study/";

    //상단 메뉴 Web
    @RequestMapping(value = MAPPING + "{action}", method = {RequestMethod.GET})
    public ModelAndView Check_Content_Board(@PathVariable String action, ModelAndView modelAndView) {
        String viewName = MAPPING + action;
        Object resultMap = new HashMap<String, Object>();
        Map<String, Object> dbRequest = new HashMap<String, Object>();

        //구분 플레그
        dbRequest.put("BIGHEADTITLE", action);

        //웹 별로 구분
        if (action.equals("WEB")) {
            resultMap = contentService.Notice_Board(dbRequest);
        } else if (action.equals("SECURITY")) {
            resultMap = contentService.Notice_Board(dbRequest);
        } else
            viewName = "redirect:Main/MainIndex";

        //최종 값 입력
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

//    @RequestMapping(value = MAPPING + "WEB", method = {RequestMethod.GET})
//    public ModelAndView Web(ModelAndView modelAndView) {
//        String viewName = MAPPING + "WEB";
//
//        modelAndView.setViewName(viewName);
//        return modelAndView;
//    }
}
