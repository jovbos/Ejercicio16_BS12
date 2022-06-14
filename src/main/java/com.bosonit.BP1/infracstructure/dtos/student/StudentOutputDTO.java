package com.bosonit.BP1.infracstructure.dtos.student;

import lombok.Data;

@Data
public class StudentOutputDTO {

    private String id_student;

    private Integer id_person;

    private Integer hours_per_week;

    private String comments;

    private String id_professor;

    private String branch;

}
