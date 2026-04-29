package edu.utp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utp.backend.entities.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

}
