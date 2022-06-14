package com.bosonit.BP1.application.ports.professor;

import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.springframework.http.ResponseEntity;

public interface DeleteProfessorPort {

    public ResponseEntity<ProfessorOutputDTO> deleteProfessor(String id) throws Exception;
}
