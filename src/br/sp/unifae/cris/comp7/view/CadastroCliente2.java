package br.sp.unifae.cris.comp7.view;

import br.sp.unifae.cris.comp7.model.Cliente;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Nora
 */
public class CadastroCliente2 extends Template {
    
    //<editor-fold defaultstate="collapsed" desc="Variáveis e Campos da Tela">
    private List registros = null;
    
    JLabel jLabelCodigo;
    JLabel jLabelNome;
    JLabel jLabelCpfOuCnpj;
    JLabel jLabelEndereco;
    JLabel jLabelCidade;
    JLabel jLabelEstado;
    
    JTextField jTextFieldCodigo;
    JTextField jTextFieldNome;
    JTextField jTextFieldEndereco;
    JTextField jTextFieldCidade;
    JFormattedTextField jFormattedTextFieldCpnfOuCnpj;
    
    JComboBox <String> jComboBoxEstado;
    
    JRadioButton jRadioButtonFisica;
    JRadioButton jRadioButtonJuridica;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    CadastroCliente2() {
        DesenharTela();
        PopularListaDeRegistros();
        
        Object obj = new Cliente();
        this.setClasse(obj);
        this.setVisible(true);

        if (registros.size() > 0)
            pesquisar();
        else
            cancelar();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos da Tela">
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

        jLabelCidade = new JLabel("Cidade :");
        jLabelCidade.setBounds(20, 100, 60, 20);
        jTextFieldCidade = new JTextField("");
        jTextFieldCidade.setBounds(90, 100, 350, 20);
        
        jLabelEstado = new JLabel("Estado :");
        jLabelEstado.setBounds(20, 140, 60, 20);
        jComboBoxEstado = new JComboBox<>();
        jComboBoxEstado.setModel(new DefaultComboBoxModel<>(new String [] {"NORA", "EU", "SOU", "FODA", ""}));
        jComboBoxEstado.setBounds(90, 140, 350, 20);
        
        jRadioButtonFisica = new JRadioButton();   
        
        jRadioButtonJuridica = new JRadioButton();

        this.jPaneCampos.setSize(550, 900);

        this.jPaneCampos.add(jLabelCodigo);
        this.jPaneCampos.add(jTextFieldCodigo);

        this.jPaneCampos.add(jLabelNome);
        this.jPaneCampos.add(jTextFieldNome);
        
        this.jPaneCampos.add(jLabelCidade);
        this.jPaneCampos.add(jTextFieldCidade);
        
        this.jPaneCampos.add(jRadioButtonFisica);
        this.jPaneCampos.add(jRadioButtonJuridica);
        
        this.jPaneCampos.add(jLabelEstado);
        this.jPaneCampos.add(jComboBoxEstado);
        
        //</editor-fold>
    }
    
    
}
