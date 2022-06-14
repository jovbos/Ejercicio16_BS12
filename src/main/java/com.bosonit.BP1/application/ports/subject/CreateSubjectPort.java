package com.bosonit.BP1.application.ports.subject;

import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;

public interface CreateSubjectPort {
    public SubjectOutputDTO addSubject(SubjectInputDTO subjectDTO) throws Exception ;
}
