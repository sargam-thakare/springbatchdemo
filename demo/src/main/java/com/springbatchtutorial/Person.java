package com.springbatchtutorial;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Generated
    int id;
    String name;
    String lastname;

    Person(String name , String sname){
        this.name=name;
        this.lastname=sname;
    }



}
