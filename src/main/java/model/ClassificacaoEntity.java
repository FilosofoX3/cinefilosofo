package model;

import javax.persistence.*;

@Entity
@Table(name = "Classificacao", schema = "cinema", catalog = "")
public class ClassificacaoEntity {
    private String classificacaoId;
    private String nome;

    @Id
    @Column(name = "classificacao_id", nullable = false)
    public String getClassificacaoId() {
        return classificacaoId;
    }

    public void setClassificacaoId(String classificacaoId) {
        this.classificacaoId = classificacaoId;
    }

    @Basic
    @Column(name = "nome", nullable = true, length = 50)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassificacaoEntity that = (ClassificacaoEntity) o;

        if (classificacaoId != null ? !classificacaoId.equals(that.classificacaoId) : that.classificacaoId != null)
            return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classificacaoId != null ? classificacaoId.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
