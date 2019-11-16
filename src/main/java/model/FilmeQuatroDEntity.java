package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "FilmeQuatroD", schema = "cinema", catalog = "")
public class FilmeQuatroDEntity {
    private String filmeQuatroDId;
    private BigDecimal valorPoltrona;
    private BigDecimal valorPoltronaInteligente;
    private Byte poltrona;

    @Id
    @Column(name = "filme_quatro_d_id", nullable = false)
    public String getFilmeQuatroDId() {
        return filmeQuatroDId;
    }

    public void setFilmeQuatroDId(String filmeQuatroDId) {
        this.filmeQuatroDId = filmeQuatroDId;
    }

    @Basic
    @Column(name = "valor_poltrona", nullable = true, precision = 2)
    public BigDecimal getValorPoltrona() {
        return valorPoltrona;
    }

    public void setValorPoltrona(BigDecimal valorPoltrona) {
        this.valorPoltrona = valorPoltrona;
    }

    @Basic
    @Column(name = "valor_poltrona_inteligente", nullable = true, precision = 2)
    public BigDecimal getValorPoltronaInteligente() {
        return valorPoltronaInteligente;
    }

    public void setValorPoltronaInteligente(BigDecimal valorPoltronaInteligente) {
        this.valorPoltronaInteligente = valorPoltronaInteligente;
    }

    @Basic
    @Column(name = "poltrona", nullable = true)
    public Byte getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Byte poltrona) {
        this.poltrona = poltrona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmeQuatroDEntity that = (FilmeQuatroDEntity) o;

        if (filmeQuatroDId != null ? !filmeQuatroDId.equals(that.filmeQuatroDId) : that.filmeQuatroDId != null)
            return false;
        if (valorPoltrona != null ? !valorPoltrona.equals(that.valorPoltrona) : that.valorPoltrona != null)
            return false;
        if (valorPoltronaInteligente != null ? !valorPoltronaInteligente.equals(that.valorPoltronaInteligente) : that.valorPoltronaInteligente != null)
            return false;
        if (poltrona != null ? !poltrona.equals(that.poltrona) : that.poltrona != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmeQuatroDId != null ? filmeQuatroDId.hashCode() : 0;
        result = 31 * result + (valorPoltrona != null ? valorPoltrona.hashCode() : 0);
        result = 31 * result + (valorPoltronaInteligente != null ? valorPoltronaInteligente.hashCode() : 0);
        result = 31 * result + (poltrona != null ? poltrona.hashCode() : 0);
        return result;
    }
}
