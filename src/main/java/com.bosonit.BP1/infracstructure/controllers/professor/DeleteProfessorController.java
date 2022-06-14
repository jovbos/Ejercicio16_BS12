package com.bosonit.BP1.infracstructure.controllers.professor;

import com.bosonit.BP1.application.ports.professor.DeleteProfessorPort;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteProfessorController {

    @Autowired
    DeleteProfessorPort deletePort;

    @DeleteMapping("/professor/{id}")
    public ResponseEntity<ProfessorOutputDTO> deleteProfessor(@PathVariable String id) throws Exception {

        return deletePort.deleteProfessor(id);
    }
}
