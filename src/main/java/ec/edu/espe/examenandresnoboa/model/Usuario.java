package ec.edu.espe.examenandresnoboa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "seg_usuario")
public class Usuario {
    @Id
    @Column(name = "COD_USUARIO", nullable = false)
    private Integer id;

    @Column(name = "MAIL", nullable = false, length = 128)
    private String mail;

    @Column(name = "CLAVE", nullable = false, length = 64)
    private String clave;

    @Column(name = "NOMBRE", nullable = false, length = 128)
    private String nombre;

    @Column(name = "INTENTOS_FALLIDOS", precision = 8)
    private BigDecimal intentosFallidos;

    @Column(name = "SUELDO", nullable = false, precision = 8, scale = 2)
    private BigDecimal sueldo;

    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Column(name = "VERSION")
    private Long version;


    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(BigDecimal intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    @Override
    public String toString() {
        return "SegUsuario{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", clave='" + clave + '\'' +
                ", nombre='" + nombre + '\'' +
                ", intentosFallidos=" + intentosFallidos +
                ", sueldo=" + sueldo +
                ", fechaNacimiento=" + fechaNacimiento +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario that = (Usuario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}