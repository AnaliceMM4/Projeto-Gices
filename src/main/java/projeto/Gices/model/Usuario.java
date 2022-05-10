package projeto.Gices.model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author analice
 */
@Entity
public class Usuario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codUsuario", nullable = false, unique = true)
    private Integer codUsuario;
    private String nome;
    private String telefone;
    private String email;
 
    //Neste modelo, poderá haver a necessidade de roles -- userRoles
    
    public Usuario() {
    }

    public Usuario(int codUsuario, String nome, String telefone, String email) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

