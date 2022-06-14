package com.bosonit.BP1.infracstructure.controllers.professor;

import com.bosonit.BP1.application.ports.professor.GetProfessorPort;
import com.bosonit.BP1.application.ports.student.GetStudentPort;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
public class GetProfessorController {

    @Autowired
    GetProfessorPort getPort;


    @GetMapping("/professor/{id}")
    public ResponseEntity<ProfessorOutputDTO> getProfessorId(@PathVariable("id") String id, @QueryParam("outputType") String outputType) throws Exception {

        return getPort.getProfessorId(id, outputType);
    }

//    @GetMapping("/Professor/name/{name}")
//    public List<ProfessorOutputDTO> getProfessorName(@PathVariable("name") String name) {
//
//        return getPort.getProfessorName(name);
//    }

    @GetMapping("/professor")
    public List<ProfessorOutputDTO> getProfessorAll() {

        return getPort.getProfessorAll();
    }

    @GetMapping("/professor/studentList/{id}")
    public List<StudentOutputDTO> getStudentList(@PathVariable("id") String id) {

        return getPort.getProfessorStudents(id);
    }
}
