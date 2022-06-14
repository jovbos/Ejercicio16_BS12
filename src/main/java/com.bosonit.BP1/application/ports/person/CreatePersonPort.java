package com.bosonit.BP1.application.ports.person;

import com.bosonit.BP1.infracstructure.dtos.person.PersonInputDTO;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;

public interface CreatePersonPort {
    public PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception ;
}
