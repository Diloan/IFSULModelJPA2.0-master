/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author ASUSX451
 */
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable{
    @NotNull(message = "A ie não poder ser nula")
    @NotBlank(message = "A ie não pode ser em branco")
    @Length(max = 20, message = "A ie não pode ter mais de {max} caracteres")
    @Column(name = "ie", length = 20, nullable = false)
    private String ie;
    @NotNull(message = "O cnpj não poder ser nulo")
    @NotBlank(message = "O cnpj não pode ser em branco")
    @Length(max = 20, message = "O cnpj não pode ter mais de {max} caracteres")
    @Column(name = "cnpj", length = 20, nullable = false)
    private String cnpj;

    public PessoaJuridica() {
    }
    
    /**
     * @return the ie
     */
    public String getIe() {
        return ie;
    }

    /**
     * @param ie the ie to set
     */
    public void setIe(String ie) {
        this.ie = ie;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
