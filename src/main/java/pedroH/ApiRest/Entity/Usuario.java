package pedroH.ApiRest.Entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "BandoDeDados")

@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome Null") // Nome vazil
    private String nome;

    @Max(value = 120, message = "Idade Muito Alta") // Idades acima de 120 não sao permitidas
    @Min(value = 0, message = "Idade não pode ser negativa") // Idade = 0 É Válida!
    private int idade;
}
