package com.java.Project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int cource_id ;

    @ManyToMany(mappedBy = "courses")
    @JsonBackReference
    private Set<validation> validations = new HashSet<>();

    public Set<validation> getValidations() {
        return validations;
    }

    public void setValidations(Set<validation> validations) {
        this.validations = validations;
    }

    public Course(){

    }

    public Course(String cource_name,String cource_desc){
        super();
        this.cource_name = cource_name ;
        this.cource_desc = cource_desc ;
    }

    public String cource_name ;

    public int getCource_id() {
        return cource_id;
    }

    public void setCource_id(int cource_id) {
        this.cource_id = cource_id;
    }

    public String getCource_name() {
        return cource_name;
    }

    public void setCource_name(String cource_name) {
        this.cource_name = cource_name;
    }

    public String getCource_desc() {
        return cource_desc;
    }

    public void setCource_desc(String cource_desc) {
        this.cource_desc = cource_desc;
    }

    public String cource_desc ;
}
