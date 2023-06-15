package ec.edu.espe.examenandresnoboa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioPerfilPK implements Serializable {
    @Column(name = "COD_USUARIO", nullable = false)
    private Integer codUsuario;

    @Column(name = "COD_PERFIL", nullable = false, length = 8)
    private String codPerfil;

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    @Override
    public String toString() {
        return "SegUsuarioPerfilPK{" +
                "codUsuario=" + codUsuario +
                ", codPerfil='" + codPerfil + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioPerfilPK entity = (UsuarioPerfilPK) o;
        return Objects.equals(this.codUsuario, entity.codUsuario) &&
                Objects.equals(this.codPerfil, entity.codPerfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUsuario, codPerfil);
    }

}