package br.sp.unifae.cris.comp7.model;
// Generated 01/05/2017 22:04:39 by Hibernate Tools 4.3.1


import br.sp.unifae.cris.comp7.model.dao.DAOEstado;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Estado generated by hbm2java
 */
public class Estado  implements java.io.Serializable {


     private Integer id;
     private String sigla;
     private String nome;
     private Set fornecedors = new HashSet(0);
     private Set clientes = new HashSet(0);

    public Estado() {
    }

    public Estado(String sigla, String nome, Set fornecedors, Set clientes) {
       this.sigla = sigla;
       this.nome = nome;
       this.fornecedors = fornecedors;
       this.clientes = clientes;
    }
    
    public Estado(int id, String sigla, String nome)
    {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSigla() {
        return this.sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set getFornecedors() {
        return this.fornecedors;
    }
    
    public void setFornecedors(Set fornecedors) {
        this.fornecedors = fornecedors;
    }
    public Set getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Set clientes) {
        this.clientes = clientes;
    }

    public List lista(){
        DAOEstado daoEstado = new DAOEstado();
        return daoEstado.listar();
    }


}


