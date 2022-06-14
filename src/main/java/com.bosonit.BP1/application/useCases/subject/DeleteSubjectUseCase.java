package com.bosonit.BP1.application.useCases.subject;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.subject.DeleteSubjectPort;
import com.bosonit.BP1.domain.entities.Subject;
import com.bosonit.BP1.domain.repositories.SubjectRepository;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteSubjectUseCase implements DeleteSubjectPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SubjectRepository repository;

    public ResponseEntity<SubjectOutputDTO> deleteSubject(String id)  throws Exception {
    if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
    else {
          Subject subject = repository.findById(id).orElseThrow(() -> new Exception("Assignment not registered."));

          if (subject.getStudentList() == null)
          repository.delete(subject);
          else throw new Exception("THIS SUBJECT IS ALREADY ON COURSE");

          return ResponseEntity.ok().build();
        }
    }
}
