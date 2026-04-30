package edu.utp.backend.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import edu.utp.backend.entities.Instructor;
import edu.utp.backend.entities.Usuario;
import edu.utp.backend.repositories.InstructorRepository;
import edu.utp.backend.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=PostgreSQL",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.jpa.show-sql=true"
})
public class InstructorControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Autowired
    private InstructorRepository instructorRepo;
    @Autowired
    private UsuarioRepository usuarioRepo;

    @BeforeEach
    void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    private Usuario crearUsuarioPersistido() {
        Usuario user = new Usuario();
        user.setEmail("instructor@test.com");
        user.setContraseña("123456");
        user.setRol("instructor");
        user.setEstadoCuenta("activo");
        return usuarioRepo.save(user);
    }

    // Contendido
    @Test
    void testGetInstructorEndpointContent() throws Exception{
        Usuario user = crearUsuarioPersistido();

        Instructor instructor = new Instructor();
        instructor.setUsuario(user);
        instructor.setNombreCompleto("Juan Perez");
        instructor.setEspecialidad(new String[]{"Fitness"});
        instructor.setBiografiaInstructor(
            "Especialidado en Fitness desde media de cada");

        instructorRepo.save(instructor);

        this.mockMvc.perform(get("/api/instructores"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Juan Perez")));
        
    }

    // CRUD
    //Get
    @Test
    void testGetInstructores() throws Exception {
        this.mockMvc.perform(get("/api/instructores"))
                .andExpect(status().isOk());
    }

    //Post
    @Test
    void testPostInstructorEndpoint() throws Exception {
        Usuario user = crearUsuarioPersistido();

        String newInstructor = """
            {
                "usuario": {"id": %d},
                "nombreCompleto": "Juan Perez",
                "especialidad": ["Fitness"],
                "biografiaInstructor": "Especialidado en Fitness desde media de cada"
            }
        """.formatted(user.getId());
        this.mockMvc.perform(
            post("/api/instructores")
                .contentType("application/json")
                .content(newInstructor))
                .andExpect(status().isCreated());
    }

    //Put
    @Test
    void testPutInstructorEndpoint() throws Exception {
        Usuario user = crearUsuarioPersistido();

        Instructor instructor = new Instructor();
        instructor.setUsuario(user);
        instructor.setNombreCompleto("Juan Perez");
        instructor.setEspecialidad(new String[]{"Fitness"});
        instructor.setBiografiaInstructor(
            "Especialidado en Fitness desde media de cada");

        Instructor guardado = instructorRepo.save(instructor);

        String updatedInstructor = """
            {
                "usuario": {"id": %d},
                "nombreCompleto": "Juan Perez Actualizado",
                "especialidad": ["Fitness", "Yoga"],
                "biografiaInstructor": "Especialidado en Fitness y Yoga desde media de cada"
            }
        """.formatted(user.getId());

        this.mockMvc.perform(
            put("/api/instructores/" + guardado.getIdInstructor())
                .contentType("application/json")
                .content(updatedInstructor))
                .andExpect(status().isOk());

    }

    //Delete
    @Test
    void testDeleteInstructor() throws Exception {
        Usuario user = crearUsuarioPersistido();

        Instructor instructor = new Instructor();
        instructor.setUsuario(user);
        instructor.setNombreCompleto("Juan Perez");
        instructor.setEspecialidad(new String[]{"Fitness"});
        instructor.setBiografiaInstructor(
            "Especialidado en Fitness desde media de cada");

        Instructor guardado = instructorRepo.save(instructor);

        this.mockMvc.perform(
            delete("/api/instructores/" + guardado.getIdInstructor()))
            .andExpect(status().isNoContent());
    }

}
