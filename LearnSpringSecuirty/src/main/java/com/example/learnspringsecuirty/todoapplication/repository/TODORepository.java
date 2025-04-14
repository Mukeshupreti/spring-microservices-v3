package com.example.learnspringsecuirty.todoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TODORepository extends JpaRepository<Todo,Long> {



}
