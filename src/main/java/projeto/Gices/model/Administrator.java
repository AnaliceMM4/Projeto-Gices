package projeto.Gices.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author analice
 */
@Entity
public class Administrator implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codAdministrator;
    private String nome;
    private String login;
    private String email;
    private String senha;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "administrators_conteudos",
            joinColumns = @JoinColumn(
                    name = "administrator_id", referencedColumnName = "codAdministrator"),
            inverseJoinColumns = @JoinColumn(
                    name = "conteudos_id", referencedColumnName = "codConteudo"))
    private List<Conteudo> conteudos;

//ter a list de todos acima no construtor e os GET E SET   , List<Conteudo> conteudos   private List<Conteudo> conteudos;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Role> roles;

    public Administrator() {
    }

    public Administrator(int codAdministrator, String nome, String login, String email, String senha, List<Role> roles) {
        this.codAdministrator = codAdministrator;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.roles = roles;
    }

    public Administrator(int codAdministrator, String nome, String login, String email, String senha) {
        this.codAdministrator = codAdministrator;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }

    public Administrator(int codAdministrator, String nome, String login, String email, String senha, List<Conteudo> conteudos, List<Role> roles) { //List<Lives> lives) {
        this.codAdministrator = codAdministrator;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.conteudos = conteudos;
        this.roles = roles;
        //this.lives = lives;
    }

    public int getCodAdministrator() {
        return codAdministrator;
    }

    public void setCodAdministrator(int codAdministrator) {
        this.codAdministrator = codAdministrator;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /*public List<Lives> getLives() {
        return lives;
    }

    public void setLives(List<Lives> lives) {
        this.lives = lives;
    }*/
    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        roles.add(new Role("ROLE_ADMINISTRATOR"));
        return (Collection<? extends GrantedAuthority>) this.roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
