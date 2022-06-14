package com.bosonit.BP1.application.ports.person;

import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface GetPersonPort {

    public ResponseEntity<PersonOutputDTO> getPersonId(Integer id, String outputType) throws Exception;

    public List<PersonOutputDTO> getPersonName(String name, String outputType);

    public List<PersonOutputDTO> getPersonAll(String outputType);

}
