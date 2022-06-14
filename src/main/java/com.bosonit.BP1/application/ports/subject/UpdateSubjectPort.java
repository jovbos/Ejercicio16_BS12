package com.bosonit.BP1.application.ports.subject;

import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UpdateSubjectPort {

    public ResponseEntity<SubjectOutputDTO> updateSubject (String id, SubjectInputDTO subjectDTO);

}
