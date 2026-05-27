package pedroH.ApiRest.Controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import pedroH.ApiRest.Entity.Usuario;
import pedroH.ApiRest.Repository.UserRepository;

import java.util.List;

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
    public Usuario criate(@Valid @RequestBody Usuario usuario) {
        return userRepository.save(usuario);
    }

    @GetMapping("/Listar")
    public List<Usuario> List() {
        return userRepository.findAll();
    }

    @GetMapping("/buscar/{id}") //
    public Usuario find(@PathVariable Long id) {
        Usuario user =  userRepository.findById(id).get();

        return user;
    }

    @PutMapping("/update/{id}/{nome}/{idade}") //
    public Usuario update(Usuario usuario, @PathVariable Long id, @PathVariable String nome, @PathVariable Integer idade) {
        Usuario newUser = userRepository.findById(id).get();
        newUser.setNome(nome);
        newUser.setIdade(idade);
        return userRepository.save(newUser);
    }

    @DeleteMapping("/delete/{id}")
    public Usuario delete(@PathVariable Long id) {
        Usuario user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }
}
