/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.view.acessorios;

import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

/**
 *
 * @author Administrador
 */
public class MenuContextoTabela extends JPopupMenu {
    JMenuItem jMenuItemEditar;
    JSeparator jSeparator;
    JMenuItem jMenuItemExcluir;
    
    public MenuContextoTabela(){
        jMenuItemEditar = new JMenuItem("Editar");
        //jMenuItemEditar.setAction(event -> actionListener());
        jMenuItemExcluir = new JMenuItem("Excluir");
        add(jMenuItemEditar);
        add(jMenuItemExcluir);
    }

    private Action actionListener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
