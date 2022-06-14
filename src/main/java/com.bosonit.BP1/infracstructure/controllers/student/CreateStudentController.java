package com.bosonit.BP1.infracstructure.controllers.student;

import com.bosonit.BP1.application.ports.student.CreateStudentPort;
import com.bosonit.BP1.infracstructure.dtos.student.StudentFullOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStudentController {

    @Autowired
    CreateStudentPort createPort;

    @PostMapping("/student")
    public StudentOutputDTO createAssigment(@RequestBody StudentInputDTO studentDTO) throws Exception {

        return createPort.addStudent(studentDTO);

    }

}
