package model;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "Bilhete", schema = "cinema")
public class BilheteEntity {
    @Id
    @Column(name = "bilhete_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bilheteId;

    @Basic
    @Column(name = "sessao_id", nullable = false)
    private Long sessaoId;

    @Basic
    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Basic
    @Column(name = "vendedor_id", nullable = false)
    private Long vendedorId;

    @Basic
    @Column(name = "data", nullable = false)
    private Date data;

    @Basic
    @Column(name = "meia_entrada", nullable = false)
    private Boolean meiaEntrada;

    public Long getBilheteId() {
        return bilheteId;
    }

    public void setBilheteId(Long bilheteId) {
        this.bilheteId = bilheteId;
    }

    public Long getSessaoId() {
        return sessaoId;
    }

    public void setSessaoId(Long sessaoId) {
        this.sessaoId = sessaoId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getMeiaEntrada() {
        return meiaEntrada;
    }

    public void setMeiaEntrada(Boolean meiaEntrada) {
        this.meiaEntrada = meiaEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BilheteEntity that = (BilheteEntity) o;

        if (bilheteId != null ? !bilheteId.equals(that.bilheteId) : that.bilheteId != null) return false;
        if (clienteId != null ? !clienteId.equals(that.clienteId) : that.clienteId != null) return false;
        if (vendedorId != null ? !vendedorId.equals(that.vendedorId) : that.vendedorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bilheteId != null ? bilheteId.hashCode() : 0;
        result = 31 * result + (clienteId != null ? clienteId.hashCode() : 0);
        result = 31 * result + (vendedorId != null ? vendedorId.hashCode() : 0);
        return result;
    }
}