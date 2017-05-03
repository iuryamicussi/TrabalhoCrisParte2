/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.view;

import br.sp.unifae.cris.comp7.utils.Tela;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author iury
 */
public class CadastroProduto2 extends Template implements Tela {
    
    JLabel jLabelCodigo;
    JLabel jLabelNome;
    JLabel jLabelPrecoCusto;
    JLabel jLabelPrecoVenda;
    JLabel jLabelEstoqueAnterior;
    JLabel jLabelEstoqueEntrada;
    JLabel jLabelEstoqueSaida;
    JLabel jLabelEstoqueAtual;
    
    JTextField jTextFieldCodigo;
    JTextField jTextFieldNome;
    JFormattedTextField jFormattedTextFieldPrecoCusto;
    JFormattedTextField jFormattedTextFieldPrecoVenda;
    JFormattedTextField jFormattedTextFieldEstoqueAnterior;
    JFormattedTextField jFormattedTextFieldEstoqueEntrada;
    JFormattedTextField jFormattedTextFieldEstoqueSaida;
    JFormattedTextField jFormattedTextFieldEstoqueAtual;
    
    JPanel jPanelEstoque;
    
    CadastroProduto2(){
        DesenharTela();
        this.setVisible(true);
    }
    

    @Override
    public final void DesenharTela() {
        this.setTitle("Cadastro de Produtos");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        jLabelCodigo = new JLabel("Código :");
        jLabelCodigo.setBounds(20, 20, 60, 20);
        jTextFieldCodigo = new JTextField("");
        jTextFieldCodigo.setBounds(90,20,55, 20);
        jTextFieldCodigo.setEditable(false);
        
        jLabelNome = new JLabel("Nome :");
        jLabelNome.setBounds(20, 60, 60, 20);
        jTextFieldNome= new JTextField("");
        jTextFieldNome.setBounds(90, 60, 350, 20);
        
        jLabelPrecoCusto = new JLabel("Preço Custo :");
        jLabelPrecoCusto.setBounds(20, 100, 120, 20);
        jFormattedTextFieldPrecoCusto = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldPrecoCusto.setBounds(130,100,80, 20);
        
        jLabelPrecoVenda = new JLabel("Preço Venda :");
        jLabelPrecoVenda.setBounds(20, 140, 120, 20);
        jFormattedTextFieldPrecoVenda = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldPrecoVenda.setBounds(130,140,80, 20);
        
        jPanelEstoque= new JPanel();
        jPanelEstoque.setBorder(BorderFactory.createTitledBorder("Informações de Estoque"));
        jPanelEstoque.setBounds(20, 180, 420,150);
        jPanelEstoque.setLayout(new GroupLayout(jPanelEstoque));
        
        jLabelEstoqueAnterior = new JLabel("Anterior :");
        jLabelEstoqueAnterior.setBounds(20, 20, 100, 30);
        jFormattedTextFieldEstoqueAnterior = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueAnterior.setBounds(100,27,80, 20);
        
        jLabelEstoqueEntrada = new JLabel("Entradas :");
        jLabelEstoqueEntrada.setBounds(20, 60, 100, 30);
        jFormattedTextFieldEstoqueEntrada = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueEntrada.setBounds(100,65,80, 20);
        
        jLabelEstoqueSaida = new JLabel("Saídas :");
        jLabelEstoqueSaida.setBounds(220, 60, 100, 30);
        jFormattedTextFieldEstoqueSaida = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueSaida.setBounds(290,65,80, 20);
        
        jLabelEstoqueAtual = new JLabel("Atual :");
        jLabelEstoqueAtual.setBounds(220, 110, 100, 30);
        jFormattedTextFieldEstoqueAtual = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueAtual.setBounds(290,115,80, 20);

        jPanelEstoque.add(jLabelEstoqueAnterior);
        jPanelEstoque.add(jFormattedTextFieldEstoqueAnterior);
        
        jPanelEstoque.add(jLabelEstoqueEntrada);
        jPanelEstoque.add(jFormattedTextFieldEstoqueEntrada);
        
        jPanelEstoque.add(jLabelEstoqueSaida);
        jPanelEstoque.add(jFormattedTextFieldEstoqueSaida);
        
        jPanelEstoque.add(jLabelEstoqueAtual);
        jPanelEstoque.add(jFormattedTextFieldEstoqueAtual);
        
        this.jPaneCampos.setSize(550, 900);
        
        this.jPaneCampos.add(jLabelCodigo);
        this.jPaneCampos.add(jTextFieldCodigo);
        
        this.jPaneCampos.add(jLabelNome);
        this.jPaneCampos.add(jTextFieldNome);
        
        this.jPaneCampos.add(jLabelPrecoCusto);
        this.jPaneCampos.add(jFormattedTextFieldPrecoCusto);
        
        this.jPaneCampos.add(jLabelPrecoVenda);
        this.jPaneCampos.add(jFormattedTextFieldPrecoVenda);
        
        this.jPaneCampos.add(jLabelPrecoVenda);
        this.jPaneCampos.add(jFormattedTextFieldPrecoVenda);
        
        this.jPaneCampos.add(jPanelEstoque);
        
    }
    
    
}
