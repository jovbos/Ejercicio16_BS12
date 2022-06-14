package com.bosonit.BP1.domain.repositories;

import com.bosonit.BP1.domain.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
