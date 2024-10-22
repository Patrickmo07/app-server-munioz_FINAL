package pe.edu.cibertec.app_server_munioz.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    private String codigo;
    private String email;
    private String password;
    private String activo;

}
