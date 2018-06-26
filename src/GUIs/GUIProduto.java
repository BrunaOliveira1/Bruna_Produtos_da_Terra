package GUIs;

import DAOs.DAOProduto;
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

public class GUIProduto extends JFrame {

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
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date data2;
    private Date data3;
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(8, 2));
    private JPanel pnSul = new JPanel(new GridLayout(1, 1));
    private JPanel pnE1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE3 = new JPanel(new GridLayout(1, 1));
    private JLabel lbIdProduto = new JLabel("Id do Produto");
    private JTextField tfIdProduto = new JTextField(10);
    private JLabel lbNomeProduto = new JLabel("Nome do Produto");
    private JTextField tfNomeProduto = new JTextField(10);
    private JLabel lbDataValidade = new JLabel("Data de Validade");
    private JTextField tfDataValidade = new JTextField(10);
    private JButton btEscolha2 = new JButton("Escolha");
    private JPanel pnDataValidade = new JPanel(new GridLayout(1, 2));
    private JLabel lbDataFabricacao = new JLabel("Data de Fabricacao");
    private JTextField tfDataFabricacao = new JTextField(10);
    private JButton btEscolha3 = new JButton("Escolha");
    private JPanel pnDataFabricacao = new JPanel(new GridLayout(1, 2));
    private JLabel lbBeneficioSaude = new JLabel("Benefícios para sua Saúde");
    private JTextField tfBeneficioSaude = new JTextField(10);
    private JLabel lbPreco = new JLabel("Preco");
    private JTextField tfPreco = new JTextField(10);
    private JPanel pnCadastroMarcaIdMarca = new JPanel(new GridLayout(1, 2));
    private JLabel lbCadastroMarcaIdMarca = new JLabel("Id da Marca");
    private JTextField tfCadastroMarcaIdMarca = new JTextField();
    private JButton btCadastroMarcaIdMarca = new JButton("Procurar");
    private JPanel pnCadastroTipoIdTipo = new JPanel(new GridLayout(1, 2));
    private JLabel lbCadastroTipoIdTipo = new JLabel("Id do Tipo");
    private JTextField tfCadastroTipoIdTipo = new JTextField();
    private JButton btCadastroTipoIdTipo = new JButton("Procurar");
    private JPanel pnUnidadeMedidaIdUnidadeMedida = new JPanel(new GridLayout(1, 2));
    private JLabel lbUnidadeMedidaIdUnidadeMedida = new JLabel("Id da Unidade de Medida");
    private JTextField tfUnidadeMedidaIdUnidadeMedida = new JTextField();
    private JButton btUnidadeMedidaIdUnidadeMedida = new JButton("Procurar");
    JTextField tfCaminho = new JTextField();
    ScrollPane scroll = new ScrollPane();
    JTextArea jTextArea = new JTextArea();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String qualAcao = "";//variavel para facilitar insert e update
    DAOProduto daoProduto = new DAOProduto();
    Produto produto;
    private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
    private JPanel pnEsquerda = new JPanel(new BorderLayout());
    private JPanel pnDireita = new JPanel(new BorderLayout());
    private JLabel rotulo = new JLabel();
    private JButton btAbrirImagem = new JButton("Selecionar imagem");
    private String caminho;
    private Image imagemAux;
    private ImageIcon icone;

    public GUIProduto() {
        setSize(900, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("CRUD - Produto");
        Container cp = getContentPane();
        cp = getContentPane();
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        cp.setLayout(new GridLayout(1, 2));
        cp.add(pnEsquerda);
        cp.add(pnDireita);
        try {
            String caminho = "";
            tfCaminho.setText(caminho);
            icone = new ImageIcon(getClass().getResource(caminho));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            rotulo.setIcon(icone);
        } catch (Exception err) {
            System.out.println("erro " + err.getLocalizedMessage());
        }
        pnDireita.add(pnE1, BorderLayout.NORTH);
        pnE1.add(rotulo);
        pnDireita.add(pnE2, BorderLayout.CENTER);
        pnE2.add(btAbrirImagem);
        pnDireita.add(pnE3, BorderLayout.SOUTH);
        pnE3.add(tfCaminho);
        pnEsquerda.add(pnNorte, BorderLayout.NORTH);
        pnEsquerda.add(pnCentro, BorderLayout.CENTER);
        pnEsquerda.add(pnSul, BorderLayout.SOUTH);
        pnNorte.add(lbIdProduto);
        pnNorte.add(tfIdProduto);
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
        btAbrirImagem.setEnabled(false);
        tfCaminho.setEditable(false);
        pnCentro.add(lbNomeProduto);
        pnCentro.add(tfNomeProduto);
        pnCentro.add(lbDataValidade);
        pnCentro.add(pnDataValidade);
        pnDataValidade.add(btEscolha2);
        pnDataValidade.add(tfDataValidade);
        pnCentro.add(lbDataFabricacao);
        pnCentro.add(pnDataFabricacao);
        pnDataFabricacao.add(btEscolha3);
        pnDataFabricacao.add(tfDataFabricacao);
        pnCentro.add(lbBeneficioSaude);
        pnCentro.add(tfBeneficioSaude);
        pnCentro.add(lbPreco);
        pnCentro.add(tfPreco);
        pnCentro.add(lbCadastroMarcaIdMarca);
        pnCentro.add(pnCadastroMarcaIdMarca);
        pnCadastroMarcaIdMarca.add(tfCadastroMarcaIdMarca);
        pnCadastroMarcaIdMarca.add(btCadastroMarcaIdMarca);
        pnCentro.add(lbCadastroTipoIdTipo);
        pnCentro.add(pnCadastroTipoIdTipo);
        pnCadastroTipoIdTipo.add(tfCadastroTipoIdTipo);
        pnCadastroTipoIdTipo.add(btCadastroTipoIdTipo);
        pnCentro.add(lbUnidadeMedidaIdUnidadeMedida);
        pnCentro.add(pnUnidadeMedidaIdUnidadeMedida);
        pnUnidadeMedidaIdUnidadeMedida.add(tfUnidadeMedidaIdUnidadeMedida);
        pnUnidadeMedidaIdUnidadeMedida.add(btUnidadeMedidaIdUnidadeMedida);
        pnSul.setBackground(Color.red);
        scroll.add(jTextArea);
        pnSul.add(scroll);
        tfCaminho.setEditable(false);
        tfNomeProduto.setEditable(false);
        btEscolha2.setEnabled(false);
        tfDataValidade.setEditable(false);
        btEscolha3.setEnabled(false);
        tfDataFabricacao.setEditable(false);
        tfBeneficioSaude.setEditable(false);
        tfPreco.setEditable(false);
        tfCadastroMarcaIdMarca.setEditable(false);
        btCadastroMarcaIdMarca.setEnabled(false);
        tfCadastroTipoIdTipo.setEditable(false);
        btCadastroTipoIdTipo.setEnabled(false);
        tfUnidadeMedidaIdUnidadeMedida.setEditable(false);
        btUnidadeMedidaIdUnidadeMedida.setEnabled(false);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfIdProduto.setBackground(Color.white);
                    jTextArea.setText("");
                    produto = new Produto();
                    int identificador = Integer.valueOf(tfIdProduto.getText());
                    produto.setIdProduto(identificador);
                    produto = daoProduto.obter(produto.getIdProduto());
                    if (produto == null) {
                        pnNorte.setBackground(Color.red);
                        tfCaminho.setText("");
                        tfNomeProduto.setText("");
                        tfDataValidade.setText("");
                        tfDataFabricacao.setText("");
                        tfBeneficioSaude.setText("");
                        tfPreco.setText("");
                        tfCadastroMarcaIdMarca.setText("");
                        tfCadastroTipoIdTipo.setText("");
                        tfUnidadeMedidaIdUnidadeMedida.setText("");
                        tfCaminho.setText("");
                        btnCreate.setVisible(true);
                    } else {
                        pnNorte.setBackground(Color.green);
                        caminho = produto.getCaminho();
                        tfCaminho.setText(caminho);
                        icone = new ImageIcon(caminho);
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                        tfNomeProduto.setText(produto.getNomeProduto());
                        tfDataValidade.setText(sdf.format(produto.getDataValidade()));
                        tfDataFabricacao.setText(sdf.format(produto.getDataFabricacao()));
                        tfBeneficioSaude.setText(produto.getBeneficioSaude());
                        tfPreco.setText(String.valueOf(produto.getPreco()));
                        String dao1 = String.valueOf(produto.getCadastroMarcaIdMarca());
                        String[] aux1 = dao1.split("-");
                        tfCadastroMarcaIdMarca.setText(aux1[0]);
                        String dao2 = String.valueOf(produto.getCadastroTipoIdTipo());
                        String[] aux2 = dao2.split("-");
                        tfCadastroTipoIdTipo.setText(aux2[0]);
                        String dao3 = String.valueOf(produto.getUnidadeMedidaIdUnidadeMedida());
                        String[] aux3 = dao3.split("-");
                        tfUnidadeMedidaIdUnidadeMedida.setText(aux3[0]);
                        tfCaminho.setText(produto.getCaminho());
                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);
                        btnCreate.setVisible(false);
                    }
                    btAbrirImagem.setEnabled(false);
                    tfIdProduto.setEditable(false);
                    tfNomeProduto.setEditable(false);
                    tfDataValidade.setEditable(false);
                    tfDataFabricacao.setEditable(false);
                    tfBeneficioSaude.setEditable(false);
                    tfPreco.setEditable(false);
                    btCadastroMarcaIdMarca.setEnabled(false);
                    btCadastroTipoIdTipo.setEnabled(false);
                    btUnidadeMedidaIdUnidadeMedida.setEnabled(false);
                    tfIdProduto.selectAll();
                } catch (Exception erro) {
                    pnNorte.setBackground(Color.yellow);
                    tfIdProduto.requestFocus();
                    tfIdProduto.setBackground(Color.red);
                    jTextArea.setText("Erro... \n");
                    jTextArea.append(erro.getMessage());
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfIdProduto.setEditable(false);
                tfNomeProduto.requestFocus();
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                qualAcao = "incluir";
                produto = new Produto();
                tfNomeProduto.setEditable(true);
                btEscolha2.setEnabled(true);
                btEscolha3.setEnabled(true);
                tfBeneficioSaude.setEditable(true);
                tfPreco.setEditable(true);
                btCadastroMarcaIdMarca.setEnabled(true);
                btCadastroTipoIdTipo.setEnabled(true);
                btUnidadeMedidaIdUnidadeMedida.setEnabled(true);
                tfIdProduto.setEditable(false);
                btAbrirImagem.setEnabled(true);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    produto = new Produto();
                    produto.setIdProduto(Integer.valueOf(tfIdProduto.getText()));
                    produto.setNomeProduto(tfNomeProduto.getText());
                    sdf.setLenient(false);
                    data2 = sdf.parse(tfDataValidade.getText());
                    try {
                        produto.setDataValidade(sdf.parse(tfDataValidade.getText()));
                    } catch (ParseException ex) {
                        Logger.getLogger(GUIProduto.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    data3 = sdf.parse(tfDataFabricacao.getText());
                    try {
                        produto.setDataFabricacao(sdf.parse(tfDataFabricacao.getText()));
                    } catch (ParseException ex) {
                        Logger.getLogger(GUIProduto.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    produto.setBeneficioSaude(tfBeneficioSaude.getText());
                    produto.setPreco(Double.valueOf(tfPreco.getText()));
                    String[] aux0 = tfCadastroMarcaIdMarca.getText().split("-");
                    DAOMarca daoMarca = new DAOMarca();
                    Marca d0 = daoMarca.obter(Integer.valueOf(aux0[0]));
                    produto.setCadastroMarcaIdMarca(d0);
                    String[] aux1 = tfCadastroTipoIdTipo.getText().split("-");
                    DAOTipo daoTipo = new DAOTipo();
                    Tipo d1 = daoTipo.obter(Integer.valueOf(aux1[0]));
                    produto.setCadastroTipoIdTipo(d1);
                    String[] aux2 = tfUnidadeMedidaIdUnidadeMedida.getText().split("-");
                    DAOUnidadeMedida daoUnidadeMedida = new DAOUnidadeMedida();
                    UnidadeMedida d2 = daoUnidadeMedida.obter(Integer.valueOf(aux2[0]));
                    produto.setUnidadeMedidaIdUnidadeMedida(d2);
                    produto.setCaminho(tfCaminho.getText());
                    caminho = tfCaminho.getText();
                    produto.setCaminho(caminho);
                    caminho = "";
                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);
                    if (qualAcao.equals("incluir")) {
                        daoProduto.inserir(produto);
                    } else {
                        daoProduto.atualizar(produto);
                    }
                    tfIdProduto.setEditable(true);
                    tfIdProduto.requestFocus();
                    tfNomeProduto.setText("");
                    tfDataValidade.setText("");
                    tfDataFabricacao.setText("");
                    tfBeneficioSaude.setText("");
                    tfPreco.setText("");
                    tfCadastroMarcaIdMarca.setText("");
                    tfCadastroTipoIdTipo.setText("");
                    tfUnidadeMedidaIdUnidadeMedida.setText("");
                    tfCaminho.setText("");
                    tfCaminho.setText("");
                    btnSave.setVisible(false);
                    pnNorte.setBackground(Color.green);
                    tfNomeProduto.setEditable(false);
                    btEscolha2.setEnabled(false);
                    btEscolha3.setEnabled(false);
                    tfBeneficioSaude.setEditable(false);
                    tfPreco.setEditable(false);
                    btCadastroMarcaIdMarca.setEnabled(false);
                    btCadastroTipoIdTipo.setEnabled(false);
                    btUnidadeMedidaIdUnidadeMedida.setEnabled(false);
                    tfCaminho.setEditable(false);
                    btAbrirImagem.setEnabled(false);
                } catch (Exception erro) {
                    jTextArea.append("Erro............");
                    tfIdProduto.setEditable(true);
                    pnNorte.setBackground(Color.red);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                btAbrirImagem.setEnabled(true);
                tfNomeProduto.requestFocus();
                btnSave.setVisible(true);
                qualAcao = "editar";
                tfNomeProduto.setEditable(true);
                btEscolha2.setEnabled(true);
                btEscolha3.setEnabled(true);
                tfBeneficioSaude.setEditable(true);
                tfPreco.setEditable(true);
                btCadastroMarcaIdMarca.setEnabled(true);
                btCadastroTipoIdTipo.setEnabled(true);
                btUnidadeMedidaIdUnidadeMedida.setEnabled(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + produto.getIdProduto() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    daoProduto.remover(produto);
                    tfIdProduto.requestFocus();
                    tfNomeProduto.setText("");
                    tfDataValidade.setText("");
                    tfDataFabricacao.setText("");
                    tfBeneficioSaude.setText("");
                    tfPreco.setText("");
                    tfCadastroMarcaIdMarca.setText("");
                    tfCadastroTipoIdTipo.setText("");
                    tfUnidadeMedidaIdUnidadeMedida.setText("");
                    tfCaminho.setText("");
                    String caminho = "";

                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);

                    tfCaminho.setText("");
                    tfIdProduto.setEditable(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIListagemProduto guiListagem = new GUIListagemProduto(daoProduto.list());
            }
        });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btEscolha2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    DateChooser dc2 = new DateChooser((JFrame) null, "Escolha uma data");
                    data2 = dc2.select();
                    tfDataValidade.setText(sdf.format(data2));
                } catch (Exception ex) {
                    jTextArea.setText("Escolha uma data\n");
                }
            }
        });
        btEscolha3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    DateChooser dc3 = new DateChooser((JFrame) null, "Escolha uma data");
                    data3 = dc3.select();
                    tfDataFabricacao.setText(sdf.format(data3));
                } catch (Exception ex) {
                    jTextArea.setText("Escolha uma data\n");
                }
            }
        });
        btAbrirImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(pnDireita) == JFileChooser.APPROVE_OPTION) {
                    File img = fc.getSelectedFile();
                    String caminho = fc.getSelectedFile().getAbsolutePath();
                    try {
                        tfCaminho.setText(caminho);
                        icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                    } catch (Exception ex) {
                        System.out.println("Erro: " + ex.getMessage());
                    }
                }
            }
        });
        DAOMarca daoMarca = new DAOMarca();
        btCadastroMarcaIdMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoMarca.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfCadastroMarcaIdMarca.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        DAOTipo daoTipo = new DAOTipo();
        btCadastroTipoIdTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoTipo.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfCadastroTipoIdTipo.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        DAOUnidadeMedida daoUnidadeMedida = new DAOUnidadeMedida();
        btUnidadeMedidaIdUnidadeMedida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoUnidadeMedida.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfUnidadeMedidaIdUnidadeMedida.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        tfIdProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoProduto.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdProduto.setText(aux[0]);
                        btnRetrieve.doClick();

                    } else {
                        tfIdProduto.requestFocus();
                        tfIdProduto.selectAll();
                    }
                }
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        GUIProduto guiProduto = new GUIProduto();
    }
}
