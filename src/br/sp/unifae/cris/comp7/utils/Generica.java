/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.utils;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Administrador
 */
public class Generica {

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
        }
    }
    
    public static void Limpar_Campos_Tela(JPanel tela, Boolean bloquear_Componentes){
        for (Component componente : tela.getComponents()) {
            if (componente instanceof JPanel) {
                Limpar_Campos_Tela((JPanel) componente,bloquear_Componentes);
            }
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
                ((JTextField) componente).setEnabled(!bloquear_Componentes);
            }
            if (componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
                ((JFormattedTextField) componente).setEnabled(!bloquear_Componentes);
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
