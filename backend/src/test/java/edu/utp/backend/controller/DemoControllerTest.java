package edu.utp.backend.controller;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import edu.utp.backend.entities.Usuario;
import edu.utp.backend.repositories.UsuarioRepository;

@SpringBootTest
@Transactional
public class DemoControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void testDemoEndpoint() throws Exception {
        this.mockMvc.perform(get("/api/demo"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("TDEE")));
    }

    @Test
    void testUsuarioRepositoryCrudBasico() {
        Usuario usuario = new Usuario();
        usuario.setEmail("tutor.demo@correo.com");
        usuario.setContraseña("123456");
        usuario.setRol("tutor");
        usuario.setEstadoCuenta("activo");

        Usuario guardado = usuarioRepository.save(usuario);

        assertNotNull(guardado.getId());
        assertEquals("tutor.demo@correo.com", guardado.getEmail());

        //Hibernate debe generar esto automáticamente
        assertNotNull(guardado.getFechaCreacion());

        assertTrue(usuarioRepository.findById(guardado.getId()).isPresent());
    }
}