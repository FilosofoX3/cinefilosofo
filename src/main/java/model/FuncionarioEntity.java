package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Funcionario", schema = "cinema", catalog = "")
public class FuncionarioEntity {
    private String funcionarioId;
    private String codigo;
    private String nome;
    private String email;
    private Date dataCadastro;

    @Id
    @Column(name = "funcionario_id", nullable = false)
    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    @Basic
    @Column(name = "codigo", nullable = true, length = 10)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "nome", nullable = true, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "data_cadastro", nullable = true)
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuncionarioEntity that = (FuncionarioEntity) o;

        if (funcionarioId != null ? !funcionarioId.equals(that.funcionarioId) : that.funcionarioId != null)
            return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (dataCadastro != null ? !dataCadastro.equals(that.dataCadastro) : that.dataCadastro != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = funcionarioId != null ? funcionarioId.hashCode() : 0;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dataCadastro != null ? dataCadastro.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "#" + funcionarioId + " / " + nome;
    }
}
