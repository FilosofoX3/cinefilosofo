package model;

import javax.persistence.*;

@Entity
@Table(name = "Filme", schema = "cinema")
public class FilmeEntity {
    @Id
    @Column(name = "filme_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmeId;

    @Basic
    @Column(name = "genero_id", nullable = false, length = 35)
    private Long generoId;

    @Basic
    @Column(name = "classificacao_id", nullable = false, length = 35)
    private Long classificacaoId;

    @Basic
    @Column(name = "titulo", nullable = false, length = 35)
    private String titulo;

    @Basic
    @Column(name = "duracao_minutos", nullable = false)
    private int duracaoMinutos;

    @Basic
    @Column(name = "duracao_horas", nullable = false)
    private int duracaoHoras;

    @Basic
    @Column(name = "ano_lancamento", nullable = false)
    private int anoLancamento;

    public Long getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Long filmeId) {
        this.filmeId = filmeId;
    }

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }

    public Long getClassificacaoId() {
        return classificacaoId;
    }

    public void setClassificacaoId(Long classificacaoId) {
        this.classificacaoId = classificacaoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmeEntity that = (FilmeEntity) o;

        if (filmeId != null ? !filmeId.equals(that.filmeId) : that.filmeId != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (duracaoMinutos != 0 ? duracaoMinutos != that.duracaoMinutos : that.duracaoMinutos != 0)
            return false;
        if (duracaoHoras != 0 ? duracaoHoras != that.duracaoHoras : that.duracaoHoras != 0) return false;
        if (anoLancamento != 0 ? anoLancamento != that.anoLancamento : that.anoLancamento != 0)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmeId != null ? filmeId.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + duracaoMinutos;
        result = 31 * result + duracaoHoras;
        result = 31 * result + anoLancamento;
        return result;
    }
}
