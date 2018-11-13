package com.lzb.controller;

import com.lzb.Repository.RoleRepository;
import com.lzb.model.role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class roleController extends publicController<role>{

    @Autowired
    private RoleRepository roleRepository;



}
