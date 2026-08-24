package pedroH.ApiRest.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedroH.ApiRest.Entity.Usuario;
import pedroH.ApiRest.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/teste") // Teste do Tomcat
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok(service.teste());
    }

    @PostMapping("/criar")
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarUser(data));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> list() {
        return ResponseEntity.ok(service.listarUser());
    }

    @GetMapping("/buscar/{id}") //
    public ResponseEntity<Optional<Usuario>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.pegarUser(id));
    }

    @PutMapping("/update/{id}") //
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Usuario data) {
        return ResponseEntity.ok(service.atualizarUsuario(data, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}