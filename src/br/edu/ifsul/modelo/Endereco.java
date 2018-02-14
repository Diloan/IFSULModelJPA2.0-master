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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author ASUSX451
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco", strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "O apelido não poder ser nulo")
    @NotBlank(message = "O apelido não pode ser em branco")
    @Length(max = 20, message = "O apelido não pode ter mais de {max} caracteres")
    @Column(name = "nickname", length = 20, nullable = false)
    private String nickName;
    @NotNull(message = "O endereço não poder ser nulo")
    @NotBlank(message = "O endereço não pode ser em branco")
    @Length(max = 50, message = "O endereço não pode ter mais de {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    @NotNull(message = "O número não poder ser nulo")
    @NotBlank(message = "O número não pode ser em branco")
    @Length(max = 10, message = "O número não pode ter mais de {max} caracteres")
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;
    @Length(max = 20, message = "O número não pode ter mais de {max} caracteres")
    @Column(name = "complemento", length = 20)
    private String complemento;
    @NotNull(message = "O cep não poder ser nulo")
    @NotBlank(message = "O cep não pode ser em branco")
    @Length(max = 10, message = "O cep não pode ter mais de {max} caracteres")
    @Column(name = "cep", length = 10, nullable = false)
    private String cep;
    @NotNull(message = "O bairro não poder ser nulo")
    @NotBlank(message = "O bairro não pode ser em branco")
    @Length(max = 25, message = "O bairro não pode ter mais de {max} caracteres")
    @Column(name = "bairro", length = 25, nullable = false)
    private String bairro;
    @Length(max = 30, message = "O referência não pode ter mais de {max} caracteres")
    @Column(name = "referencia", length = 30)
    private String referencia;
    @NotNull(message = "Pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_pessoa_id")
    private Pessoa pessoa;
    @NotNull(message = "O tipo de endereço não poder ser nulo")
    @ManyToOne
    @JoinColumn(name = "tipo_endereco", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_tipo_endereco_id")
    private TipoEndereco tipoEndereco;
    
    public Endereco() {
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
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the tipoEndereco
     */
    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    /**
     * @param tipoEndereco the tipoEndereco to set
     */
    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
    
    
    
}
