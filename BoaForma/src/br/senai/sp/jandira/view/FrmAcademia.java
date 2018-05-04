package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Cliente;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class FrmAcademia extends JFrame {

	private JPanel painelPrincipal;
	private final JPanel painelBotoes = new JPanel();
	private JTable tabelaContatos;
	private JScrollPane scrollTabela;
	private JPanel painelTabela;
	private JTable table;

	public FrmAcademia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 567);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(245, 222, 179));
		painelTitulo.setBounds(0, 0, 408, 115);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblBoaForma = new JLabel("Boa Forma");
		lblBoaForma.setBackground(new Color(250, 250, 210));
		lblBoaForma.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/academy.png")));
		lblBoaForma.setFont(new Font("Arial", Font.PLAIN, 28));
		lblBoaForma.setBounds(72, 28, 206, 65);
		painelTitulo.add(lblBoaForma);
		
		JPanel painelTabela = new JPanel();
		painelTabela.setBackground(new Color(245, 222, 179));
		painelTabela.setBounds(0, 115, 408, 418);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		painelBotoes.setBounds(10, 335, 370, 72);
		painelTabela.add(painelBotoes);

		
		painelBotoes.setBackground(new Color(245, 222, 179));
		painelBotoes.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		painelBotoes.setLayout(null);
		
		JButton bntAdicionar = new JButton("");
		bntAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmTela imc = new FrmTela();
				imc.setVisible(true);
			}
		});
		bntAdicionar.setBackground(Color.WHITE);
		bntAdicionar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/botao.png")));
		bntAdicionar.setBounds(20, 30, 103, 33);
		painelBotoes.add(bntAdicionar);
		
		JButton bntEditar = new JButton("");
		bntEditar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/editar.png")));
		bntEditar.setBackground(Color.WHITE);
		bntEditar.setBounds(133, 30, 103, 33);
		painelBotoes.add(bntEditar);
		
		JButton bntExcluir = new JButton("");
		bntExcluir.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/fechar.png")));
		bntExcluir.setBackground(Color.WHITE);
		bntExcluir.setBounds(246, 30, 103, 33);
		painelBotoes.add(bntExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 370, 310);
		painelTabela.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(240, 255, 255));
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
	}
		
		public void montarTabela(){
			scrollTabela = new JScrollPane();
			scrollTabela.setBounds(10, 22, 441, 344);

			
			
			tabelaContatos = new JTable();
			DefaultTableModel modeloTabela = new DefaultTableModel();
			String[] nomesColunas = {"ID", "NOME", "E-MAIL"};
			modeloTabela.setColumnIdentifiers(nomesColunas);
			ContatoDAO contatoDAO = new ContatoDAO();
			ArrayList<Cliente> clientes = new ArrayList<>();
			clientes = contatoDAO.getClientes();
			Object[] linha = new Object[3];
			for(Cliente	cliente : clientes){
				linha[0] = cliente.getId();
				linha[1] = cliente.getNome();
				linha[2] = cliente.getDtNasc();
				modeloTabela.addRow(linha);
			}
			tabelaContatos.setModel(modeloTabela);
			

			tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(30);
			tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(150);
			tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(150);
			scrollTabela.setViewportView(tabelaContatos);
		}
}
