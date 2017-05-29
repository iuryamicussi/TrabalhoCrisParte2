/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.view.acessorios;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Administrador
 */
public class MenuContextoTabelaListener extends MouseAdapter {
    
    @Override
    public void mousePressed(MouseEvent e){
        if(e.isPopupTrigger()){
            doPop(e);
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(e.isPopupTrigger()){
            doPop(e);
        }
    }
    
    private void doPop(MouseEvent e){
        MenuContextoTabela menu = new MenuContextoTabela();
        menu.show(e.getComponent(),e.getX(),e.getY());
    }
}
