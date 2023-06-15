package ec.edu.espe.examenandresnoboa.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "seg_usuario_perfil")
public class UsuarioPerfil {
    @EmbeddedId
    private UsuarioPerfilPK id;

    @MapsId("codUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COD_USUARIO", nullable = false)
    private Usuario codUsuario;

    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;

    @Column(name = "ES_ACTIVO", nullable = false)
    private Boolean esActivo = false;

    @Column(name = "VERSION")
    private Integer version;


    public UsuarioPerfil(UsuarioPerfilPK id) {
        this.id = id;
    }

    public UsuarioPerfil() {
    }

    public UsuarioPerfilPK getId() {
        return id;
    }

    public void setId(UsuarioPerfilPK id) {
        this.id = id;
    }

    public Usuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuario codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SegUsuarioPerfil{" +
                "id=" + id +
                ", codUsuario=" + codUsuario +
                ", fechaCreacion=" + fechaCreacion +
                ", esActivo=" + esActivo +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPerfil that = (UsuarioPerfil) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}