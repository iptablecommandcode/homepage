package org.iptime.kibnm821.homepage.controller;

import org.iptime.kibnm821.homepage.bean.ACCOUNT_VO;
import org.iptime.kibnm821.homepage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    //매핑 변수
    private final static String MAPPING = "Main/";

    //template 경로 변경 변수
    private String setViewName;

    //각 필요 전역 변수
    private String ID;
    private String PASSWORD;
    private Map<String, Object> resultMap = new HashMap<>();

    LocalDate time = LocalDate.now();

    @ResponseBody
    @RequestMapping(value = "/")
    public ModelAndView Index(ModelAndView modelAndView, HttpSession session) {
        //로그아웃 동작
        session.setAttribute("ID", null);
        setViewName = "index";

        modelAndView.setViewName(setViewName);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "login", method = {RequestMethod.POST})
    public ModelAndView Login(ModelAndView modelAndView, HttpSession session, ACCOUNT_VO account_VO) {

//        로그인실패시 출력 값 변수
        String fail = "계정이 없거나 로그인 되지 않았습니다.";

        resultMap = (Map<String, Object>) memberService.Account_Check(account_VO);
        try {
            //        로그인 체크
            if (resultMap.get("ID") == null) {//map에서 null일 경우 오류발생 그렇기 때문에 if문으로 먼저 거름(추후 html에서 null값 받지 않게 만들예정)
                modelAndView.addObject("result", fail);
                setViewName = "index";
            } else {
                if (passwordEncoder.matches(account_VO.getPASSWORD(), (String) resultMap.get("PASSWORD"))) {
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
    @ResponseBody
    @RequestMapping(value = "error_page")
    public String error_page(HttpSession session) {
        session.removeAttribute("ID");
        session.removeAttribute("NAME");

        return "error_page";
    }

    @ResponseBody
    @RequestMapping(value = "Sign_Up")
    public ModelAndView Sign_Up(ModelAndView modelAndView) {
        setViewName = "Sign_Up";

        modelAndView.setViewName(setViewName);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "idCheck", method = {RequestMethod.GET})
    public int idCheck(@RequestParam(value = "ID") String ID) {
        int resultint = memberService.Id_Check(ID);
        return resultint;
    }

    @ResponseBody
    @RequestMapping(value = "create_account")
    public ModelAndView inputaccount(ModelAndView modelAndView, ACCOUNT_VO account_vo) {
        try {
            //비밀번호 암호화
            account_vo.setPASSWORD(passwordEncoder.encode(account_vo.getPASSWORD()));
            account_vo.setTIME(time);

            //저장처리후 결과값
            int inputcheck = memberService.Create_Member(account_vo);

//            성공시 index 실패시 다시 돌아가기
            if (inputcheck == 1) {
                setViewName = "index";
            } else {
                setViewName = "Sign_Up";
            }
        } catch (Exception e) {
            setViewName = "error_page";
        }finally {
            modelAndView.setViewName(setViewName);
        }
        return modelAndView;
    }
}