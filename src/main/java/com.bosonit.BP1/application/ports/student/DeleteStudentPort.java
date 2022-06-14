package com.bosonit.BP1.application.ports.student;

import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.springframework.http.ResponseEntity;

public interface DeleteStudentPort {

    public ResponseEntity<StudentOutputDTO> deleteStudent(String id) throws Exception;
}
