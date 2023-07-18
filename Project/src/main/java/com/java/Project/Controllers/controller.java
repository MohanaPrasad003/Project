package com.java.Project.Controllers;

import com.java.Project.Entity.Course;
import com.java.Project.Entity.validation;
import com.java.Project.Service.service;
import com.java.Project.DTO.validationDTO;
import com.java.Project.Mapper.validationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class controller {

    @Autowired
    service serv ;

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public List<validation> getEvery(){
        return serv.getAll() ;
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public validation create(@RequestParam("fname") String fname, @RequestParam("lname") String lname){
        return serv.created(fname,lname);
    }

    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public String update(@RequestBody() String list) {
        return serv.update(list);
    }

    @RequestMapping(value = "/addAddress",method=RequestMethod.POST)
    public String addAddress(@RequestParam("id") int id, @RequestParam("street_Name") String street_Name,@RequestParam("place") String place){
        if(serv.addAddress(id,street_Name,place)){
            return "Address Added Successfully to the User" ;
        }
        return "Address is not added to the user,please check the error logs ! ! !" ;
    }

    @RequestMapping(value="/courses",method = RequestMethod.GET)
    public List<Course> allcourses(){
        return serv.allCourses();
    }

    @RequestMapping(value="/addcourses",method = RequestMethod.POST)
    public String addCources(@RequestParam("id") int id , @RequestParam("cource_name") String cource_name,@RequestParam("cource_desc") String cource_desc){
        String s = (serv.addcources(id, cource_name, cource_desc)) ? "Cources Added Successful" : "check the code";
        return s ;
    }

    @RequestMapping(value="/addExistingCourses",method = RequestMethod.POST)
    public String addCources(@RequestParam("id") int id , @RequestParam("cource_id") int cource_id){
        String s = (serv.addexistingcourses(id,cource_id)) ? "Cources Added Successful" : "check the code";
        return s ;
    }

    @RequestMapping(value="/todto",method = RequestMethod.GET)
    public validationDTO changeDTO(@RequestParam("id") int id){
        return serv.changesDTO(id) ;
    }

    @RequestMapping(value = "/fromdto",method = RequestMethod.GET)
    public validation fromDTO(@RequestBody validationDTO validationDTO){
        return  serv.fromDTO(validationDTO) ;
    }

    @RequestMapping(value="/validation_DTO",method = RequestMethod.POST)
    public validation DTO(@RequestBody validationDTO validationDTO){
        return serv.savethis(validationMapper.toEntity(validationDTO));
    }
}
