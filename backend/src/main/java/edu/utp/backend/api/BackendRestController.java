package edu.utp.backend.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utp.backend.entities.Usuario;
import edu.utp.backend.services.UsuarioService;
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
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class BackendRestController {

// -------(USUARIO)------------------------------------|
    private final UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(service.create(usuario),
        HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Usuario> update(@PathVariable Integer id,
                                          @RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.update(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

// -------(DOCUMENTO)------------------------------------|
    

}
