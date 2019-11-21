package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Sessao", schema = "cinema")
public class SessaoEntity {
    @Id
    @Column(name = "sessao_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessaoId;

    @Basic
    @Column(name = "sala_id", nullable = false)
    private Long salaId;

    @Basic
    @Column(name = "filme_id", nullable = false)
    private Long filmeId;

    @Basic
    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;

    @Basic
    @Column(name = "data_fim", nullable = false)
    private Date dataFim;

    @Basic
    @Column(name = "hora", nullable = false)
    private Time hora;

    @Basic
    @Column(name = "valor", nullable = false, precision = 2)
    private BigDecimal valor;

    @Basic
    @Column(name = "legendado", nullable = true)
    private Boolean legendado;

    @Basic
    @Column(name = "tecnologia_id", nullable = true)
    private Long tecnologiaId;

    public Long getSessaoId() {
        return sessaoId;
    }

    public void setSessaoId(Long sessaoId) {
        this.sessaoId = sessaoId;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Boolean getLegendado() {
        return legendado;
    }

    public void setLegendado(Boolean legendado) {
        this.legendado = legendado;
    }

    public Long getSalaId() {
        return salaId;
    }

    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }

    public Long getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Long filmeId) {
        this.filmeId = filmeId;
    }

    public Long getTecnologiaId() {
        return tecnologiaId;
    }

    public void setTecnologiaId(Long tecnologiaId) {
        this.tecnologiaId = tecnologiaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessaoEntity that = (SessaoEntity) o;

        if (sessaoId != null ? !sessaoId.equals(that.sessaoId) : that.sessaoId != null) return false;
        if (dataInicio != null ? !dataInicio.equals(that.dataInicio) : that.dataInicio != null) return false;
        if (dataFim != null ? !dataFim.equals(that.dataFim) : that.dataFim != null) return false;
        if (hora != null ? !hora.equals(that.hora) : that.hora != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessaoId != null ? sessaoId.hashCode() : 0;
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode() : 0);
        result = 31 * result + (hora != null ? hora.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        return result;
    }
}
