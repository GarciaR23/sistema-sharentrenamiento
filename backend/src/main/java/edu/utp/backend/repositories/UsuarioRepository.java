package edu.utp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utp.backend.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
