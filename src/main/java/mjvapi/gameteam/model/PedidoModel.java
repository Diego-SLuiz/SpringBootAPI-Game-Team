package mjvapi.gameteam.model;

import mjvapi.gameteam.enumeration.StatusPedido;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido status;

    @OneToMany
    @JoinColumn(name = "pedido_id")
    private List<PedidoItem> listaCestas = new ArrayList<PedidoItem>();

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<PedidoItem> getListaCestas() {
        return listaCestas;
    }

    public void setListaCestas(List<PedidoItem> listaCestas) {
        this.listaCestas = listaCestas;
    }
}
