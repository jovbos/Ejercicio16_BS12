package com.bosonit.BP1.application.useCases.student;

import com.bosonit.BP1.application.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.application.ports.student.DeleteStudentPort;
import com.bosonit.BP1.domain.entities.Student;
import com.bosonit.BP1.domain.repositories.StudentRepository;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentUseCase implements DeleteStudentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudentRepository repository;

    public ResponseEntity<StudentOutputDTO> deleteStudent(String id)  throws Exception {
    if (repository.findById(id).isEmpty()) throw new CustomErrorRequest404("NOT_FOUND");
    else {
          Student student = repository.findById(id).orElseThrow(() -> new Exception("Assignment not registered."));
          repository.delete(student);

          return ResponseEntity.ok().build();
        }
    }
}
