/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.utils;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrador
 */
public class Generica {
    
    public static void Limpar_Campos_Tela(JFrame tela){
        for(Component componente : tela.getComponents()){
            if(SwingUtilities.getAncestorOfClass(JTextField.class, componente) != null){
                ((JTextField)componente).setText("");
            }
        }
    }
}
