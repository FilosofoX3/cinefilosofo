package model;

import javax.persistence.*;

@Entity
@Table(name = "Filme", schema = "cinema", catalog = "")
public class FilmeEntity {
    private String filmeId;
    private String titulo;
    private Byte duracaoMinutos;
    private Byte duracaoHoras;
    private Byte anoLancamento;

    @Id
    @Column(name = "filme_id", nullable = false)
    public String getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(String filmeId) {
        this.filmeId = filmeId;
    }

    @Basic
    @Column(name = "titulo", nullable = true, length = 35)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "duracao_minutos", nullable = true)
    public Byte getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Byte duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    @Basic
    @Column(name = "duracao_horas", nullable = true)
    public Byte getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(Byte duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Basic
    @Column(name = "ano_lancamento", nullable = true)
    public Byte getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Byte anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmeEntity that = (FilmeEntity) o;

        if (filmeId != null ? !filmeId.equals(that.filmeId) : that.filmeId != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (duracaoMinutos != null ? !duracaoMinutos.equals(that.duracaoMinutos) : that.duracaoMinutos != null)
            return false;
        if (duracaoHoras != null ? !duracaoHoras.equals(that.duracaoHoras) : that.duracaoHoras != null) return false;
        if (anoLancamento != null ? !anoLancamento.equals(that.anoLancamento) : that.anoLancamento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmeId != null ? filmeId.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (duracaoMinutos != null ? duracaoMinutos.hashCode() : 0);
        result = 31 * result + (duracaoHoras != null ? duracaoHoras.hashCode() : 0);
        result = 31 * result + (anoLancamento != null ? anoLancamento.hashCode() : 0);
        return result;
    }
}
