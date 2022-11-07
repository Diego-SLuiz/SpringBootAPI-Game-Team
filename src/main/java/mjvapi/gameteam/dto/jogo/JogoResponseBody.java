package mjvapi.gameteam.dto.jogo;

import mjvapi.gameteam.model.JogoModel;

import java.util.ArrayList;
import java.util.List;

public class JogoResponseBody {
    private Long id;
    private Long produto;

    public static JogoResponseBody converterEmDto(JogoModel jogo) {
        JogoResponseBody jogoDto = new JogoResponseBody();
        jogoDto.setId(jogo.getId());
        jogoDto.setProduto(jogo.getProduto().getId());

        return jogoDto;
    }

    public static List<JogoResponseBody> converterEmListaDto(List<JogoModel> jogos) {
        ArrayList<JogoResponseBody> jogosDto = new ArrayList<JogoResponseBody>();

        for (JogoModel jogo: jogos) {
            jogosDto.add(JogoResponseBody.converterEmDto(jogo));
        }

        return jogosDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

}
