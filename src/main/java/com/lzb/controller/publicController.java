package com.lzb.controller;

import com.lzb.model.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unchecked")
public abstract class publicController<T> {

    @Autowired
    private JpaRepository<T,Integer> publicRepository;


    @ResponseBody
    @RequestMapping("/listAll")
    public List<T> listAll(@ModelAttribute T entity) {
        return publicRepository.findAll();
    }

    @ResponseBody
    @RequestMapping("/listByPage")
    public Page<T> listByPage(@ModelAttribute int page, @ModelAttribute int rows) {
        Pageable pageable = new PageRequest(page, rows, Sort.Direction.ASC, "id");
        return publicRepository.findAll(pageable);
    }

    @ResponseBody
    @RequestMapping("/findById")
    public T findById(@PathVariable int id){
        return publicRepository.findOne(id);
    }

    @ResponseBody
    @RequestMapping("/create")
    public T create(@ModelAttribute T entity) {
        return publicRepository.save(entity);
    }

    @ResponseBody
    @RequestMapping("/update")
    public T update(@ModelAttribute T entity) {
        return publicRepository.saveAndFlush(entity);

    }

    @ResponseBody
    @RequestMapping("/deleteAll")
    public List<T> delete(){
        publicRepository.deleteAllInBatch();
        return publicRepository.findAll();
    }

    @ResponseBody
    @RequestMapping("/deleteById/{id}")
    public  List<T> delete(@PathVariable Integer id) {
        publicRepository.delete(id);
        return publicRepository.findAll();
    }


}
