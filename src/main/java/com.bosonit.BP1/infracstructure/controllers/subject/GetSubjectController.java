package com.bosonit.BP1.infracstructure.controllers.subject;

import com.bosonit.BP1.application.ports.subject.GetSubjectPort;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetSubjectController {

    @Autowired
    GetSubjectPort getPort;

    @GetMapping("/subject/{id}")
    public ResponseEntity<SubjectOutputDTO> getSubjectId(@PathVariable("id") String id) throws Exception {

        return getPort.getSubjectId(id);
    }

//    @GetMapping("/Subject/name/{name}")
//    public List<SubjectOutputDTO> getSubjectName(@PathVariable("name") String name) {
//
//        return getPort.getSubjectName(name);
//    }

    @GetMapping("/subject")
    public List<SubjectOutputDTO> getSubjectAll() {

        return getPort.getSubjectAll();
    }
}
