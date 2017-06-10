/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.utils;

import br.sp.unifae.cris.comp7.view.Pesquisa;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Administrador
 */
public class Generica {
    
    public static Object globalRetornoPesquisa;
    public static Object globalRetornoPesquisaAuxiliar;

    public static void Limpar_Campos_Tela(JPanel tela) {
        for (Component componente : tela.getComponents()) {
            if (componente instanceof JPanel) {
                Limpar_Campos_Tela((JPanel) componente);
            }
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            }
            if (componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
            }
            if(componente instanceof JScrollPane){
                JViewport viewport = ((JScrollPane)componente).getViewport(); 
                JTable table = (JTable)viewport.getView();
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
            }
        }
    }
    
    public static void Limpar_Campos_Tela(JPanel tela, Boolean bloquear_Componentes){
        for (Component componente : tela.getComponents()) {
            if (componente instanceof JPanel) {
                Limpar_Campos_Tela((JPanel) componente,bloquear_Componentes);
            }
            if(componente instanceof JScrollPane){
                JViewport viewport = ((JScrollPane)componente).getViewport(); 
                JTable table = (JTable)viewport.getView();
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                
                table.setEnabled(!bloquear_Componentes);
            }
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
                ((JTextField) componente).setEnabled(!bloquear_Componentes);
            }
            if (componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
                ((JFormattedTextField) componente).setEnabled(!bloquear_Componentes);
            }
            if(componente instanceof JButton){
                ((JButton) componente).setEnabled(!bloquear_Componentes);
            }
        }
    }
    
    public static Float stringConverterParaFloat(String campo){
        if("".equals(campo) || campo.isEmpty() || campo == null)
            campo = "0";
        campo = campo.replace(".","");
        campo = campo.replace(",",".");
        return Float.parseFloat(campo);
    }
    
    public static String floatConverterParaString(Float campo){
        if(campo == null)
            campo = 0f;
        return (String.valueOf(campo)).replace(".", ",");
    }
    
    public static final ImageIcon iconePesquisaEmTela(){
        ImageIcon ico = new ImageIcon(Generica.class.getResource("/br/sp/unifae/cris/comp7/utils/imagens/icons/1495936783_circle-edit-search-thin.png"));
        return ico;
    }
    
    public static final ImageIcon iconeAdicionarEmTela(){
        ImageIcon ico = new ImageIcon(Generica.class.getResource("/br/sp/unifae/cris/comp7/utils/imagens/icons/1496079222_flat-style-circle-add.png"));
        return ico;
    }            
  
    }
    
    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth,
        double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                    (tablePreferredWidth * (percentages[i] / total)));
        }
    }
    
    public static void pesquisaGeral(Object classe){
        Generica.globalRetornoPesquisa = null;
        Pesquisa janela = new Pesquisa(classe);
        janela.setModal(true);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
}
