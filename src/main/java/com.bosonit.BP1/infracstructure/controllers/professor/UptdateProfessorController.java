package com.bosonit.BP1.infracstructure.controllers.professor;

import com.bosonit.BP1.application.ports.professor.UpdateProfessorPort;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorInputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UptdateProfessorController {

    @Autowired
    UpdateProfessorPort updatePort;

    @PutMapping("/professor/{id}")
    public ResponseEntity<ProfessorOutputDTO> updateProfessor(@PathVariable("id") String id, @RequestBody ProfessorInputDTO professorDTO) {

        return updatePort.updateProfessor(id, professorDTO);
    }

}
