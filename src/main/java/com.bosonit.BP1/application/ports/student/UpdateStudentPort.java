package com.bosonit.BP1.application.ports.student;

import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UpdateStudentPort {

    public ResponseEntity<StudentOutputDTO> updateStudent (String id, StudentInputDTO studentDTO);

    public List<SubjectOutputDTO> addSubjectList (String id, List<String> idSubjects) throws Exception;

    public List<SubjectOutputDTO> deleteSubjectList (String id, List<String> idSubjects);

}
