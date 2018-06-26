package GUIs;

import DAOs.DAOCliente;
import Entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Image;
import javax.swing.JTextField;
import tools.*;
import DAOs.*;

public class GUICliente extends JFrame {

    ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
    ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
    ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
    JButton btnCreate = new JButton(iconeCreate);
    JButton btnRetrieve = new JButton(iconeRetrieve);
    JButton btnUpdate = new JButton(iconeUpdate);
    JButton btnDelete = new JButton(iconeDelete);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnList = new JButton(iconeListar);
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(8, 2));
    private JPanel pnSul = new JPanel(new GridLayout(1, 1));
    private JLabel lbCPF = new JLabel("CPF");
    private JTextField tfCPF = new JTextField(10);
    private JLabel lbNomeCompleto = new JLabel("Nome Completo");
    private JTextField tfNomeCompleto = new JTextField(10);
    private JLabel lbCelular = new JLabel("Celular");
    private JTextField tfCelular = new JTextField(10);
    private JLabel lbRua = new JLabel("Rua");
    private JTextField tfRua = new JTextField(10);
    private JLabel lbNumeroCasa = new JLabel("Numero da Casa");
    private JTextField tfNumeroCasa = new JTextField(10);
    private JLabel lbCEP = new JLabel("CEP");
    private JTextField tfCEP = new JTextField(10);
    private JLabel lbSenha = new JLabel("Senha");
    private JTextField tfSenha = new JTextField(10);
    private JLabel lbNumeroCartao = new JLabel("Numero do Cartao");
    private JTextField tfNumeroCartao = new JTextField(10);
    private JLabel lbCodigoSeguranca = new JLabel("Codigo de Seguranca");
    private JTextField tfCodigoSeguranca = new JTextField(10);
    ScrollPane scroll = new ScrollPane();
    JTextArea jTextArea = new JTextArea();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String qualAcao = "";//variavel para facilitar insert e update
    DAOCliente daoCliente = new DAOCliente();
    Cliente cliente;
    private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();

    public GUICliente() {
        setSize(900, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("CRUD - Cliente");
        Container cp = getContentPane();
        cp = getContentPane();
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        cp.setLayout(new BorderLayout());
        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);
        pnNorte.add(lbCPF);
        pnNorte.add(tfCPF);
        pnNorte.add(btnRetrieve);
        pnNorte.add(btnCreate);
        pnNorte.add(btnUpdate);
        pnNorte.add(btnDelete);
        pnNorte.add(btnSave);
        pnNorte.add(btnList);
        btnCancel.setVisible(false);
        btnDelete.setVisible(false);
        btnCreate.setVisible(false);
        btnSave.setVisible(false);
        btnUpdate.setVisible(false);
        pnCentro.add(lbNomeCompleto);
        pnCentro.add(tfNomeCompleto);
        pnCentro.add(lbCelular);
        pnCentro.add(tfCelular);
        pnCentro.add(lbRua);
        pnCentro.add(tfRua);
        pnCentro.add(lbNumeroCasa);
        pnCentro.add(tfNumeroCasa);
        pnCentro.add(lbCEP);
        pnCentro.add(tfCEP);
        pnCentro.add(lbSenha);
        pnCentro.add(tfSenha);
        pnCentro.add(lbNumeroCartao);
        pnCentro.add(tfNumeroCartao);
        pnCentro.add(lbCodigoSeguranca);
        pnCentro.add(tfCodigoSeguranca);
        pnSul.setBackground(Color.red);
        scroll.add(jTextArea);
        pnSul.add(scroll);
        tfNomeCompleto.setEditable(false);
        tfCelular.setEditable(false);
        tfRua.setEditable(false);
        tfNumeroCasa.setEditable(false);
        tfCEP.setEditable(false);
        tfSenha.setEditable(false);
        tfNumeroCartao.setEditable(false);
        tfCodigoSeguranca.setEditable(false);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfCPF.setBackground(Color.white);
                    jTextArea.setText("");
                    cliente = new Cliente();
                    String identificador = tfCPF.getText();
                    cliente.setCpf(identificador);
                    cliente = daoCliente.obter(cliente.getCpf());
                    if (cliente == null) {
                        pnNorte.setBackground(Color.red);
                        tfNomeCompleto.setText("");
                        tfCelular.setText("");
                        tfRua.setText("");
                        tfNumeroCasa.setText("");
                        tfCEP.setText("");
                        tfSenha.setText("");
                        tfNumeroCartao.setText("");
                        tfCodigoSeguranca.setText("");
                        btnCreate.setVisible(true);
                    } else {
                        pnNorte.setBackground(Color.green);
                        tfNomeCompleto.setText(cliente.getNomeCompleto());
                        tfCelular.setText(String.valueOf(cliente.getCelular()));
                        tfRua.setText(cliente.getRua());
                        tfNumeroCasa.setText(String.valueOf(cliente.getNumeroCasa()));
                        tfCEP.setText(String.valueOf(cliente.getCep()));
                        tfSenha.setText(cliente.getSenha());
                        tfNumeroCartao.setText(String.valueOf(cliente.getNumeroCartao()));
                        tfCodigoSeguranca.setText(String.valueOf(cliente.getCodigoSeguranca()));
                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);
                        btnCreate.setVisible(false);
                    }
                    tfCPF.setEditable(false);
                    tfNomeCompleto.setEditable(false);
                    tfCelular.setEditable(false);
                    tfRua.setEditable(false);
                    tfNumeroCasa.setEditable(false);
                    tfCEP.setEditable(false);
                    tfSenha.setEditable(false);
                    tfNumeroCartao.setEditable(false);
                    tfCodigoSeguranca.setEditable(false);
                    tfCPF.selectAll();
                } catch (Exception erro) {
                    pnNorte.setBackground(Color.yellow);
                    tfCPF.requestFocus();
                    tfCPF.setBackground(Color.red);
                    jTextArea.setText("Erro... \n");
                    jTextArea.append(erro.getMessage());
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCPF.setEditable(false);
                tfNomeCompleto.requestFocus();
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                qualAcao = "incluir";
                cliente = new Cliente();
                tfNomeCompleto.setEditable(true);
                tfCelular.setEditable(true);
                tfRua.setEditable(true);
                tfNumeroCasa.setEditable(true);
                tfCEP.setEditable(true);
                tfSenha.setEditable(true);
                tfNumeroCartao.setEditable(true);
                tfCodigoSeguranca.setEditable(true);
                tfCPF.setEditable(false);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    cliente = new Cliente();
                    cliente.setCpf(tfCPF.getText());
                    cliente.setNomeCompleto(tfNomeCompleto.getText());
                    cliente.setCelular(Integer.valueOf(tfCelular.getText()));
                    cliente.setRua(tfRua.getText());
                    cliente.setNumeroCasa(Integer.valueOf(tfNumeroCasa.getText()));
                    cliente.setCep(Integer.valueOf(tfCEP.getText()));
                    cliente.setSenha(tfSenha.getText());
                    cliente.setNumeroCartao(Integer.valueOf(tfNumeroCartao.getText()));
                    cliente.setCodigoSeguranca(Integer.valueOf(tfCodigoSeguranca.getText()));
                    if (qualAcao.equals("incluir")) {
                        daoCliente.inserir(cliente);
                    } else {
                        daoCliente.atualizar(cliente);
                    }
                    tfCPF.setEditable(true);
                    tfCPF.requestFocus();
                    tfNomeCompleto.setText("");
                    tfCelular.setText("");
                    tfRua.setText("");
                    tfNumeroCasa.setText("");
                    tfCEP.setText("");
                    tfSenha.setText("");
                    tfNumeroCartao.setText("");
                    tfCodigoSeguranca.setText("");
                    btnSave.setVisible(false);
                    pnNorte.setBackground(Color.green);
                    tfNomeCompleto.setEditable(false);
                    tfCelular.setEditable(false);
                    tfRua.setEditable(false);
                    tfNumeroCasa.setEditable(false);
                    tfCEP.setEditable(false);
                    tfSenha.setEditable(false);
                    tfNumeroCartao.setEditable(false);
                    tfCodigoSeguranca.setEditable(false);
                } catch (Exception erro) {
                    jTextArea.append("Erro............");
                    tfCPF.setEditable(true);
                    pnNorte.setBackground(Color.red);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                tfNomeCompleto.requestFocus();
                btnSave.setVisible(true);
                qualAcao = "editar";
                tfNomeCompleto.setEditable(true);
                tfCelular.setEditable(true);
                tfRua.setEditable(true);
                tfNumeroCasa.setEditable(true);
                tfCEP.setEditable(true);
                tfSenha.setEditable(true);
                tfNumeroCartao.setEditable(true);
                tfCodigoSeguranca.setEditable(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + cliente.getCpf() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    daoCliente.remover(cliente);
                    tfCPF.requestFocus();
                    tfNomeCompleto.setText("");
                    tfCelular.setText("");
                    tfRua.setText("");
                    tfNumeroCasa.setText("");
                    tfCEP.setText("");
                    tfSenha.setText("");
                    tfNumeroCartao.setText("");
                    tfCodigoSeguranca.setText("");
                    tfCPF.setEditable(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIListagemCliente guiListagem = new GUIListagemCliente(daoCliente.list());
            }
        });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tfCPF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoCliente.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfCPF.setText(aux[0]);
                        btnRetrieve.doClick();

                    } else {
                        tfCPF.requestFocus();
                        tfCPF.selectAll();
                    }
                }
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        GUICliente guiCliente = new GUICliente();
    }
}
