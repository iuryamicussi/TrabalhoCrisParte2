/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.utils.excecao;

/**
 *
 * @author Administrador
 */

public class MinhaExcecao{
    
    public MinhaExcecao(String message) throws Exception{
        throw new Exception(message);
    }
    
    public MinhaExcecao(TiposDeMinhaExcecao tipo,String campo) throws Exception{
        throw new Exception(processarMensagem(tipo,campo));
    }
    
    private String processarMensagem(TiposDeMinhaExcecao tipo, String campo){
        return String.format(tipo.getDescription(), campo);
    }
}
