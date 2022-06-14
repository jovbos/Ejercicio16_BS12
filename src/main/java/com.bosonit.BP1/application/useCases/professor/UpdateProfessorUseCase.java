package com.bosonit.BP1.application.useCases.professor;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.application.ports.professor.UpdateProfessorPort;
import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.repositories.ProfessorRepository;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorInputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfessorUseCase implements UpdateProfessorPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProfessorRepository repository;

    public ResponseEntity<ProfessorOutputDTO> updateProfessor (String id, ProfessorInputDTO professorDTO) {

        if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
            else{
                Professor professor = modelMapper.map(professorDTO, Professor.class);
                professor.setId_professor(id);

                if (professor.getBranch() == null)
                throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
                repository.save(professor);

                ProfessorOutputDTO professorOut = modelMapper.map(professor, ProfessorOutputDTO.class);

            return ResponseEntity.ok().body(professorOut);
         }
    }
}
