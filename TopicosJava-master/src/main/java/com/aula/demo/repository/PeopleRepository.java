package com.aula.demo.repository;

import com.aula.demo.Modelo.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository  extends JpaRepository<People, Long> {
}
