package br.sp.unifae.cris.comp7.model;
// Generated 01/05/2017 22:04:39 by Hibernate Tools 4.3.1



/**
 * EntradaProduto generated by hbm2java
 */
public class EntradaProduto  implements java.io.Serializable {


     private EntradaProdutoId id;
     private Entrada entrada;
     private Produto produto;
     private Float quantidade;
     private Float preco;

    public EntradaProduto() {
    }

	
    public EntradaProduto(EntradaProdutoId id, Entrada entrada) {
        this.id = id;
        this.entrada = entrada;
    }
    public EntradaProduto(EntradaProdutoId id, Entrada entrada, Produto produto, Float quantidade, Float preco) {
       this.id = id;
       this.entrada = entrada;
       this.produto = produto;
       this.quantidade = quantidade;
       this.preco = preco;
    }
   
    public EntradaProdutoId getId() {
        return this.id;
    }
    
    public void setId(EntradaProdutoId id) {
        this.id = id;
    }
    public Entrada getEntrada() {
        return this.entrada;
    }
    
    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Float getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
    public Float getPreco() {
        return this.preco;
    }
    
    public void setPreco(Float preco) {
        this.preco = preco;
    }




}

