package mjvapi.gameteam.dto.usuario;

import mjvapi.gameteam.dto.endereco.EnderecoResponseBody;
import mjvapi.gameteam.model.UsuarioModel;

import java.time.LocalDate;

public class UsuarioResponseBody {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate registro;
    private EnderecoResponseBody endereco;

    public UsuarioResponseBody() {

    }

    public UsuarioResponseBody(UsuarioModel usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        senha = usuario.getSenha();
        registro = usuario.getRegistro();

        if (usuario.getEndereco() != null) {
            endereco = new EnderecoResponseBody(usuario.getEndereco());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getRegistro() {
        return registro;
    }

    public void setRegistro(LocalDate registro) {
        this.registro = registro;
    }

    public EnderecoResponseBody getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseBody endereco) {
        this.endereco = endereco;
    }

}
