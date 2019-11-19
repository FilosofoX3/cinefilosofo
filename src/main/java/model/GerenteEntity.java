package model;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@Table(name = "Gerente", schema = "cinema")
public class GerenteEntity {
    @Id
    @Column(name = "gerente_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gerenteId;

    @Basic
    @Column(name = "funcionario_id", nullable = false)
    private Long funcionarioId;

    @Basic
    @Column(name = "usuario", nullable = false, length = 35)
    private String usuario;

    @Basic
    @Column(name = "senha", nullable = false, length = 35)
    @ColumnTransformer(write = "MD5(?)")
    private String senha;

    public Long getGerenteId() {
        return gerenteId;
    }

    public void setGerenteId(Long gerenteId) {
        this.gerenteId = gerenteId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GerenteEntity that = (GerenteEntity) o;

        if (gerenteId != null ? !gerenteId.equals(that.gerenteId) : that.gerenteId != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (senha != null ? !senha.equals(that.senha) : that.senha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gerenteId != null ? gerenteId.hashCode() : 0;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        return result;
    }
}
