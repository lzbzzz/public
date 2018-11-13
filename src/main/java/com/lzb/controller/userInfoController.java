package com.lzb.controller;

import com.lzb.Repository.UserInfoRepository;
import com.lzb.model.OperateResult;
import com.lzb.model.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class userInfoController extends publicController<userInfo> {
    @Autowired
    private UserInfoRepository userInfoRepository;


    @RequestMapping("/userinfo")
    @ResponseBody
    private List<userInfo> getuser(){
        List<userInfo> user2=userInfoRepository.findByUserNameContaining("169057");
        user2.add(userInfoRepository.findById(2));
        return user2;
    }

    @RequestMapping(value = "/updates",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public userInfo updateUserNameById(@RequestBody userInfo userinfo ){//必须传递json格式
/**
 *       String email = request.getParameter("email");
 *       String userName=request.getParameter("userName");
 *       String realName=request.getParameter("realName");
 *       String password=request.getParameter("password");
 *       String type=request.getParameter("type");
 **/
        userInfo user=userInfoRepository.findById(userinfo.getId());
        //判断是否需要更新
        if (!StringUtils.isEmpty(userinfo.getEmail())){
            user.setEmail(userinfo.getEmail());
        }
        if (!StringUtils.isEmpty(userinfo.getUserName())){
            user.setUserName(userinfo.getUserName());
        }
        if (!StringUtils.isEmpty(userinfo.getRealName())){
            user.setRealName(userinfo.getRealName());
        }
        if (!StringUtils.isEmpty(userinfo.getPassword())){
            user.setPassword(userinfo.getPassword());
        }
        if (!StringUtils.isEmpty(userinfo.getType())){
            user.setType(userinfo.getType());
        }
        return   userInfoRepository.saveAndFlush(user);
    }

    @RequestMapping(value = "/loginCheck")
    @ResponseBody
    public OperateResult loginCheck(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        userInfo user=userInfoRepository.findByUserName(userName);
        if(user.getPassword().equals(password) && !StringUtils.isEmpty(password)){
            return new OperateResult(true,"登录成功",user);
        }else{
            return new OperateResult(false,"登录失败",user);
        }
    }
}
