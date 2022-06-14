package com.bosonit.BP1.infracstructure.dtos.person;

import com.bosonit.BP1.domain.entities.Person;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import lombok.Data;

import java.util.Date;

@Data
public class PersonProfDTO extends PersonOutputDTO{

    private ProfessorOutputDTO professor;
}
