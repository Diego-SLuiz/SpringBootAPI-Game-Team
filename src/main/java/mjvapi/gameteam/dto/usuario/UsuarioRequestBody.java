package mjvapi.gameteam.dto.usuario;

import mjvapi.gameteam.model.UsuarioModel;
import mjvapi.gameteam.util.BuscarEnderecoPorCep;

public class UsuarioRequestBody {
    private String nome;
    private String email;
    private String senha;
    private String cep;

    public static UsuarioModel converterEmUsuario(UsuarioRequestBody usuarioDto) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(usuarioDto.getSenha());

        return usuario;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
