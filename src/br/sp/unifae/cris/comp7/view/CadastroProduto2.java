package br.sp.unifae.cris.comp7.view;

//<editor-fold defaultstate="collapsed" desc="Importações">
import br.sp.unifae.cris.comp7.model.Produto;
import br.sp.unifae.cris.comp7.utils.Generica;
import br.sp.unifae.cris.comp7.utils.interfaces.ITela;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//</editor-fold>
/**
 *
 * @author iury
 */
public class CadastroProduto2 extends Template implements ITela {

    //<editor-fold defaultstate="collapsed" desc="Variáveis e Campos da Tela">
    private List registros = null;

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
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    CadastroProduto2() {
        DesenharTela();
        PopularListaDeRegistros();
        
        Object obj = new Produto();
        this.setClasse(obj);
        this.setVisible(true);

        if (registros.size() > 0)
            pesquisar();
        else
            cancelar();
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos Básicos">
    @Override
    public Object pesquisar() {
        Object retorno = null;
        retorno = super.pesquisar();
        PreencherCampos(retorno);
        return null;
    }
    
    @Override
    public void excluir(){
        Produto produto = new Produto();
        try{
            produto.setId(Integer.parseInt(jTextFieldCodigo.getText()));
            produto.excluir();
            super.excluir();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    @Override
    public void salvar(){
        
        Produto produto = new Produto();
        try{
            try{produto.setNome(jTextFieldNome.getText());}
            catch(Exception ex){
                jTextFieldNome.requestFocus();
                throw ex;
            }
            try{produto.setPrecoCusto(Generica.stringConverterParaFloat(jFormattedTextFieldPrecoCusto.getText()));}
            catch(Exception ex){
                jFormattedTextFieldPrecoCusto.requestFocus();
                throw ex;
            }
            try{produto.setPrecoVenda(Generica.stringConverterParaFloat(jFormattedTextFieldPrecoVenda.getText()));}
            catch(Exception ex){
                jFormattedTextFieldPrecoVenda.requestFocus();
                throw ex;
            }
            try{produto.setEstoqueAnterior(Generica.stringConverterParaFloat(jFormattedTextFieldEstoqueAnterior.getText()));}
            catch(Exception ex){
                jFormattedTextFieldEstoqueAnterior.requestFocus();
                throw ex;
            }
            try{produto.setEstoqueEntrada(Generica.stringConverterParaFloat(jFormattedTextFieldEstoqueEntrada.getText()));}
            catch(Exception ex){
                jFormattedTextFieldEstoqueEntrada.requestFocus();
                throw ex;
            }
            try{produto.setEstoqueSaida(Generica.stringConverterParaFloat(jFormattedTextFieldEstoqueSaida.getText()));}
            catch(Exception ex){
                jFormattedTextFieldEstoqueSaida.requestFocus();
                throw ex;
            }
            if(isNovo)
                produto.armazenar();
            else{
                produto.setId(Integer.parseInt(jTextFieldCodigo.getText()));
                produto.alterar();
            }
            super.salvar();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos da Tela">
    @Override
    public final void DesenharTela() {
        this.setTitle("Cadastro de Produtos");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        jLabelCodigo = new JLabel("Código :");
        jLabelCodigo.setBounds(20, 20, 60, 20);
        jTextFieldCodigo = new JTextField("");
        jTextFieldCodigo.setBounds(90, 20, 55, 20);
        jTextFieldCodigo.setEditable(false);

        jLabelNome = new JLabel("Nome :");
        jLabelNome.setBounds(20, 60, 60, 20);
        jTextFieldNome = new JTextField("");
        jTextFieldNome.setBounds(90, 60, 350, 20);

        jLabelPrecoCusto = new JLabel("Preço Custo :");
        jLabelPrecoCusto.setBounds(20, 100, 120, 20);
        jFormattedTextFieldPrecoCusto = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldPrecoCusto.setBounds(130, 100, 80, 20);

        jLabelPrecoVenda = new JLabel("Preço Venda :");
        jLabelPrecoVenda.setBounds(20, 140, 120, 20);
        jFormattedTextFieldPrecoVenda = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldPrecoVenda.setBounds(130, 140, 80, 20);

        jPanelEstoque = new JPanel();
        jPanelEstoque.setBorder(BorderFactory.createTitledBorder("Informações de Estoque"));
        jPanelEstoque.setBounds(20, 180, 420, 150);
        jPanelEstoque.setLayout(new GroupLayout(jPanelEstoque));

        jLabelEstoqueAnterior = new JLabel("Anterior :");
        jLabelEstoqueAnterior.setBounds(20, 20, 100, 30);
        jFormattedTextFieldEstoqueAnterior = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueAnterior.setBounds(100, 27, 80, 20);

        jLabelEstoqueEntrada = new JLabel("Entradas :");
        jLabelEstoqueEntrada.setBounds(20, 60, 100, 30);
        jFormattedTextFieldEstoqueEntrada = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueEntrada.setBounds(100, 65, 80, 20);
        jFormattedTextFieldEstoqueEntrada.setEditable(false);

        jLabelEstoqueSaida = new JLabel("Saídas :");
        jLabelEstoqueSaida.setBounds(220, 60, 100, 30);
        jFormattedTextFieldEstoqueSaida = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueSaida.setBounds(290, 65, 80, 20);
        jFormattedTextFieldEstoqueSaida.setEditable(false);

        jLabelEstoqueAtual = new JLabel("Atual :");
        jLabelEstoqueAtual.setBounds(220, 110, 100, 30);
        jFormattedTextFieldEstoqueAtual = new JFormattedTextField(DecimalFormat.getInstance());
        jFormattedTextFieldEstoqueAtual.setBounds(290, 115, 80, 20);
        jFormattedTextFieldEstoqueAtual.setEditable(false);

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

    @Override
    public void PreencherCampos(Object obj) {
        Produto produto;
        Generica.Limpar_Campos_Tela(this.jPaneCampos,obj==null);
        if (obj == null) {
            return;
        }
        for (Iterator it = registros.iterator(); it.hasNext();) {
            produto = (Produto) it.next();
            if (produto.getId().equals(obj)) {
                jTextFieldCodigo.setText(produto.getId().toString());
                jTextFieldNome.setText(produto.getNome());
                jFormattedTextFieldPrecoCusto.setText(Generica.floatConverterParaString(produto.getPrecoCusto()));
                jFormattedTextFieldPrecoVenda.setText(Generica.floatConverterParaString(produto.getPrecoVenda()));
                jFormattedTextFieldEstoqueAnterior.setText(Generica.floatConverterParaString(produto.getEstoqueAnterior()));
                jFormattedTextFieldEstoqueEntrada.setText(Generica.floatConverterParaString(produto.getEstoqueEntrada()));
                jFormattedTextFieldEstoqueSaida.setText(Generica.floatConverterParaString(produto.getEstoqueSaida()));
                jFormattedTextFieldEstoqueAtual.setText(Generica.floatConverterParaString(produto.getEstoqueAtual()));
            }
        }
    }
    
    @Override
    public void PopularListaDeRegistros() {
        Produto obj = new Produto();
        registros = obj.listar();
    }
    // </editor-fold>
}
