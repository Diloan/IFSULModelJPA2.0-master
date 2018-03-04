/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ASUSX451
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_venda", strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    private Double valorTotal;
    private Integer parcelas;
    private PessoaFisica pessoaFisica;

    public Venda() {
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
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the parcelas
     */
    public Integer getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * @return the pessoaFisica
     */
    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    /**
     * @param pessoaFisica the pessoaFisica to set
     */
    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
 
    
}
