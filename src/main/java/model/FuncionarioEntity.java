package model;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Funcionario", schema = "cinema")
public class FuncionarioEntity implements Serializable {

    @Id
    @Column(name = "funcionario_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioId;

    @Basic
    @Column(name = "pessoa_id", nullable = false, length = 50)
    private Long pessoaId;

    @Basic
    @Column(name = "usuario", unique = true, nullable = false, length = 50)
    private String usuario;

    @Basic
    @Column(name = "senha", nullable = false, length = 50)
    @ColumnTransformer(write = "MD5(?)")
    private String senha;

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
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

        FuncionarioEntity that = (FuncionarioEntity) o;

        if (funcionarioId != null ? !funcionarioId.equals(that.funcionarioId) : that.funcionarioId != null)
            return false;
        if (pessoaId != null ? !pessoaId.equals(that.pessoaId) : that.pessoaId != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (senha != null ? !senha.equals(that.senha) : that.senha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = funcionarioId != null ? funcionarioId.hashCode() : 0;
        result = 31 * result + (pessoaId != null ? pessoaId.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ID:" + funcionarioId + " | PessoaID: " + pessoaId;
    }
}
