package edu.utp.backend.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.utp.backend.entities.Paciente;
import edu.utp.backend.entities.SensibilidadPaciente;
import edu.utp.backend.repositories.PacienteRepository;
import edu.utp.backend.repositories.SensibilidadPacienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SensibilidadPacienteService {

    private final SensibilidadPacienteRepository repository;
    private final PacienteRepository pacienteRepository;

    public List<SensibilidadPaciente> findAll() {
        return repository.findAll();
    }

    public SensibilidadPaciente create(SensibilidadPaciente sensibilidad) {
        if (sensibilidad.getIdSensibilidad() != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El ID de sensibilidad ya fue asignado");
        }

        if (sensibilidad.getPaciente() == null ||
                sensibilidad.getPaciente().getIdPaciente() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Debe proporcionar un id_paciente válido");
        }

        if (sensibilidad.getTipoSensibilidad() == null ||
                sensibilidad.getTipoSensibilidad().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Debe proporcionar un tipo de sensibilidad válido");
        }

        Paciente paciente = pacienteRepository.findById(
                sensibilidad.getPaciente().getIdPaciente())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Paciente no encontrado"));

        sensibilidad.setPaciente(paciente);

        return repository.save(sensibilidad);
    }

    public SensibilidadPaciente update(Integer id, SensibilidadPaciente sensibilidad) {
        SensibilidadPaciente aux = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Id de sensibilidad no encontrado"));

        if (sensibilidad.getTipoSensibilidad() != null &&
                !sensibilidad.getTipoSensibilidad().isBlank()) {
            aux.setTipoSensibilidad(sensibilidad.getTipoSensibilidad());
        }

        if (sensibilidad.getPaciente() != null &&
                sensibilidad.getPaciente().getIdPaciente() != null) {

            Paciente paciente = pacienteRepository.findById(
                    sensibilidad.getPaciente().getIdPaciente())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Paciente no encontrado"));

            aux.setPaciente(paciente);
        }

        return repository.save(aux);
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Id de sensibilidad no encontrado");
        }
        repository.deleteById(id);
    }
}