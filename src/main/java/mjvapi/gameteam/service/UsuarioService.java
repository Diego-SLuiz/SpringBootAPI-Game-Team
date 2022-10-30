package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.usuario.UsuarioRequestBody;
import mjvapi.gameteam.model.EnderecoModel;
import mjvapi.gameteam.model.UsuarioModel;
import mjvapi.gameteam.repository.EnderecoRepository;
import mjvapi.gameteam.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    public List<UsuarioModel> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public void salvarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void novoUsuario(UsuarioModel usuarioBody) {
        salvarUsuario(usuarioBody);
    }

    public void atualizarUsuario(Long id, UsuarioRequestBody usuarioBody) {
        UsuarioModel usuario = buscarUsuario(id);

        if (usuarioBody.getNome() != null) {
            usuario.setNome(usuarioBody.getNome());
        }

        if (usuarioBody.getEmail() != null) {
            usuario.setEmail(usuarioBody.getEmail());
        }

        if (usuarioBody.getSenha() != null) {
            usuario.setSenha(usuarioBody.getSenha());
        }

        if (usuarioBody.getEndereco() != null) {
            EnderecoModel endereco = enderecoService.buscarEndereco(usuarioBody.getEndereco());
            usuario.setEndereco(endereco);
        }

        salvarUsuario(usuario);
    }

}
