package edu.utp.backend.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utp.backend.entities.Documento;
import edu.utp.backend.entities.Instructor;
import edu.utp.backend.entities.ServicioInstructor;
import edu.utp.backend.entities.Usuario;
import edu.utp.backend.services.DocumentoService;
import edu.utp.backend.services.InstructorService;
import edu.utp.backend.services.ServicioInstructorService;
import edu.utp.backend.services.UsuarioService;
import edu.utp.backend.entities.Tutor;
import edu.utp.backend.services.TutorService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class BackendRestController {

    // -------(USUARIO)------------------------------------|
    private final UsuarioService service;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(service.create(usuario),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/usuarios/{id}", consumes = "application/json")
    public ResponseEntity<Usuario> update(@PathVariable Integer id,
            @RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.update(id, usuario));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // -------(DOCUMENTO)------------------------------------|
    private final DocumentoService documentoService;

    @GetMapping("/documentos")
    public ResponseEntity<List<Documento>> getAllDocumentos() {
        return ResponseEntity.ok(documentoService.findAll());
    }

    @GetMapping("/documentos/{id}")
    public ResponseEntity<Documento> getDocumentoById(@PathVariable Integer id) {
        return ResponseEntity.ok(documentoService.findById(id));
    }

    @PostMapping("/documentos")
    public ResponseEntity<Documento> createDocumento(@RequestBody Documento documento) {
        return new ResponseEntity<>(
                documentoService.create(documento),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/documentos/{id}", consumes = "application/json")
    public ResponseEntity<Documento> updateDocumento(
            @PathVariable Integer id,
            @RequestBody Documento documento) {

        return ResponseEntity.ok(
                documentoService.update(id, documento));
    }

    @DeleteMapping("/documentos/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Integer id) {
        documentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // -------(INSTRUCTOR)------------------------------------|
    private final InstructorService instructorService;

    @GetMapping("/instructores")
    public ResponseEntity<List<Instructor>> getAllInstructores() {
        return ResponseEntity.ok(instructorService.findAll());
    }

    @GetMapping("/instructores/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Integer id) {
        return ResponseEntity.ok(instructorService.findById(id));
    }

    @PostMapping("/instructores")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(
                instructorService.create(instructor),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/instructores/{id}", consumes = "application/json")
    public ResponseEntity<Instructor> updateInstructor(
            @PathVariable Integer id,
            @RequestBody Instructor instructor) {

        return ResponseEntity.ok(
                instructorService.update(id, instructor));
    }

    @DeleteMapping("/instructores/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Integer id) {
        instructorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // -------(TUTOR)------------------------------------|
    private final TutorService tutorService;

    @GetMapping("/tutores")
    public ResponseEntity<List<Tutor>> getAllTutores() {
        return ResponseEntity.ok(tutorService.findAll());
    }

    @GetMapping("/tutores/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Integer id) {
        return ResponseEntity.ok(tutorService.findById(id));
    }

    @PostMapping("/tutores")
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        return new ResponseEntity<>(
                tutorService.create(tutor),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/tutores/{id}", consumes = "application/json")
    public ResponseEntity<Tutor> updateTutor(
            @PathVariable Integer id,
            @RequestBody Tutor tutor) {

        return ResponseEntity.ok(
                tutorService.update(id, tutor));
    }

    @DeleteMapping("/tutores/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Integer id) {
        tutorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // -------(INSTRUCTOR_SERVICIO)------------------------------------|
    private final ServicioInstructorService servicioInstructorService;

    @GetMapping("/servicios")
    public ResponseEntity<List<ServicioInstructor>> getAllServicios() {
        return ResponseEntity.ok(servicioInstructorService.findAll());
    }

    @GetMapping("/servicios/{id}")
    public ResponseEntity<ServicioInstructor> getServicioById(@PathVariable Integer id) {
        return ResponseEntity.ok(servicioInstructorService.findById(id));
    }

    @PostMapping("/servicios")
    public ResponseEntity<ServicioInstructor> createServicio(
            @RequestBody ServicioInstructor servicio) {

        return new ResponseEntity<>(
                servicioInstructorService.create(servicio),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/servicios/{id}", consumes = "application/json")
    public ResponseEntity<ServicioInstructor> updateServicio(
            @PathVariable Integer id,
            @RequestBody ServicioInstructor servicio) {

        return ResponseEntity.ok(
                servicioInstructorService.update(id, servicio));
    }

    @DeleteMapping("/servicios/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Integer id) {
        servicioInstructorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}