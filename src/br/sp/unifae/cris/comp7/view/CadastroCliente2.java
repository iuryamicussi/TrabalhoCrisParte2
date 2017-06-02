package br.sp.unifae.cris.comp7.view;

//<editor-fold defaultstate="collapsed" desc="Importações">
import br.sp.unifae.cris.comp7.model.Cliente;
import br.sp.unifae.cris.comp7.utils.Generica;
import br.sp.unifae.cris.comp7.model.dao.DAOCliente;
import br.sp.unifae.cris.comp7.utils.interfaces.ITela;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JOptionPane;
import br.sp.unifae.cris.comp7.model.Estado;
//</editor-fold>

/**
 *
 * @author Nora
 */
public class CadastroCliente2 extends Template implements ITela{
    
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
        Cliente cliente = new Cliente();
        try{
            cliente.setId(Integer.parseInt(jTextFieldCodigo.getText()));
            cliente.excluir();
            super.excluir();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    @Override
    public void salvar(){
        
        Cliente cliente = new Cliente();
        try{
            try{cliente.setNome(jTextFieldNome.getText());}
            catch(Exception ex){
                jTextFieldNome.requestFocus();
                throw ex;
            }            
            try
            {
                if(jRadioButtonFisica.isSelected())
                {
                    cliente.setFisicaOuJuridica("f");
                }
                else
                    cliente.setFisicaOuJuridica("j");
            }
            catch(Exception ex)
            {
                throw ex;
            }
            try{cliente.setCpfOuCnpj(jFormattedTextFieldCpnfOuCnpj.getText());}
            catch(Exception ex){ 
                jFormattedTextFieldCpnfOuCnpj.requestFocus();
                throw ex;
            }
            try{cliente.setEndereco(jTextFieldEndereco.getText());}
            catch(Exception ex){
                jTextFieldEndereco.requestFocus();
                throw ex;
            }
            try{cliente.setCidade(jTextFieldCidade.getText());}
            catch(Exception ex){
                jTextFieldCidade.requestFocus();
                throw ex;
            }
            try{cliente.setEstado((Estado)jComboBoxEstado.getSelectedItem());}
            catch(Exception ex){
                throw ex;
            }
            if(isNovo)
                cliente.armazenar();
            else{
                cliente.setId(Integer.parseInt(jTextFieldCodigo.getText()));
                cliente.alterar();
            }
            super.salvar();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    //</editor-fold>   
    
    //<editor-fold defaultstate="collapsed" desc="Métodos da Tela">
    @Override
    public final void DesenharTela() {
        this.setTitle("Cadastro de Cliente");
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
        
        jLabelCpfOuCnpj = new JLabel("CPF :");
        jLabelCpfOuCnpj.setBounds(20, 140, 60, 20);   
        jFormattedTextFieldCpnfOuCnpj = new JFormattedTextField();
        jFormattedTextFieldCpnfOuCnpj.setBounds(90, 140, 150, 20);  
        try
        {
            jFormattedTextFieldCpnfOuCnpj.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        }
        catch(java.text.ParseException ex)
        {  
            ex.printStackTrace();
        }  
        
        jRadioButtonFisica = new JRadioButton("Pessoa Física", true);
        jRadioButtonFisica.setBounds(90, 100, 120, 30);
        jRadioButtonFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                jRadioButtonJuridica.setSelected(false);                
                jRadioButtonFisica.setSelected(true);
                jLabelCpfOuCnpj.setText("CPF :");                
                jFormattedTextFieldCpnfOuCnpj.grabFocus();
                try
                {
                    jFormattedTextFieldCpnfOuCnpj.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
                }
                catch(java.text.ParseException ex)
                {  
                    ex.printStackTrace();
                }               
            }
        });
        
        jRadioButtonJuridica = new JRadioButton("Pessoa Jurídica", false);
        jRadioButtonJuridica.setBounds(300, 100, 120, 30);
        jRadioButtonJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                jRadioButtonJuridica.setSelected(true);                
                jRadioButtonFisica.setSelected(false);
                jLabelCpfOuCnpj.setText("CNPJ :");                
                jFormattedTextFieldCpnfOuCnpj.grabFocus();
                try
                {
                    jFormattedTextFieldCpnfOuCnpj.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###/####-##")));
                }
                catch(java.text.ParseException ex)
                {
                    ex.printStackTrace();
                }               
            }
        });        

        jLabelEndereco = new JLabel("Endereço :");
        jLabelEndereco.setBounds(20, 180, 60, 20);
        jTextFieldEndereco = new JTextField("");
        jTextFieldEndereco.setBounds(90, 180, 350, 20);
        
        jLabelCidade = new JLabel("Cidade :");
        jLabelCidade.setBounds(20, 220, 60, 20);
        jTextFieldCidade = new JTextField("");
        jTextFieldCidade.setBounds(90, 220, 350, 20);        
        
        jLabelEstado = new JLabel("Estado :");
        jLabelEstado.setBounds(20, 260, 60, 20);
        jComboBoxEstado = new JComboBox<>();
        jComboBoxEstado.setModel(new DefaultComboBoxModel<>(new String [] {"ACRE", "ALAGOAS", "AMAPA", "AMAZONAS", "BAHIA", "CEARA", "DISTRITO FEDERAL", "ESPIRITO SANTO", "GOIAS", "MARANHAO", "MATO GROSSO", "MATO GROSSO DO SUL", "MINAS GERAIS", "PARA", "PARAIBA", "PARANA", "PERNAMBUCO", "PIAUI", "RIO DE JANEIRO", "RIO GRANDE DO NORTE", "RIO GRANDE DO SUL", "RONDONIA", "RORAIMA", "SANTA CATARINA", "SAO PAULO", "SERGIPE", "TOCANTINS", " " }));
        jComboBoxEstado.setBounds(90, 260, 250, 20);       

        this.jPaneCampos.setSize(550, 900);

        this.jPaneCampos.add(jLabelCodigo);
        this.jPaneCampos.add(jTextFieldCodigo);

        this.jPaneCampos.add(jLabelNome);
        this.jPaneCampos.add(jTextFieldNome);
        
        this.jPaneCampos.add(jLabelEndereco);
        this.jPaneCampos.add(jTextFieldEndereco);
        
        this.jPaneCampos.add(jLabelCidade);
        this.jPaneCampos.add(jTextFieldCidade);        
       
        this.jPaneCampos.add(jRadioButtonFisica);
        this.jPaneCampos.add(jRadioButtonJuridica);
        
        this.jPaneCampos.add(jLabelCpfOuCnpj);
        this.jPaneCampos.add(jFormattedTextFieldCpnfOuCnpj);
        
        this.jPaneCampos.add(jLabelEstado);
        this.jPaneCampos.add(jComboBoxEstado);     
        
    }
    
    @Override
    public void PreencherCampos(Object obj) {
        Cliente cliente;
        Generica.Limpar_Campos_Tela(this.jPaneCampos,obj==null);
        if (obj == null) {
            return;
        }
        for (Iterator it = registros.iterator(); it.hasNext();) {
            cliente = (Cliente) it.next();
            if (cliente.getId().equals(obj)) {
                jTextFieldCodigo.setText(cliente.getId().toString());
                jTextFieldNome.setText(cliente.getNome());
                jFormattedTextFieldCpnfOuCnpj.setText(cliente.getCpfOuCnpj());
                jTextFieldEndereco.setText(cliente.getEndereco());
                jTextFieldCidade.setText(cliente.getCidade());
                jComboBoxEstado.setSelectedItem(cliente.getEstado());              
            }
        }
    }
    
    @Override
    public void PopularListaDeRegistros() {
        Cliente obj = new Cliente();
        registros = obj.listar();
    }
    //</editor-fold>    
}
    

