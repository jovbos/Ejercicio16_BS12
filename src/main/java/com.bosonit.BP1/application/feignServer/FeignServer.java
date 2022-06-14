package com.bosonit.BP1.application.feignServer;


import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.QueryParam;

@FeignClient(name="tralala", url = "https://localhost:8080")
public interface FeignServer {

    @GetMapping("/professor/{id}")
    ResponseEntity<ProfessorOutputDTO> callServer(@PathVariable("id") String id, @QueryParam("outputType") String outputType) throws Exception;
}
