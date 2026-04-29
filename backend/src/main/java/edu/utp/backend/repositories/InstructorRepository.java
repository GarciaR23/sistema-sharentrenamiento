package edu.utp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utp.backend.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
