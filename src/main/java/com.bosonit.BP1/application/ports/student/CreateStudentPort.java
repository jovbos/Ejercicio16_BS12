package com.bosonit.BP1.application.ports.student;

import com.bosonit.BP1.infracstructure.dtos.student.StudentFullOutputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentInputDTO;
import com.bosonit.BP1.infracstructure.dtos.student.StudentOutputDTO;

public interface CreateStudentPort {
    public StudentOutputDTO addStudent(StudentInputDTO studentDTO) throws Exception ;
}
