package com.bosonit.BP1.application.ports.professor;

import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetProfessorPort {

    public ResponseEntity<ProfessorOutputDTO> getProfessorId(String id, String outputType) throws Exception;

//    public List<ProfessorOutputDTO> getProfessorName(String name);

    public List<ProfessorOutputDTO> getProfessorAll();

    public List<StudentOutputDTO> getProfessorStudents(String id);

}
