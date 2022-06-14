package com.bosonit.BP1.infracstructure.controllers.person;

import com.bosonit.BP1.application.ports.person.UpdatePersonPort;
import com.bosonit.BP1.infracstructure.dtos.person.PersonInputDTO;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UptdatePersonController {

    @Autowired
    UpdatePersonPort updatePort;

    @PutMapping("/person/{id}")
    public ResponseEntity<PersonOutputDTO> updatePerson(@PathVariable("id") Integer id, @RequestBody PersonInputDTO personDTO) {

        return updatePort.updatePerson(id, personDTO);
    }

}
