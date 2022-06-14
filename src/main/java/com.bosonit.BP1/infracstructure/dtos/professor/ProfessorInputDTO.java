package com.bosonit.BP1.infracstructure.dtos.professor;

import com.bosonit.BP1.domain.entities.Person;
import lombok.Data;

@Data
public class ProfessorInputDTO {

    private String id_professor;

    private Integer id_person;

    private String branch;

    private String comments;

}
