package com.fabs.nomicognomi.repository;

import com.fabs.nomicognomi.model.Tag;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import java.util.List;


@Repository

public interface TagRepository extends JpaRepository<Tag, Long>{

    Optional<Tag> findByName(String name);

    @Query("SELECT t FROM Tag t LEFT JOIN FETCH t.posts")
    List<Tag> findAllWithUsageCount();




}
