package com.bosonit.BP1.domain.repositories;

import com.bosonit.BP1.domain.entities.Professor;
import com.bosonit.BP1.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, String> {

//    List<Professor> findByPersonId(Integer id);

}
