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
public enum TiposDeMinhaExcecao {
    ValorMenorQueZero{
        @Override
        public String getDescription() {
            return "O valor do campo %s não pode ser inferior a zero.";
        }}, 
    CampoVazio{
        @Override
        public String getDescription() {
            return "O valor do campo %s não pode ser vazio.";
        }};
    public abstract String getDescription();
}
