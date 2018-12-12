package com.lzb.controller;

import com.lzb.Repository.ExamineesRepository;
import com.lzb.model.examinees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/12/10.
 */
@Controller
public class mvController {
    @Autowired
    private ExamineesRepository examineesRepository;

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mv){
        mv.setViewName("/login");
        return mv;
    }
    @RequestMapping("/index")
    public ModelAndView jsp(ModelAndView mv){
        mv.setViewName("/index");
        mv.addObject("message", "this is hello page!");
        return mv;
    }
    @RequestMapping("/welcome")
    public ModelAndView test(ModelAndView mv){
        mv.setViewName("/welcome");
        return mv;
    }

    @RequestMapping("/loginByEmail")
    public ModelAndView loginByEmail(ModelAndView mv){
        mv.setViewName("/loginByEmail");
        return mv;
    }

    @RequestMapping("/loginByPhone")
    public ModelAndView loginByPhone(ModelAndView mv){
        mv.setViewName("/loginByPhone");
        return mv;
    }

    @RequestMapping("/register")
    public ModelAndView register(ModelAndView mv){
        mv.setViewName("/register");
        return mv;
    }

    @RequestMapping("/memberList")
    public ModelAndView memberList(ModelAndView mv,ModelMap map){
        mv.setViewName("/member_list");
        List<examinees> memberList = examineesRepository.findAll();
        map.addAttribute("memberList",memberList);
        return mv;
    }

    @RequestMapping("/tmemberList")
    public ModelAndView tmemberList(ModelAndView mv){
        mv.setViewName("/tmember_list");
        return mv;
    }

    @RequestMapping("/orderList")
    public ModelAndView orderList(ModelAndView mv,ModelMap map){
        mv.setViewName("/order_list");
        return mv;
    }
}
