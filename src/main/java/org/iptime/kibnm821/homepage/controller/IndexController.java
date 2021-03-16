package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.bean.ACCOUNT_VO;
import org.iptime.kibnm821.homepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    MemberService memberService;

    //매핑 변수
    private final static String MAPPING = "Main/";

    //template 경로 변경 변수
    private String setViewName;

    //각 필요 전역 변수
    private String ID;
    private String PASSWORD;
    private Map<String, Object> resultMap = new HashMap<>();

    //VO
    private ACCOUNT_VO account_VO = new ACCOUNT_VO();

    @RequestMapping(value = "/")
    public ModelAndView Index(ModelAndView modelAndView, HttpSession session) {
        //로그아웃 동작
        session.setAttribute("ID", null);
        setViewName = "index";

        modelAndView.setViewName(setViewName);
        return modelAndView;
    }

    @RequestMapping(value = "login", method = {RequestMethod.POST})
    public ModelAndView Login(ModelAndView modelAndView, HttpServletRequest request, HttpSession session) {
//        로그인실패시 출력 값 변수
        String fail = "계정이 없거나 로그인 되지 않았습니다.";
        //로그인 시도시 값 받기
        ID = request.getParameter("ID");
        PASSWORD = request.getParameter("PASSWORD");

        account_VO.setID(ID);
        account_VO.setPASSWORD(PASSWORD);

        resultMap = (Map<String, Object>) memberService.Account_Check(account_VO);

        try {
            //        로그인 체크
            if (resultMap.get("ID") == null) {//map에서 null일 경우 오류발생 그렇기 때문에 if문으로 먼저 거름(추후 html에서 null값 받지 않게 만들예정)
                modelAndView.addObject("result", fail);
                setViewName = "index";
            } else {
                if (resultMap.get("ID").equals(ID)) {
                    modelAndView.addObject("resultMap", resultMap);
                    session.setAttribute("ID", resultMap.get("ID"));
                    session.setAttribute("NAME", resultMap.get("NAME"));
                    setViewName = "redirect:" + MAPPING + "MainIndex";
                } else {
                    modelAndView.addObject("result", fail);
                    setViewName = "index";
                }
            }
        } catch (Exception e) {
            modelAndView.addObject("result", fail);
            setViewName = "index";
        } finally {
            modelAndView.setViewName(setViewName);
        }
        ID = PASSWORD = null;
        resultMap = null;
        return modelAndView;
    }

    //error page
    @RequestMapping(value = "error_page")
    public String error_page(HttpSession session) {
        session.removeAttribute("ID");
        session.removeAttribute("NAME");

        return "error_page";
    }
}
