package com.github.lessalc.personapi.repository;

import com.github.lessalc.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
