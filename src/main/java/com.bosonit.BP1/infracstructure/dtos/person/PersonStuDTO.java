package com.bosonit.BP1.infracstructure.dtos.person;

import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import lombok.Data;


@Data
public class PersonStuDTO extends PersonOutputDTO {
    
    private StudentOutputDTO student;

}
