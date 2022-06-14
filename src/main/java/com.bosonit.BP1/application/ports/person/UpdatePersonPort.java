package com.bosonit.BP1.application.ports.person;

import com.bosonit.BP1.infracstructure.dtos.person.PersonInputDTO;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import org.springframework.http.ResponseEntity;

public interface UpdatePersonPort {

    public ResponseEntity<PersonOutputDTO> updatePerson (Integer id, PersonInputDTO personDTO);
}
