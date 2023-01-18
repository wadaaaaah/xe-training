package com.accenture.XEtraining.repository;

import com.accenture.XEtraining.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeRepository extends JpaRepository<Demo,Long> {

    Demo findByName(String name);
}
