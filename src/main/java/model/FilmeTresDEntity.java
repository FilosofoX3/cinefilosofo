package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "FilmeTresD", schema = "cinema", catalog = "")
public class FilmeTresDEntity {
    private String filmeTresDId;
    private BigDecimal valorOculosAtivo;
    private BigDecimal valorOculosPassivo;
    private Byte oculosAtivo;

    @Id
    @Column(name = "filme_tres_d_id", nullable = false)
    public String getFilmeTresDId() {
        return filmeTresDId;
    }

    public void setFilmeTresDId(String filmeTresDId) {
        this.filmeTresDId = filmeTresDId;
    }

    @Basic
    @Column(name = "valor_oculos_ativo", nullable = true, precision = 2)
    public BigDecimal getValorOculosAtivo() {
        return valorOculosAtivo;
    }

    public void setValorOculosAtivo(BigDecimal valorOculosAtivo) {
        this.valorOculosAtivo = valorOculosAtivo;
    }

    @Basic
    @Column(name = "valor_oculos_passivo", nullable = true, precision = 2)
    public BigDecimal getValorOculosPassivo() {
        return valorOculosPassivo;
    }

    public void setValorOculosPassivo(BigDecimal valorOculosPassivo) {
        this.valorOculosPassivo = valorOculosPassivo;
    }

    @Basic
    @Column(name = "oculos_ativo", nullable = true)
    public Byte getOculosAtivo() {
        return oculosAtivo;
    }

    public void setOculosAtivo(Byte oculosAtivo) {
        this.oculosAtivo = oculosAtivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmeTresDEntity that = (FilmeTresDEntity) o;

        if (filmeTresDId != null ? !filmeTresDId.equals(that.filmeTresDId) : that.filmeTresDId != null) return false;
        if (valorOculosAtivo != null ? !valorOculosAtivo.equals(that.valorOculosAtivo) : that.valorOculosAtivo != null)
            return false;
        if (valorOculosPassivo != null ? !valorOculosPassivo.equals(that.valorOculosPassivo) : that.valorOculosPassivo != null)
            return false;
        if (oculosAtivo != null ? !oculosAtivo.equals(that.oculosAtivo) : that.oculosAtivo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmeTresDId != null ? filmeTresDId.hashCode() : 0;
        result = 31 * result + (valorOculosAtivo != null ? valorOculosAtivo.hashCode() : 0);
        result = 31 * result + (valorOculosPassivo != null ? valorOculosPassivo.hashCode() : 0);
        result = 31 * result + (oculosAtivo != null ? oculosAtivo.hashCode() : 0);
        return result;
    }
}
