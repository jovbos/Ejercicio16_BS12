package com.bosonit.BP1.infracstructure.controllers.subject;

import com.bosonit.BP1.application.ports.subject.CreateSubjectPort;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateSubjectController {

    @Autowired
    CreateSubjectPort createPort;

    @PostMapping("/subject")
    public SubjectOutputDTO createAssigment(@RequestBody SubjectInputDTO subjectDTO) throws Exception {

        return createPort.addSubject(subjectDTO);

    }

}
