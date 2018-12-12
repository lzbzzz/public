package com.lzb.controller;

import com.lzb.Repository.UserInfoRepository;
import com.lzb.model.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class loginController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public  Map<String,Object> loginCheck(@RequestBody userInfo userinfo,HttpServletRequest request){
        userInfo user=userInfoRepository.findByUserName(userinfo.getUserName());
        Map<String,Object> map=new HashMap<>();
        map.put("userinfo",userinfo);
        if(user.getPassword().equals(userinfo.getPassword()) && !StringUtils.isEmpty(userinfo.getPassword())){
            map.put("msg","登录成功");
            map.put("code",200);
        }else{
            map.put("msg","登录失败");
            map.put("code",400);
        }
        request.getSession().setAttribute("username",user.getUserName());
        return map;
    }

    @RequestMapping(value = "/loginCheckByEmail",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public  Map<String,Object>  loginCheckByEmail(@RequestBody userInfo userinfo,HttpServletRequest request){
        userInfo user=userInfoRepository.findByEmail(userinfo.getEmail());
        Map<String,Object> map=new HashMap<>();
        map.put("userinfo",user);
        if(user.getPassword().equals(userinfo.getPassword()) && !StringUtils.isEmpty(userinfo.getPassword())){
            map.put("msg","登录成功");
            map.put("code",200);
        }else{
            map.put("msg","登录失败");
            map.put("code",400);
        }
        request.getSession().setAttribute("username",user.getUserName());//设置全局变量
        return map;
    }

    @RequestMapping(value = "/loginCheckByPhone",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public  Map<String,Object>  loginCheckByPhone(@RequestBody userInfo userinfo,HttpServletRequest request){
        userInfo user=userInfoRepository.findByPhone(userinfo.getPhone());
        Map<String,Object> map=new HashMap<>();
        map.put("userinfo",user);
        if(user.getPassword().equals(userinfo.getPassword()) && !StringUtils.isEmpty(userinfo.getPassword())){
            map.put("msg","登录成功");
            map.put("code",200);
        }else{
            map.put("msg","登录失败");
            map.put("code",400);
        }
        request.getSession().setAttribute("username",user.getUserName());
        return map;
    }



    @RequestMapping(value = "/registeradd",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public  Map<String,Object> addUser(@RequestBody userInfo userinfo) throws Exception{
        Map<String,Object> map=new HashMap<>();
        String msg="";
        int code=200;
        if(!StringUtils.isEmpty(userInfoRepository.findByEmail(userinfo.getUserName()))){
            msg="用户名已经存在";
            code=400;
        }else if(!StringUtils.isEmpty(userInfoRepository.findByEmail(userinfo.getEmail()))){
            msg="邮箱已存在";
            code=400;
        }else if(!StringUtils.isEmpty(userInfoRepository.findByPhone(userinfo.getPhone()))){
            msg="手机号已经被使用";
            code=400;
        }
        try {
          userInfoRepository.save(userinfo);
        }catch (Exception e) {
            System.out.println("异常捕获 :" + e);
            msg="注册异常";
            code=500;
        }
        map.put("userinfo",userinfo);
        map.put("msg",msg);
        map.put("code",code);
        return map;
    }


}
