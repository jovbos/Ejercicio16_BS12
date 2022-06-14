package com.bosonit.BP1.infracstructure.controllers.student;

import com.bosonit.BP1.application.ports.student.DeleteStudentPort;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudentController {

    @Autowired
    DeleteStudentPort deletePort;

    @DeleteMapping("/student/{id}")
    public ResponseEntity<StudentOutputDTO> deleteStudent(@PathVariable String id) throws Exception {

        return deletePort.deleteStudent(id);
    }
}
