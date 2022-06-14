package com.bosonit.BP1.application.useCases.professor;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.professor.DeleteProfessorPort;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.repositories.ProfessorRepository;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfessorUseCase implements DeleteProfessorPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProfessorRepository repository;

    public ResponseEntity<ProfessorOutputDTO> deleteProfessor(String id)  throws Exception {
    if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
    else {
          Professor Professor = repository.findById(id).orElseThrow(() -> new Exception("Assignment not registered."));
          repository.delete(Professor);

          return ResponseEntity.ok().build();
        }
    }
}
