package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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

    private final static String MAPPING = "Main";

    @RequestMapping(value = "/")
    public ModelAndView Index(HttpSession session, ModelAndView modelAndView) {
        //메인 페이지 접근시 계정 정보 전부 free 시키기
        session.setAttribute("account", null);

        modelAndView.addObject("result", null);
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @PostMapping("login.do")
    public ModelAndView SignIn(HttpServletRequest request, HttpSession session, ModelAndView modelAndView){
        //변수 선언
        String setViewName = "";
        String status = "계정이 없거나 로그인 되지 않았습니다.";
        String DB = null;
        Map<String, Object> account = new HashMap<String, Object>();

        //웹에서 계정 정보 가져오기
        String ID = (String) request.getParameter("ID");
        String PASSWORD = (String) request.getParameter("PASSWORD");

        //DB에 넘길 변수
        account.put("ID", ID);
        account.put("PASSWORD", PASSWORD);

        account = (Map<String, Object>) memberService.LoginCheck(account);

        if(account == null) {//map에서 null일 경우 오류발생 그렇기 때문에 if문으로 먼저 거름(추후 html에서 null값 받지 않게 만들예정)
            modelAndView.addObject("result", status);
            setViewName = "index";
        }else {
            if (account.get("ID").equals(ID)) {//로그인시 홈 화면 전환
                setViewName = "redirect:" + MAPPING + "/MainIndex";
                session.setAttribute("account", ID);
            } else {//로그인 실패시
                modelAndView.addObject("result", status);
                setViewName = "index";
            }
        }

//        로그인실패시 다시 로그인할 경우 비교 변수 초기화
        ID = null;
        account = null;

        modelAndView.setViewName(setViewName);
        return modelAndView;
    }

}
