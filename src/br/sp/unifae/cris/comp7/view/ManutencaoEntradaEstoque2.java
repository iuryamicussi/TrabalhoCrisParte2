/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.view;

import br.sp.unifae.cris.comp7.model.Entrada;
import br.sp.unifae.cris.comp7.model.Produto;
import br.sp.unifae.cris.comp7.utils.Generica;
import br.sp.unifae.cris.comp7.utils.interfaces.ITela;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Administrador
 */
public class ManutencaoEntradaEstoque2 extends Template implements ITela {
    
    //<editor-fold defaultstate="collapsed" desc="Variáveis e Campos da Tela">
    private List registros = null;

    JLabel jLabelEntradaCodigo;
    JLabel jLabelEntradaFornecedor;
    JLabel jLabelEntradaValorTotal;
    
    JLabel jLabelProdutoCodigo;
    JLabel jLabelProdutoQuantidade;
    JLabel jLabelProdutoValorUnitario;
    JLabel jLabelProdutoValorTotal;

    JTextField jTextFieldEntradaCodigo;
    
    JTextField jTextFieldEntradaFornecedor;
    JTextField jTextFieldEntradaFornecedorNome;
    JButton jButtonFornecedorPesquisa;
    
    JFormattedTextField jFormattedTextFieldEntradaValorTotal;
    
    JTextField jTextFieldProdutoCodigo;
    JTextField jTextFieldProdutoNome;
    JButton jButtonProdutoPesquisa;
    
    JFormattedTextField jFormattedTextFieldProdutoQuantidade;
    JFormattedTextField jFormattedTextFieldProdutoValorUnitario;
    JFormattedTextField jFormattedTextFieldProdutoValorTotal;
    
    JButton jButtonProdutoAdicionar;
    JTable jTableProdutos;

    JPanel jPanelProdutos;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    ManutencaoEntradaEstoque2() {
        DesenharTela();
        this.setVisible(true);
//        PopularListaDeRegistros();
//        
//        Object obj = new Entrada();
//        this.setClasse(obj);
//        this.setVisible(true);
//
//        if (registros.size() > 0)
//            pesquisar();
//        else
//            cancelar();
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos Básicos">
    @Override
    public Object pesquisar() {
//        Object retorno = null;
//        retorno = super.pesquisar();
//        PreencherCampos(retorno);
//        return null;
        JOptionPane.showMessageDialog(null, "jPaneCampos : " + jPaneCampos.getSize() + 
                " super pane: " + jPanel.getSize() + 
                " super: " + super.getSize());
        return null;
    }
    
    @Override
    public void excluir(){
//        Produto produto = new Produto();
//        try{
//            produto.setId(Integer.parseInt(jTextFieldCodigo.getText()));
//            produto.excluir();
//            super.excluir();
//        }
//        catch(Exception ex)
//        {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
    }
    
    @Override
    public void salvar(){
        
//        Produto produto = new Produto();
//        try{
//            try{produto.setNome(jTextFieldNome.getText());}
//            catch(Exception ex){
//                jTextFieldNome.requestFocus();
//                throw ex;
//            }
//            try{produto.setPrecoCusto(Generica.stringConverterParaFloat(jFormattedTextFieldPrecoCusto.getText()));}
//            catch(Exception ex){
//                jFormattedTextFieldPrecoCusto.requestFocus();
//                throw ex;
//            }
//            try{produto.setPrecoVenda(Generica.stringConverterParaFloat(jFormattedTextFieldPrecoVenda.getText()));}
//            catch(Exception ex){
//                jFormattedTextFieldPrecoVenda.requestFocus();
//                throw ex;
//            }
//            try{produto.setEstoqueAnterior(Generica.stringConverterParaFloat(jFormattedTextFieldEstoqueAnterior.getText()));}
//            catch(Exception ex){
//                jFormattedTextFieldEstoqueAnterior.requestFocus();
//                throw ex;
//            }
//            try{produto.setEstoqueEntrada(Generica.stringConverterParaFloat(jFormattedTextFieldEstoqueEntrada.getText()));}
//            catch(Exception ex){
//                jFormattedTextFieldEstoqueEntrada.requestFocus();
//                throw ex;
//            }
//            try{produto.setEstoqueSaida(Generica.stringConverterParaFloat(jFormattedTextFieldEstoqueSaida.getText()));}
//            catch(Exception ex){
//                jFormattedTextFieldEstoqueSaida.requestFocus();
//                throw ex;
//            }
//            if(isNovo)
//                produto.armazenar();
//            else{
//                produto.setId(Integer.parseInt(jTextFieldCodigo.getText()));
//                produto.alterar();
//            }
//            super.salvar();
//        }
//        catch(Exception ex)
//        {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos da Tela">
    @Override
    public final void DesenharTela() {
        super.setSize(540,550);
        
        this.setTitle("Entrada de Produtos");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        jLabelEntradaCodigo = new JLabel("Código :");
        jLabelEntradaCodigo.setBounds(20, 20, 60, 20);
        jTextFieldEntradaCodigo = new JTextField("");
        jTextFieldEntradaCodigo.setBounds(120, 20, 55, 20);
        jTextFieldEntradaCodigo.setEditable(false);
        
        jLabelEntradaValorTotal = new JLabel("Total R$ :");
        jLabelEntradaValorTotal.setBounds(190, 20, 80, 20);
        jFormattedTextFieldEntradaValorTotal = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEntradaValorTotal.setBounds(280, 20, 120, 20);
        jFormattedTextFieldEntradaValorTotal.setEditable(false);

        jLabelEntradaFornecedor = new JLabel("Fornecedor :");
        jLabelEntradaFornecedor.setBounds(20, 60, 90, 20);
        jTextFieldEntradaFornecedor = new JTextField("");
        jTextFieldEntradaFornecedor.setBounds(120, 60, 60, 20);
        jTextFieldEntradaFornecedorNome = new JTextField("");
        jTextFieldEntradaFornecedorNome.setEditable(false);
        jTextFieldEntradaFornecedorNome.setBounds(190, 60, 280, 20);
        jButtonFornecedorPesquisa = new JButton(Generica.iconePesquisaEmTela());
        jButtonFornecedorPesquisa.setBounds(480, 50, 35, 35);
        
        jPanelProdutos = new JPanel();
        jPanelProdutos.setBorder(BorderFactory.createTitledBorder("Produtos"));
        jPanelProdutos.setBounds(20,100,500,350);
        jPanelProdutos.setLayout(new GroupLayout(jPanelProdutos));
        
        jLabelProdutoCodigo = new JLabel("Produto :");
        jLabelProdutoCodigo.setBounds(20,20,80,20);
        jTextFieldProdutoCodigo = new JTextField();
        jTextFieldProdutoCodigo.setBounds(110, 20, 60,20);
        jTextFieldProdutoNome = new JTextField();
        jTextFieldProdutoNome.setBounds(180,20,180,20);
        jButtonProdutoPesquisa = new JButton(Generica.iconePesquisaEmTela());
        jButtonProdutoPesquisa.setBounds(390, 10, 35, 35);
        
//        jLabelPrecoCusto = new JLabel("Preço Custo :");
//        jLabelPrecoCusto.setBounds(20, 100, 120, 20);
//        jFormattedTextFieldPrecoCusto = new JFormattedTextField(DecimalFormat.getInstance());
//        jFormattedTextFieldPrecoCusto.setBounds(130, 100, 80, 20);
//
//        jLabelPrecoVenda = new JLabel("Preço Venda :");
//        jLabelPrecoVenda.setBounds(20, 140, 120, 20);
//        jFormattedTextFieldPrecoVenda = new JFormattedTextField(DecimalFormat.getInstance());
//        jFormattedTextFieldPrecoVenda.setBounds(130, 140, 80, 20);
//
//        jPanelEstoque = new JPanel();
//        jPanelEstoque.setBorder(BorderFactory.createTitledBorder("Informações de Estoque"));
//        jPanelEstoque.setBounds(20, 180, 420, 150);
//        jPanelEstoque.setLayout(new GroupLayout(jPanelEstoque));
//
//        jLabelEstoqueAnterior = new JLabel("Anterior :");
//        jLabelEstoqueAnterior.setBounds(20, 20, 100, 30);
//        jFormattedTextFieldEstoqueAnterior = new JFormattedTextField(DecimalFormat.getInstance());
//        jFormattedTextFieldEstoqueAnterior.setBounds(100, 27, 80, 20);
//
//        jLabelEstoqueEntrada = new JLabel("Entradas :");
//        jLabelEstoqueEntrada.setBounds(20, 60, 100, 30);
//        jFormattedTextFieldEstoqueEntrada = new JFormattedTextField(DecimalFormat.getInstance());
//        jFormattedTextFieldEstoqueEntrada.setBounds(100, 65, 80, 20);
//        jFormattedTextFieldEstoqueEntrada.setEditable(false);
//
//        jLabelEstoqueSaida = new JLabel("Saídas :");
//        jLabelEstoqueSaida.setBounds(220, 60, 100, 30);
//        jFormattedTextFieldEstoqueSaida = new JFormattedTextField(DecimalFormat.getInstance());
//        jFormattedTextFieldEstoqueSaida.setBounds(290, 65, 80, 20);
//        jFormattedTextFieldEstoqueSaida.setEditable(false);
//
//        jLabelEstoqueAtual = new JLabel("Atual :");
//        jLabelEstoqueAtual.setBounds(220, 110, 100, 30);
//        jFormattedTextFieldEstoqueAtual = new JFormattedTextField(DecimalFormat.getInstance());
//        jFormattedTextFieldEstoqueAtual.setBounds(290, 115, 80, 20);
//        jFormattedTextFieldEstoqueAtual.setEditable(false);
//
//        jPanelEstoque.add(jLabelEstoqueAnterior);
//        jPanelEstoque.add(jFormattedTextFieldEstoqueAnterior);
//
//        jPanelEstoque.add(jLabelEstoqueEntrada);
//        jPanelEstoque.add(jFormattedTextFieldEstoqueEntrada);
//
//        jPanelEstoque.add(jLabelEstoqueSaida);
//        jPanelEstoque.add(jFormattedTextFieldEstoqueSaida);
//
//        jPanelEstoque.add(jLabelEstoqueAtual);
//        jPanelEstoque.add(jFormattedTextFieldEstoqueAtual);

        jPanelProdutos.add(jLabelProdutoCodigo);
        jPanelProdutos.add(jTextFieldProdutoCodigo);
        jPanelProdutos.add(jTextFieldProdutoNome);
        jPanelProdutos.add(jButtonProdutoPesquisa);
        
        this.jPaneCampos.add(jLabelEntradaCodigo);
        this.jPaneCampos.add(jTextFieldEntradaCodigo);
        
        this.jPaneCampos.add(jLabelEntradaValorTotal);
        this.jPaneCampos.add(jFormattedTextFieldEntradaValorTotal);

        this.jPaneCampos.add(jLabelEntradaFornecedor);
        this.jPaneCampos.add(jTextFieldEntradaFornecedor);
        this.jPaneCampos.add(jTextFieldEntradaFornecedorNome);
        this.jPaneCampos.add(jButtonFornecedorPesquisa);
        
        this.jPaneCampos.add(jPanelProdutos);

//        this.jPaneCampos.add(jLabelPrecoCusto);
//        this.jPaneCampos.add(jFormattedTextFieldPrecoCusto);
//
//        this.jPaneCampos.add(jLabelPrecoVenda);
//        this.jPaneCampos.add(jFormattedTextFieldPrecoVenda);
//
//        this.jPaneCampos.add(jLabelPrecoVenda);
//        this.jPaneCampos.add(jFormattedTextFieldPrecoVenda);
//
//        this.jPaneCampos.add(jPanelEstoque);
    }

    @Override
    public void PreencherCampos(Object obj) {
        Entrada entrada;
        Generica.Limpar_Campos_Tela(this.jPaneCampos,obj==null);
        if (obj == null) {
            return;
        }
        for (Iterator it = registros.iterator(); it.hasNext();) {
            entrada = (Entrada) it.next();
            if (entrada.getId().equals(obj)) {
//                jTextFieldCodigo.setText(produto.getId().toString());
//                jTextFieldNome.setText(produto.getNome());
//                jFormattedTextFieldPrecoCusto.setText(Generica.floatConverterParaString(produto.getPrecoCusto()));
//                jFormattedTextFieldPrecoVenda.setText(Generica.floatConverterParaString(produto.getPrecoVenda()));
//                jFormattedTextFieldEstoqueAnterior.setText(Generica.floatConverterParaString(produto.getEstoqueAnterior()));
//                jFormattedTextFieldEstoqueEntrada.setText(Generica.floatConverterParaString(produto.getEstoqueEntrada()));
//                jFormattedTextFieldEstoqueSaida.setText(Generica.floatConverterParaString(produto.getEstoqueSaida()));
//                jFormattedTextFieldEstoqueAtual.setText(Generica.floatConverterParaString(produto.getEstoqueAtual()));
            }
        }
    }
    
    @Override
    public void PopularListaDeRegistros() {
        Entrada obj = new Entrada();
//        registros = obj.listar();
    }
    // </editor-fold>
}
