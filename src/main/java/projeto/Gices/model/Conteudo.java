package projeto.Gices.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author analice
 */
@Entity
public class Conteudo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codConteudo;
    private String titulo;
    private String texto;
    @OneToOne
    @JoinColumn(name = "administrator_id", referencedColumnName = "codAdministrator")
    private Administrator administrator;
    @ManyToMany(mappedBy = "conteudos")
    private List<Administrator> administrators;

    public Conteudo() {
    }

    public Conteudo(int codConteudo, String titulo, String texto) {
        this.codConteudo = codConteudo;
        this.titulo = titulo;
        this.texto = texto;
    }

    public int getCodConteudo() {
        return codConteudo;
    }

    public void setCodConteudo(int codConteudo) {
        this.codConteudo = codConteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
    
}
