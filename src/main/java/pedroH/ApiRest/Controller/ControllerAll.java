package pedroH.ApiRest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedroH.ApiRest.Repository.UserRepository;

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

}
