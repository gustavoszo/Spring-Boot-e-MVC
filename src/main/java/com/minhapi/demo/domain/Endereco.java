package com.minhapi.demo.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "enderecos")
@AttributeOverride(name = "id", column = 
@Column(name = "id_endereco"))
public class Endereco extends AbstractEntity<Long>{

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String logradouro;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String bairro;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String cidade;

    @NotNull(message = "{NotNull.endereco.uf}")
    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private UF uf;

    @NotBlank
    @Size(min = 9, max = 9, message = "{Size.endereco.cep}")
    @Column(nullable = false, length = 9)
    private String cep;

    @NotNull(message = "{NotNull.endereco.numero}")
    @Digits(integer = 5, fraction = 0)
    @Column(nullable = false, length = 5)
    private Integer numero;

    @Size(max = 255)
    private String complemento;

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public UF getUf() {
        return uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }


}
