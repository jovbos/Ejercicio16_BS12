package com.bosonit.BP1.application.ports.subject;

import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetSubjectPort {

    public ResponseEntity<SubjectOutputDTO> getSubjectId(String id) throws Exception;

//    public List<SubjectOutputDTO> getSubjectName(String name);

    public List<SubjectOutputDTO> getSubjectAll();
}
