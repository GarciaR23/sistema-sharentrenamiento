package edu.utp.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.utp.backend.entities.SensibilidadPaciente;
import edu.utp.backend.repositories.SensibilidadPacienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SensibilidadPacienteService {

    private final SensibilidadPacienteRepository repository;

    public List<SensibilidadPaciente> findAll() {
        return repository.findAll();
    }

    public SensibilidadPaciente create(SensibilidadPaciente sensibilidad) {
        return repository.save(sensibilidad);
    }
}