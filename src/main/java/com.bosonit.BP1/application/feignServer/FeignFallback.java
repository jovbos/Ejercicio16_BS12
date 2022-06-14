package com.bosonit.BP1.application.feignServer;

import com.bosonit.BP1.application.ports.professor.GetProfessorPort;
import com.bosonit.BP1.infracstructure.dtos.professor.ProfessorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FeignFallback implements FeignServer{

    @Autowired
    GetProfessorPort getProfessorPort;

    public ResponseEntity<ProfessorOutputDTO> callServer(String id, String ouputType) throws Exception {


        return ResponseEntity.ok(getProfessorPort.getProfessorId(id, ouputType).getBody());
    }

}
