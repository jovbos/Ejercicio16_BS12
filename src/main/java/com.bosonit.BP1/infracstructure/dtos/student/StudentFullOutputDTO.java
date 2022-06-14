package com.bosonit.BP1.infracstructure.dtos.student;

import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import lombok.Data;

import java.util.List;

@Data
public class StudentFullOutputDTO extends StudentOutputDTO{

    private PersonOutputDTO person;

    private List<SubjectOutputDTO> subjectList;

}
