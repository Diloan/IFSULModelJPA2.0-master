/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Diloan Silva
 * @email diloan.silva@gmail.com
 */
@Entity
@Table(name = "tipo_endereco")
public class TipoEndereco implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_tipo_endereco", sequenceName = "seq_tipo_endereco_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_tipo_endereco", strategy = GenerationType.IDENTITY)
    private Integer id;
    @Length(max = 50, message = "A descrição não pode ter mais de {max} caracteres")
    @NotBlank(message = "A descrição deve ser informada")
    @NotNull(message = "A descrição não pode ser nula")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;

    public TipoEndereco() {
    }

    
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoEndereco other = (TipoEndereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
