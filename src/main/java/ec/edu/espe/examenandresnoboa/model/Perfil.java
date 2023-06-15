package ec.edu.espe.examenandresnoboa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "seg_perfil")
public class Perfil {
    @Id
    @Column(name = "COD_PERFIL", nullable = false, length = 8)
    private String codPerfil;

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    @Column(name = "VERSION")
    private Long version;

    public Perfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public Perfil() {
    }

    public String getCodPerfil() {
        return codPerfil;
    }


    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SegPerfil{" +
                "codPerfil='" + codPerfil + '\'' +
                ", nombre='" + nombre + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return codPerfil.equals(perfil.codPerfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPerfil);
    }
}