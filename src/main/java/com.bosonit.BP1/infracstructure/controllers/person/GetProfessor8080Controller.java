package com.bosonit.BP1.infracstructure.controllers.person;

import com.bosonit.BP1.application.feignServer.FeignServer;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.QueryParam;

@RestController
public class GetProfessor8080Controller {

    @Autowired
    FeignServer feignServer;

    // Metodo con RestTemplate

//    @GetMapping("person/professor/{id}")
//    ResponseEntity<ProfessorOutputDTO> getProfessorRest(@PathVariable("id") String id) throws Exception {
//
//        try {
//            ResponseEntity<ProfessorOutputDTO> professorOutputDTO = new RestTemplate().getForEntity("http://localhost:8080/professor/" + id + "?outputType=full", ProfessorOutputDTO.class);
//            return ResponseEntity.ok(professorOutputDTO.getBody());
//
//        }
//        catch(HttpClientErrorException k1) {
//            throw new Exception("Http code is not 2XX. The server responded: " + k1.getStatusCode() +
//                    " Cause: "+ k1.getResponseBodyAsString());
//        } catch (RestClientException k) {
//            throw new Exception("The server didn't respond: " + k.getMessage());
//        }
//    }

    // Metodo con Feign

    @GetMapping("person/professor/{id}")
        ResponseEntity<ProfessorOutputDTO> getProfessorFeign(@PathVariable("id") String id, @QueryParam("outputType") String outputType) throws Exception {

        try {
            ResponseEntity<ProfessorOutputDTO> professorOutputDTO = feignServer.callServer(id, outputType);
            return ResponseEntity.ok(professorOutputDTO.getBody());

        }
        catch(HttpClientErrorException k1) {
            throw new Exception("Http code is not 2XX. The server responded: " + k1.getStatusCode() +
                    " Cause: "+ k1.getResponseBodyAsString());
        } catch (RestClientException k) {
            throw new Exception("The server didn't respond: " + k.getMessage());
        }
    }

}
