package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    MemberService memberService;

    private final static String MAPPING = "Main";


    @RequestMapping(value = MAPPING + "/MainIndex",method = {RequestMethod.GET})
    public ModelAndView home(ModelAndView modelAndView, HttpServletRequest request){
        //변수 선언
        String setViewName = MAPPING + "/MainIndex";

        modelAndView.setViewName(setViewName);
        return modelAndView;
    }
}