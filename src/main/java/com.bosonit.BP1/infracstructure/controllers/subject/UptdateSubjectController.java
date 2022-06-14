package com.bosonit.BP1.infracstructure.controllers.subject;

import com.bosonit.BP1.application.ports.subject.UpdateSubjectPort;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient
public class UptdateSubjectController {

    @Autowired
    UpdateSubjectPort updatePort;

    @PutMapping("/subject/{id}")
    public ResponseEntity<SubjectOutputDTO> updateSubject(@PathVariable("id") String id, @RequestBody SubjectInputDTO subjectDTO) {

        return updatePort.updateSubject(id, subjectDTO);
    }

}
