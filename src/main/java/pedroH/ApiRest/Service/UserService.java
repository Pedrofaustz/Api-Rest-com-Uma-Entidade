package pedroH.ApiRest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedroH.ApiRest.Entity.Usuario;
import pedroH.ApiRest.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    // Teste
    public String teste() {
        return "Its is okay! ";
    }


    // Criate
    public Usuario criarUser(Usuario data) {
        if( data == null ) {
            throw new IllegalArgumentException("Erro: Dados Inválidos");
        }
        return repository.save(data);
    }

    // List ALL
    public List<Usuario> listarUser() {
        return repository.findAll();
    }

    // Find By id
    public Optional<Usuario> pegarUser(Long id) {
        if (id == null ) {
            throw new IllegalArgumentException("Erro: Dados Inválidos");
        }
        return repository.findById(id);
    }

    // Update
    public Usuario atualizarUsuario(Usuario data, Long id) {
        if( id == null || id <= 0 || data == null ) {
            throw new IllegalArgumentException("Erro: Dados Inválidos");
        }
        Optional<Usuario> updateU = repository.findById(id);
        funcaoAtualizar(data, updateU);
        updateU.get().setId(id);
        return repository.save(updateU.get());
    }

    private void funcaoAtualizar(Usuario data, Optional<Usuario> updateU) {
        updateU.get().setIdade(data.getIdade());
        updateU.get().setNome(data.getNome());
    }

    // Delete
    public void deleteUser(Long id) {
        if (id <= 0 || id == null || repository.existsById(id) == false ) {
            throw new IllegalArgumentException("Erro: Dados Inválidos");
        }
        repository.deleteById(id);
}
}
