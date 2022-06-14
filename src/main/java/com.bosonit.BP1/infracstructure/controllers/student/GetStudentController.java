package com.bosonit.BP1.infracstructure.controllers.student;

import com.bosonit.BP1.application.ports.student.GetStudentPort;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.infracstructure.dtos.student.StudentFullOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
public class GetStudentController {

    @Autowired
    GetStudentPort getPort;

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentOutputDTO> getStudentId(@PathVariable("id") String id, @QueryParam("outputType") String outputType) throws Exception {


        return getPort.getStudentId(id, outputType);
    }


    @GetMapping("/student")
    public List<StudentOutputDTO> getStudentAll() {

        return getPort.getStudentAll();
    }

    @GetMapping("/student/subjectList/{id}")
    public List<SubjectOutputDTO> getSubjectList(@PathVariable("id") String id) {

        return getPort.getStudentSubjects(id);
    }
}
