package com.bosonit.BP1.infracstructure.controllers.professor;

import com.bosonit.BP1.application.ports.professor.CreateProfessorPort;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorInputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateProfessorController {

    @Autowired
    CreateProfessorPort createPort;

    @PostMapping("/professor")
    public ProfessorOutputDTO createAssigment(@RequestBody ProfessorInputDTO professorDTO) throws Exception {

        return createPort.addProfessor(professorDTO);

    }

}
