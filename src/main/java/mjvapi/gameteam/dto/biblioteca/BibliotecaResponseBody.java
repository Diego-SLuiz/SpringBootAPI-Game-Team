package mjvapi.gameteam.dto.biblioteca;

import mjvapi.gameteam.dto.jogo.JogoResponseBody;
import mjvapi.gameteam.model.BibliotecaModel;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaResponseBody {
    private Long id;
    private Integer quantidadeJogos;
    private List<JogoResponseBody> jogos;

    public static BibliotecaResponseBody converterEmDto(BibliotecaModel biblioteca) {
        BibliotecaResponseBody bibliotecaDto = new BibliotecaResponseBody();
        bibliotecaDto.setId(biblioteca.getId());
        bibliotecaDto.setQuantidadeJogos(biblioteca.getQuantidadeJogos());
        bibliotecaDto.setJogos(JogoResponseBody.converterEmListaDto(biblioteca.getJogos()));

        return bibliotecaDto;
    }

    public static List<BibliotecaResponseBody> converterEmListaDto(List<BibliotecaModel> bibliotecas) {
        ArrayList<BibliotecaResponseBody> bibliotecasDto = new ArrayList<BibliotecaResponseBody>();

        for (BibliotecaModel biblioteca: bibliotecas) {
            bibliotecasDto.add(BibliotecaResponseBody.converterEmDto(biblioteca));
        }

        return bibliotecasDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeJogos() {
        return quantidadeJogos;
    }

    public void setQuantidadeJogos(Integer quantidadeJogos) {
        this.quantidadeJogos = quantidadeJogos;
    }

    public List<JogoResponseBody> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoResponseBody> jogos) {
        this.jogos = jogos;
    }

}
