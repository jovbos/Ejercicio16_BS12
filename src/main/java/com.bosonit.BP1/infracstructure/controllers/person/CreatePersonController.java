package com.bosonit.BP1.infracstructure.controllers.person;

import com.bosonit.BP1.application.ports.person.CreatePersonPort;
import com.bosonit.BP1.infracstructure.dtos.person.PersonInputDTO;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreatePersonController {

    @Autowired
    CreatePersonPort createPort;

    @PostMapping("/person")
    public PersonOutputDTO createPerson(@RequestBody PersonInputDTO personDTO) throws Exception {

        return createPort.addPerson(personDTO);

    }

    // Frontend Controller
    @CrossOrigin(origins = "https://cdpn.io")
    @PostMapping("/addperson")
    public PersonOutputDTO createPersonFrontend(@RequestBody PersonInputDTO personDTO) throws Exception {

        return createPort.addPerson(personDTO);

    }

}
