package pedroH.ApiRest.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedroH.ApiRest.Entity.Usuario;
import pedroH.ApiRest.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class ControllerAll {
    public final UserRepository userRepository;

    public ControllerAll(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/teste") // Teste do Tomcat
    public String teste() {
        return "Its is okay! ";
    }

    @PostMapping("/criar")
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
        Usuario user = userRepository.save(usuario);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping("/Listar")
    public List<Usuario> list() {
        return userRepository.findAll();
    }

    @GetMapping("/buscar/{id}") //
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(t -> ResponseEntity.ok(t))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}/{nome}/{idade}") //
    public ResponseEntity<?> update(@PathVariable Long id, @PathVariable String nome, @PathVariable Integer idade) {
            Optional<Usuario> user = userRepository.findById(id);

            if (user.isEmpty()) {
                return ResponseEntity.status(404).body("Usuario não encontrado!");
            }

            Usuario userUpdate = user.get();
            userUpdate.setNome(nome);
            userUpdate.setIdade(idade);
            Usuario updatedUser = userRepository.save(userUpdate);

            return ResponseEntity.status(200).body(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
           return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
