package com.bosonit.BP1.infracstructure.dtos.student;

import com.bosonit.BP1.domain.entities.Person;
import lombok.Data;

@Data
public class StudentInputDTO {

    private String id_student;

    private Integer id_person;

    private Person person;

    private Integer hours_per_week;

    private String comments;

    private String id_professor;

    private String branch;

//    private List<Subject> subjects;

}
