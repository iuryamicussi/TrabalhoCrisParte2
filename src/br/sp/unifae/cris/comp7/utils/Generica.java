/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.utils;

import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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
}
