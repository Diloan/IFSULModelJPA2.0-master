/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Diloan Silva
 * @email diloan.silva@gmail.com
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {

    @NotNull(message = "O RG não poder ser nulo")
    @NotBlank(message = "O RG não pode ser em branco")
    @Length(max = 10, message = "O RG não pode ter mais de {max} caracteres")
    @Column(name = "RG", length = 10, nullable = false)
    private String rg;
    @NotNull(message = "O CPF não poder ser nulo")
    @NotBlank(message = "O CPF não pode ser em branco")
    @Length(max = 14, message = "O CPF não pode ter mais de {max} caracteres")
    @CPF(message = "O CPF deve ser válido")
    @Column(name = "CPF", length = 14, nullable = false)
    private String cpf;
    @NotNull(message = "O nascimneto não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    @NotNull(message = "O nome de usuario não poder ser nulo")
    @NotBlank(message = "O nome de usuario não pode ser em branco")
    @Length(max = 30, message = "O nome de usuario não pode ter mais de {max} caracteres")
    @Column(name = "nome_usuario", length = 30, nullable = false, unique = true)
    private String nomeUsuario;
    @NotNull(message = "A senha não poder ser nula")
    @NotBlank(message = "O A senha não pode ser em branco")
    @Length(max = 10, message = "A senha não pode ter mais de {max} caracteres")
    @Column(name = "senha", length = 10, nullable = false)
    private String senha;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "desejos",
            joinColumns
            = @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"pessoa_fisica", "produto"})})
    private List<Produto> desejos = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permissoes",
            joinColumns
            = @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"nome_usuario", "permissao"})})
    private List<Permissao> permissoes = new ArrayList<>();

    public PessoaFisica() {
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nascimento
     */
    public Calendar getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the desejos
     */
    public List<Produto> getDesejos() {
        return desejos;
    }

    /**
     * @param desejos the desejos to set
     */
    public void setDesejos(List<Produto> desejos) {
        this.desejos = desejos;
    }

    /**
     * @return the permissoes
     */
    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    /**
     * @param permissoes the permissoes to set
     */
    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

}
