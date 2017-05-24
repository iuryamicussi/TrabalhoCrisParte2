/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.utils.interfaces;

import java.util.List;

/**
 *
 * @author Administrador
 */
public interface ITela extends IMetodosBasicosTela {
    
    /**
     * Variável que irá conter a tabela de registros da tela
     */
    List registros = null;
    
    void DesenharTela();
    void PreencherCampos(Object obj);
    void PopularListaDeRegistros();
}
