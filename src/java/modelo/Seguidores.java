/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "seguidores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguidores.findAll", query = "SELECT s FROM Seguidores s")
    , @NamedQuery(name = "Seguidores.findByIdSeguidor", query = "SELECT s FROM Seguidores s WHERE s.idSeguidor = :idSeguidor")})
public class Seguidores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSeguidor")
    private Integer idSeguidor;
    @JoinColumn(name = "usuario_username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Usuario usuarioUsername;

    public Seguidores() {
    }

    public Seguidores(Integer idSeguidor) {
        this.idSeguidor = idSeguidor;
    }

    public Integer getIdSeguidor() {
        return idSeguidor;
    }

    public void setIdSeguidor(Integer idSeguidor) {
        this.idSeguidor = idSeguidor;
    }

    public Usuario getUsuarioUsername() {
        return usuarioUsername;
    }

    public void setUsuarioUsername(Usuario usuarioUsername) {
        this.usuarioUsername = usuarioUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeguidor != null ? idSeguidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguidores)) {
            return false;
        }
        Seguidores other = (Seguidores) object;
        if ((this.idSeguidor == null && other.idSeguidor != null) || (this.idSeguidor != null && !this.idSeguidor.equals(other.idSeguidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Seguidores[ idSeguidor=" + idSeguidor + " ]";
    }
    
}
