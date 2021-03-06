package br.sp.unifae.cris.comp7.model;
// Generated 01/05/2017 22:04:39 by Hibernate Tools 4.3.1


import br.sp.unifae.cris.comp7.model.dao.DAOCliente;
import br.sp.unifae.cris.comp7.utils.excecao.MinhaExcecao;
import br.sp.unifae.cris.comp7.utils.excecao.TiposDeMinhaExcecao;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer id;
     private Estado estado;
     private String nome;
     private String fisicaOuJuridica;
     private String cpfOuCnpj;
     private String endereco;
     private String cidade;
     private Set vendas = new HashSet(0);

    public Cliente() {
    }

    public Cliente(Estado estado, String nome, String fisicaOuJuridica, String cpfOuCnpj, String endereco, String cidade, Set vendas) throws Exception {
       setEstado(estado);
       setNome(nome);
       setFisicaOuJuridica(fisicaOuJuridica);
       setCpfOuCnpj(cpfOuCnpj);
       setEndereco(endereco);
       setCidade(cidade);
       setVendas(vendas);
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) throws Exception {
        if(id < 0)
            new MinhaExcecao(TiposDeMinhaExcecao.ValorMenorQueZero,"Id");
        this.id = id;
    }
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) throws Exception {
        if(nome == null || nome.isEmpty() || "".equals(nome)){
            new MinhaExcecao(TiposDeMinhaExcecao.CampoVazio,"Nome");
        }
        this.nome = nome;
    }
    public String getFisicaOuJuridica() {
        return this.fisicaOuJuridica;
    }
    
    public void setFisicaOuJuridica(String fisicaOuJuridica) throws Exception {
        if(fisicaOuJuridica == null || fisicaOuJuridica.isEmpty() || "".equals(fisicaOuJuridica)){
            new MinhaExcecao(TiposDeMinhaExcecao.CampoVazio,"Pessoa Fisica ou Juridica");
        }
        this.fisicaOuJuridica = fisicaOuJuridica;
    }
    public String getCpfOuCnpj() {
        return this.cpfOuCnpj;
    }
    
    public void setCpfOuCnpj(String cpfOuCnpj) throws Exception {
        if(cpfOuCnpj == null || cpfOuCnpj.isEmpty() || "".equals(cpfOuCnpj)) {
            new MinhaExcecao(TiposDeMinhaExcecao.CampoVazio,"CPF ou CNPJ");
        }
        this.cpfOuCnpj = cpfOuCnpj;
    }
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) throws Exception {
        if(endereco == null || endereco.isEmpty() || "".equals(endereco)){
            new MinhaExcecao(TiposDeMinhaExcecao.CampoVazio, "Endereco");
        }
        this.endereco = endereco;
    }
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) throws Exception {
        if(cidade == null || cidade.isEmpty() || "".equals(cidade)){
            new MinhaExcecao(TiposDeMinhaExcecao.CampoVazio, "Cidade");
        }
        this.cidade = cidade;
    }
    public Set getVendas() {
        return this.vendas;
    }
    
    public void setVendas(Set vendas) {
        this.vendas = vendas;
    }
    
    public void armazenar() {
        DAOCliente daoCliente = new DAOCliente();
        daoCliente.armazenar(this);
    }

    public void alterar() {
        DAOCliente daoCliente = new DAOCliente();
        daoCliente.alterar(this);
    }

    public void excluir() {
        DAOCliente daoCliente = new DAOCliente();
        daoCliente.excluir(this);
    }

    public List listar() {
        DAOCliente daoCliente = new DAOCliente();
        return daoCliente.listar();
    }
}


