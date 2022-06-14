package com.bosonit.BP1.infracstructure.controllers.subject;

import com.bosonit.BP1.application.ports.subject.DeleteSubjectPort;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteSubjectController {

    @Autowired
    DeleteSubjectPort deletePort;

    @DeleteMapping("/subject/{id}")
    public ResponseEntity<SubjectOutputDTO> deleteSubject(@PathVariable String id) throws Exception {

        return deletePort.deleteSubject(id);
    }
}
