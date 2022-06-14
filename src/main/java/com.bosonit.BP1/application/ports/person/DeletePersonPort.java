package com.bosonit.BP1.application.ports.person;

import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import org.springframework.http.ResponseEntity;

public interface DeletePersonPort {

    public ResponseEntity<PersonOutputDTO> deletePerson(Integer id) throws Exception;
}
