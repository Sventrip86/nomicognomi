package com.fabs.nomicognomi.repository;

import com.fabs.nomicognomi.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findBySurnameContaining(String searchTerm, Pageable pageable);

    @Query("select p from Post p join p.tags t where t.name = :tagName")
    List<Person> findPostsByTagName(@Param("tagName") String tagName);


}