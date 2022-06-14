package com.bosonit.BP1.infracstructure.controllers.student;

import com.bosonit.BP1.application.ports.student.UpdateStudentPort;
import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectInputDTO;
import com.bosonit.BP1.infracstructure.dtos.subject.SubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UptdateStudentController {

    @Autowired
    UpdateStudentPort updatePort;

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentOutputDTO> updateStudent(@PathVariable("id") String id, @RequestBody StudentInputDTO studentDTO) {

        return updatePort.updateStudent(id, studentDTO);
    }

    @PutMapping("/student/addSubjectList/{id}")
    public List<SubjectOutputDTO> addSubjects(@PathVariable("id") String id, @RequestBody List<String> idSubjects) throws Exception {

        return updatePort.addSubjectList(id, idSubjects);
    }

    @DeleteMapping("student/deleteSubjectList/{id}")
    public void deleteSubjects(@PathVariable("id") String id, @RequestBody List<String> idSubjects) {

        updatePort.deleteSubjectList(id, idSubjects);

    }

}
