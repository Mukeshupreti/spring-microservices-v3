package org.example.relationship.manytoMany.repository;


import org.example.relationship.manytoMany.entity.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammerRepository extends JpaRepository<Programmer,Long> {


}
