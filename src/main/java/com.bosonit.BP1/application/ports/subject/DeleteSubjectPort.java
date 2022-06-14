package com.bosonit.BP1.application.ports.subject;

import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.http.ResponseEntity;

public interface DeleteSubjectPort {

    public ResponseEntity<SubjectOutputDTO> deleteSubject(String id) throws Exception;
}
