package mjvapi.gameteam.dto.usuario;

import mjvapi.gameteam.model.UsuarioModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioResponseBody {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate registro;
    private Long endereco;
    private Long biblioteca;

    public static UsuarioResponseBody converterEmDto(UsuarioModel usuario) {
        UsuarioResponseBody usuarioDto = new UsuarioResponseBody();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setSenha(usuario.getSenha());
        usuarioDto.setRegistro(usuario.getRegistro());
        usuarioDto.setEndereco(usuario.getEndereco().getId());
        usuarioDto.setBiblioteca(usuario.getBiblioteca().getId());

        return usuarioDto;
    }

    public static List<UsuarioResponseBody> converterEmListaDto(List<UsuarioModel> usuarios) {
        ArrayList<UsuarioResponseBody> usuariosDto = new ArrayList<UsuarioResponseBody>();

        for (UsuarioModel usuario: usuarios) {
            usuariosDto.add(UsuarioResponseBody.converterEmDto(usuario));
        }

        return usuariosDto;
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
