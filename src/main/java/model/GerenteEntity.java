package model;

import javax.persistence.*;

@Entity
@Table(name = "Gerente", schema = "cinema", catalog = "")
public class GerenteEntity {
    private String gerenteId;
    private String usuario;
    private String senha;

    @Id
    @Column(name = "gerente_id", nullable = false)
    public String getGerenteId() {
        return gerenteId;
    }

    public void setGerenteId(String gerenteId) {
        this.gerenteId = gerenteId;
    }

    @Basic
    @Column(name = "usuario", nullable = true, length = 35)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "senha", nullable = true, length = 35)
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
