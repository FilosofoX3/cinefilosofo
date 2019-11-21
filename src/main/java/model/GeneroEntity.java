package model;

import javax.persistence.*;

@Entity
@Table(name = "Genero", schema = "cinema")
public class GeneroEntity {
    @Id
    @Column(name = "genero_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generoId;
    private String nome;

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
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

        GeneroEntity that = (GeneroEntity) o;

        if (generoId != null ? !generoId.equals(that.generoId) : that.generoId != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = generoId != null ? generoId.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return nome;
    }
}
