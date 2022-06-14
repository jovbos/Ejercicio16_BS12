package com.bosonit.BP1.infracstructure.controllers.person;

import com.bosonit.BP1.application.ports.person.DeletePersonPort;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePersonController {

    @Autowired
    DeletePersonPort deletePort;

    @DeleteMapping("/person/{id}")
    public ResponseEntity<PersonOutputDTO> deletePerson(@PathVariable Integer id) throws Exception {

        return deletePort.deletePerson(id);
    }
}
