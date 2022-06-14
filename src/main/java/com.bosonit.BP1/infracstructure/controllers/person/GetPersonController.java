package com.bosonit.BP1.infracstructure.controllers.person;

import com.bosonit.BP1.application.ports.person.GetPersonPort;
import com.bosonit.BP1.infracstructure.dtos.person.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
public class GetPersonController {

    @Autowired
    GetPersonPort getPort;

    @GetMapping("/person/{id}")
    public ResponseEntity<PersonOutputDTO> getPersonId(@PathVariable("id") Integer id, @QueryParam("outputType") String outputType) throws Exception {

        return getPort.getPersonId(id, outputType);
    }

    @GetMapping("/person/name/{name}")
    public List<PersonOutputDTO> getPersonName(@PathVariable("name") String name, @QueryParam("outputType") String outputType) {

        return getPort.getPersonName(name, outputType);
    }

//    @GetMapping("/student/id/{id}")
//    public List<StudentOutputDTO> getStudent(@PathVariable("id") Integer id) {
//
//        return getPort.getStudent(id);
//    }

    @GetMapping("/person")
    public List<PersonOutputDTO> getPersonAll(@QueryParam("outputType") String outputType) {

        return getPort.getPersonAll(outputType);
    }


    // Frontend Controller
    @CrossOrigin(origins = "https://cdpn.io")
    @GetMapping("/getall")
    public List<PersonOutputDTO> getAllFrontend(@QueryParam("outputType") String outputType) {

        outputType="simple";
        return getPort.getPersonAll(outputType);
    }
}
