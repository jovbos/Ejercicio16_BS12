package com.bosonit.BP1.application.ports.professor;

import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorInputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.springframework.http.ResponseEntity;

public interface UpdateProfessorPort {

    public ResponseEntity<ProfessorOutputDTO> updateProfessor (String id, ProfessorInputDTO professorDTO);
}
