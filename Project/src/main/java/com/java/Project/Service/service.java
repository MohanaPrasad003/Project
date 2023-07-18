package com.java.Project.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.Project.Entity.Address;
import com.java.Project.Entity.Course;
import com.java.Project.Entity.validation;
import com.java.Project.Repositories.AddressRepo;
import com.java.Project.Repositories.CourceRepo;
import com.java.Project.Repositories.valiRepository;
import com.java.Project.DTO.validationDTO;
import com.java.Project.Mapper.validationMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class service {
    @Autowired
    valiRepository repository ;

    @Autowired
    AddressRepo addressRepo ;


    @Autowired
    CourceRepo courceRepo ;

    public List<validation> getAll(){
        return (List<validation>) repository.findAll();
    }

    public validation savethis(validation validation){
        return  repository.save(validation) ;
    }

    public validation created(String fname, String lname){
        validation v = new validation();
        v.setFname(fname);
        v.setLname(lname);
        return repository.save(v);
      //  return repository.findById(id).get();
    }

    public String update(String lst) {
        ObjectMapper mp = new ObjectMapper();
        List<validation> fList = new ArrayList<>() ;

        JSONParser jsonParser = new JSONParser();
        try {

            Object object = jsonParser.parse(lst);
            JSONArray List = (JSONArray) object;
            List.forEach(val -> {
                JSONObject object1 = (JSONObject) val;
                System.out.println(object1.get("id"));
                Long intt = (Long) object1.get("id");
                repository.deleteById(intt.intValue());
                validation value = new validation();
                value.setId(intt.intValue());
                value.setFname((String) object1.get("fname"));
                value.setLname((String) object1.get("lname"));
                repository.save(value);
            });
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return lst ;
    }

    public boolean addAddress(int id,String s_name,String place){
        validation v1 = repository.findById(id).get();
        List<Address> addressList = v1.getAddressList() ;
        Address address = new Address(s_name,place);
        addressRepo.save(address);
        addressList.add(address);
        repository.save(v1);
        return true ;
    }

    public List<Course> allCourses(){
        return (List<Course>) courceRepo.findAll();
    }

    public boolean addcources(int id ,String cource_name, String cource_desc){
        validation validation = repository.findById(id).get() ;
        Set<Course> courses = validation.getCourses();
        Course course = new Course(cource_name,cource_desc);
        courses.add(course);
        repository.save(validation);
        return true ;
    }

    public boolean addexistingcourses(int id,int cource_id){
        validation validation = repository.findById(id).get() ;
        Course course = courceRepo.findById(cource_id).get();
        Set<Course> courses = validation.getCourses();
        courses.add(course);
        repository.save(validation);
        return true ;
    }

    public validationDTO changesDTO(int id){
        return validationMapper.toDTO(repository.findById(id).get()) ;
    }

    public validation fromDTO(validationDTO validationDTO){
        return  repository.findById(validationDTO.getProfile_Id()).get();
    }
}
