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

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.HashMap;

@Controller
public class ContentController {

    @Autowired
    ContentService contentService;

    //View 변수
    private static final String MAPPING = "Main/Study/Content/";
    private String setViewName;

    //modelandviwe 반환 Object
    private Object resultMap = new HashMap<>();

    //시간
    LocalDate localDate = LocalDate.now();

    @RequestMapping(value = MAPPING + "Content_show", method = {RequestMethod.POST})
    public ModelAndView Content_show(ModelAndView modelAndView, @RequestParam int content) {

        try {
            //게시판 객체 정보 가져오기
            CONTENT_VO content_vo = new CONTENT_VO();

            content_vo.setNUMBER(content);

            resultMap = contentService.Content_show(content_vo);

            setViewName = MAPPING + "Content_show";
        } catch (Exception e) {
            setViewName = "redirect:/error_page";
        } finally {
            modelAndView.addObject("resultMap", resultMap);
            modelAndView.setViewName(setViewName);
        }
        return modelAndView;
    }

    @RequestMapping(value = MAPPING + "Content_patch", method = {RequestMethod.POST})
    public ModelAndView Content_patch(ModelAndView modelAndView, @RequestParam int content) {

        try {
            //게시판 객체 정보 가져오기
            CONTENT_VO content_vo = new CONTENT_VO();

            content_vo.setNUMBER(content);

            resultMap = contentService.Content_show(content_vo);

            setViewName = MAPPING + "Content_patch";
        } catch (Exception e) {
            setViewName = "redirect:/error_page";
        } finally {
            modelAndView.addObject("resultMap", resultMap);
            modelAndView.setViewName(setViewName);
        }

        return modelAndView;
    }

    @RequestMapping(value = MAPPING + "Content_new", method = {RequestMethod.GET})
    public ModelAndView Content_new(ModelAndView modelAndView, @RequestParam String BIGHEADTITLE) {

        resultMap = BIGHEADTITLE;
        setViewName = MAPPING + "Content_new";

        modelAndView.addObject("BIGHEADTITLE", BIGHEADTITLE);
        modelAndView.setViewName(setViewName);
        return modelAndView;
    }

    @RequestMapping(value = MAPPING + "Save", method = {RequestMethod.POST})
    public ModelAndView Save(ModelAndView modelAndView, CONTENT_VO content_vo,
                             @RequestParam(defaultValue = "1") int nowPage, HttpSession session) {

        //시간 설정
        LocalDate TIME = localDate;
        content_vo.setTIME(TIME);

        content_vo.setNAME((String) session.getAttribute("ID"));

//        업데이트시 사용하는 번호 입력 새로저장할때는 사용 x


        //구분된 웹 총 글자수
        int Count = (int)contentService.count_Content(content_vo);

        try {
            if (content_vo.getNUMBER() == 0) {
                //새로운 글 입력
                contentService.Insert_Content(content_vo);

                //페이징(총 페이지 개수, 현재 페이지, 페이지당 보일 글 개수, 웹 구분
                PagingVO pagingVO = new PagingVO(Count, nowPage, 10, content_vo.getBIGHEADTITLE());

                resultMap = contentService.select_Content(pagingVO);
                setViewName = MAPPING + "StudyPage";

                modelAndView.addObject("resultMap", resultMap);
                //페이징 번호, 다음 이전 페이지 마지막 페이지 번호
                modelAndView.addObject("start", pagingVO.getStartPage());
                modelAndView.addObject("end", pagingVO.getEndPage());
                modelAndView.addObject("AFTER", pagingVO.getEndPage() + 1);
                modelAndView.addObject("BEFORE", pagingVO.getStartPage() - 1);
                modelAndView.addObject("FINAL", pagingVO.getLastPage());
                //웹 제목
                modelAndView.addObject("TITLE", content_vo.getBIGHEADTITLE());
                setViewName = "Main/Study/StudyPage";
            } else if (content_vo.getNUMBER() != 0) {
                //글 수정
                contentService.Content_update(content_vo);

                //페이징(총 페이지 개수, 현재 페이지, 페이지당 보일 글 개수, 웹 구분
                PagingVO pagingVO = new PagingVO(Count, nowPage, 10, content_vo.getBIGHEADTITLE());
                resultMap = contentService.select_Content(pagingVO);
                setViewName = MAPPING + "StudyPage";

                modelAndView.addObject("resultMap", resultMap);
                //페이징 번호, 다음 이전 페이지 마지막 페이지 번호
                modelAndView.addObject("start", pagingVO.getStartPage());
                modelAndView.addObject("end", pagingVO.getEndPage());
                modelAndView.addObject("AFTER", pagingVO.getEndPage() + 1);
                modelAndView.addObject("BEFORE", pagingVO.getStartPage() - 1);
                modelAndView.addObject("FINAL", pagingVO.getLastPage());
                //웹 제목
                modelAndView.addObject("TITLE", content_vo.getBIGHEADTITLE());
                setViewName = "Main/Study/StudyPage";
            }
        } catch (Exception e) {
            setViewName = "redirect: error_page";
        }finally {
            modelAndView.setViewName(setViewName);
        }
        return modelAndView;
    }
}
