/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.view;

import br.sp.unifae.cris.comp7.utils.Tela;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
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
        
        jLabelCodigo = new JLabel("Código :");
        jLabelCodigo.setBounds(20, 50, 100, 30);
        jLabelNome = new JLabel("Nome :");
        jLabelPrecoCusto = new JLabel("Preço Custo :");
        jLabelPrecoVenda = new JLabel("Preço Venda :");
        
        jPanelEstoque= new JPanel();
        jPanelEstoque.setBorder(BorderFactory.createLineBorder(Color.black));
        
        jLabelEstoqueAnterior = new JLabel("Anterior :");
        jLabelEstoqueAnterior.setBounds(20, 50, 100, 30);
        jLabelEstoqueEntrada = new JLabel("Entradas :");
        jLabelEstoqueSaida = new JLabel("Saídas :");
        jLabelEstoqueAtual = new JLabel("Atual :");
        
        jTextFieldCodigo = new JTextField("123456");
        jTextFieldCodigo.setBounds(20,100,50, 30);
        jTextFieldNome= new JTextField("1234567890123456789012345678901234567890");
        
        jFormattedTextFieldPrecoCusto = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldPrecoVenda = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueAnterior = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueEntrada = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueSaida = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueAtual = new JFormattedTextField(DecimalFormat.getInstance());
        
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
