package com.bosonit.BP1.application.ports.student;

import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.infracstructure.dtos.student.StudentFullOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetStudentPort {

    public ResponseEntity<StudentOutputDTO> getStudentId(String id, String outputType) throws Exception;

//    public List<StudentOutputDTO> getStudentName(String name);

    public List<StudentOutputDTO> getStudentAll();

    public List<SubjectOutputDTO> getStudentSubjects(String id);
}
