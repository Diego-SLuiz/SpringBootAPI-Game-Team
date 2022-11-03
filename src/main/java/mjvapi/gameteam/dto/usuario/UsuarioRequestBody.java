package mjvapi.gameteam.dto.usuario;

public class UsuarioRequestBody {
    private String nome;
    private String email;
    private String senha;
    private Long endereco;
    private Long biblioteca;

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

    public Long getEndereco() {
        return endereco;
    }

    public void setEndereco(Long endereco) {
        this.endereco = endereco;
    }

    public Long getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Long biblioteca) {
        this.biblioteca = biblioteca;
    }

}
