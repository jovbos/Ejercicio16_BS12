package com.bosonit.BP1.domain.repositories;

import com.bosonit.BP1.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);

}
