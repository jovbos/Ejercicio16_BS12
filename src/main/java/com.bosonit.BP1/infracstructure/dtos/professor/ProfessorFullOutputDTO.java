package com.bosonit.BP1.infracstructure.dtos.professor;

import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import lombok.Data;
import java.util.Date;

@Data
public class ProfessorFullOutputDTO extends ProfessorOutputDTO {

    PersonOutputDTO person;
}
