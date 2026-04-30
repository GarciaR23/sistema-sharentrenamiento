package edu.utp.backend.repositories;

import edu.utp.backend.entities.ProtocoloEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProtocoloEmergenciaRepository extends JpaRepository<ProtocoloEmergencia, Integer> {
}