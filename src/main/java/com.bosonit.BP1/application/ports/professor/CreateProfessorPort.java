package com.bosonit.BP1.application.ports.professor;

import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorInputDTO;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;

public interface CreateProfessorPort {
    public ProfessorOutputDTO addProfessor(ProfessorInputDTO professorDTO) throws Exception ;
}
