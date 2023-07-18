package com.java.Project.Mapper;

import com.java.Project.DTO.validationDTO;
import com.java.Project.Entity.validation;
import com.java.Project.Service.service;
import org.springframework.beans.factory.annotation.Autowired;

public class validationMapper {
    @Autowired
    final static com.java.Project.Service.service service = new service();

    public static validationDTO toDTO(validation validation){
        validationDTO validationDTO = new validationDTO();
        validationDTO.setProfile_Id(validation.getId());
        String fullName = validation.getFname()+ " " + validation.getLname() ;
        validationDTO.setProfile_Name(fullName);
        return  validationDTO ;
    }

    public static validation toEntity(validationDTO validationDTO){
        validation validation = new validation();
        String Names[] = validationDTO.getProfile_Name().split(" ");
        validation.setFname(Names[0]);
        validation.setLname(Names[1]);
        return validation ;
    }
}
