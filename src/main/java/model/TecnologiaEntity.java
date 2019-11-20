package model;

import javax.persistence.*;

@Entity
@Table(name = "tecnologia", schema = "cinema")
public class TecnologiaEntity {
    @Id
    @Column(name = "tecnologia_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tecnologiaId;

    @Basic
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Basic
    @Column(name = "descricao", nullable = true, length = -1)
    private String descricao;

    public Long getTecnologiaId() {
        return tecnologiaId;
    }

    public void setTecnologiaId(Long tecnologiaId) {
        this.tecnologiaId = tecnologiaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TecnologiaEntity that = (TecnologiaEntity) o;

        if (tecnologiaId != null ? !tecnologiaId.equals(that.tecnologiaId) : that.tecnologiaId != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tecnologiaId != null ? tecnologiaId.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return nome;
    }
}
