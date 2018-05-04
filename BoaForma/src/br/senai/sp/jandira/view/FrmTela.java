package br.senai.sp.jandira.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.senai.sp.jandira.model.Cliente;

public class FrmTela extends JFrame {
	private JTextField txtPeso;

	public FrmTela() {
		getContentPane().setBackground(new Color(245, 222, 179));

		setSize(800, 500);
		getContentPane().setLayout(null);
		setTitle("Academia Boa Forma");
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setLayout(null);
		getContentPane().add(pnlTitulo);
		pnlTitulo.setBackground(new Color(211, 211, 211));
		DecimalFormat dfUmCasa = new DecimalFormat("0.#");
		DecimalFormat dfSemCasa = new DecimalFormat("0");


		JPanel pnlEsquerda = new JPanel();
		pnlEsquerda.setBackground(new Color(245, 222, 179));
		pnlEsquerda.setLayout(null);
		pnlEsquerda.setBorder(BorderFactory.createTitledBorder("Dados:"));
		pnlEsquerda.setBounds(10, 111, 325, 345);
		getContentPane().add(pnlEsquerda);

		Font Arial = new Font("Arial", 1, 20);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblIdade = new JLabel("Data de nascimento:");
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblNivelDeAtividade = new JLabel("Nível de atividade:");
		lblNivelDeAtividade.setFont(new Font("Arial", Font.PLAIN, 12));
		JTextField txtNome = new JTextField();
		JRadioButton radioHomem = new JRadioButton("Homem");
		radioHomem.setBackground(new Color(245, 222, 179));
		radioHomem.setFont(new Font("Arial", Font.PLAIN, 12));
		JRadioButton radioMulher = new JRadioButton("Mulher");
		radioMulher.setBackground(new Color(245, 222, 179));
		radioMulher.setFont(new Font("Arial", Font.PLAIN, 12));
		JTextField txtId = new JTextField();
		txtId.setEnabled(false);
		JTextField txtAltura = new JTextField();
		JTextField txtDtNasc = new JTextField();
		JButton btnSalvar = new JButton();
		btnSalvar.setBackground(new Color(135, 206, 235));
		btnSalvar.setIcon(new ImageIcon(FrmTela.class.getResource("/br/senai/sp/jandira/imagens/salvar.png")));

		JLabel lblBoaforma = new JLabel("Boa Forma");
		lblBoaforma.setIcon(new ImageIcon(FrmTela.class.getResource("/br/senai/sp/jandira/imagens/academy.png")));
		ButtonGroup group = new ButtonGroup();
		

		JComboBox<String> cbNivelAtivi = new JComboBox<>();

		String[] nivelAtivCombo = new String[5];
		nivelAtivCombo[0] = "Sedentário";
		nivelAtivCombo[1] = "Levemente Ativo";
		nivelAtivCombo[2] = "Moderadamente Ativo";
		nivelAtivCombo[3] = "Bastante Ativo";
		nivelAtivCombo[4] = "Muito Ativo";
		DefaultComboBoxModel<String> modelCombo = new DefaultComboBoxModel<>(nivelAtivCombo);

		cbNivelAtivi.setModel(modelCombo);
		cbNivelAtivi.setBounds(15, 242, 295, 31);
		pnlEsquerda.add(cbNivelAtivi);
		

		pnlTitulo.setBounds(0, 0, 800, 100);
		lblNome.setBounds(15, 38, 50, 50);
		lblSexo.setBounds(15, 70, 50, 50);
		lblPeso.setBounds(15, 99, 50, 50);
		lblAltura.setBounds(15, 131, 50, 50);
		lblIdade.setBounds(15, 167, 130, 36);
		lblNivelDeAtividade.setBounds(15, 192, 150, 50);
		txtNome.setBounds(60, 52, 250, 25);
		txtId.setBounds(60, 23, 50, 25);
		txtAltura.setBounds(60, 146, 50, 25);
		txtDtNasc.setBounds(130, 174, 98, 25);
		radioHomem.setBounds(60, 86, 70, 20);
		radioMulher.setBounds(130, 86, 70, 20);
		btnSalvar.setBounds(15, 284, 130, 50);
		lblBoaforma.setBounds(60, 0, 200, 100);
		
		lblBoaforma.setFont(Arial);
		pnlEsquerda.add(lblNome);
		pnlEsquerda.add(lblSexo);
		pnlEsquerda.add(lblPeso);
		pnlEsquerda.add(lblAltura);
		pnlEsquerda.add(lblIdade);
		pnlEsquerda.add(lblNivelDeAtividade);
		pnlEsquerda.add(txtNome);
		pnlEsquerda.add(txtId);
		pnlEsquerda.add(txtAltura);
		pnlEsquerda.add(txtDtNasc);
		pnlEsquerda.add(radioHomem);
		pnlEsquerda.add(radioMulher);
		pnlEsquerda.add(btnSalvar);
		pnlTitulo.add(lblBoaforma);
		group.add(radioHomem);
		group.add(radioMulher);
		radioHomem.setActionCommand("Homem");
		radioMulher.setActionCommand("Mulher");
		radioHomem.setSelected(true);
		
		JButton btnSair = new JButton();
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSair.setIcon(new ImageIcon(FrmTela.class.getResource("/br/senai/sp/jandira/imagens/sair.png")));
		btnSair.setBounds(180, 284, 130, 50);
		pnlEsquerda.add(btnSair);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setBounds(15, 27, 46, 14);
		pnlEsquerda.add(lblId);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(60, 115, 50, 25);
		pnlEsquerda.add(txtPeso);
		 
		
		JPanel pnlDireita = new JPanel();
		pnlDireita.setBackground(new Color(245, 222, 179));
		pnlDireita.setLayout(null);
		pnlDireita.setBorder(BorderFactory.createTitledBorder("Resultado:"));
		pnlDireita.setBounds(350, 110, 420, 345);
		getContentPane().add(pnlDireita);
		
		JLabel lblNome1 = new JLabel("Nome:");
		lblNome1.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblPeso1 = new JLabel("Peso:");
		lblPeso1.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblAltura1 = new JLabel("Altura:");
		lblAltura1.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblIdade1 = new JLabel("Idade:");
		lblIdade1.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblNivelDeAtividade1 = new JLabel(" N\u00EDvel de atividade:");
		lblNivelDeAtividade1.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblImc = new JLabel("  IMC:");
		lblImc.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setFont(new Font("Arial", Font.PLAIN, 12));
		JTextArea txtImc = new JTextArea();
		txtImc.setBackground(new Color(255, 255, 255));
		txtImc.setEditable(false);
		Cliente cliente = new Cliente();
		JLabel lblNomeResposta = new JLabel();
		JLabel lblPesoResposta = new JLabel();
		JLabel lblAlturaResposta = new JLabel();
		JLabel lblIdadeResposta = new JLabel();
		JLabel lblNivelAtividadeRespota = new JLabel ();
		JLabel lblImcResposta = new JLabel ();
		JLabel lblTmbResposta = new JLabel ();
		JLabel lblFcmResposta = new JLabel ();

		
		pnlDireita.add(lblNome1);
		pnlDireita.add(lblPeso1);
		pnlDireita.add(lblAltura1);
		pnlDireita.add(lblIdade1);
		pnlDireita.add(lblNivelDeAtividade1);
		pnlDireita.add(lblImc);
		pnlDireita.add(lblTmb);
		pnlDireita.add(lblFcm);
		pnlDireita.add(txtImc);
		pnlDireita.add(lblNomeResposta);
		pnlDireita.add(lblPesoResposta);
		pnlDireita.add(lblIdadeResposta);
		pnlDireita.add(lblAlturaResposta);
		pnlDireita.add(lblNivelAtividadeRespota);
		pnlDireita.add(lblImcResposta);
		pnlDireita.add(lblFcmResposta);
		pnlDireita.add(lblTmbResposta);
		
		lblNome1.setBounds(10, 18, 50, 50);
		lblPeso1.setBounds(14, 108, 50, 50); 
		lblAltura1.setBounds(12, 78, 50, 50);
		lblIdade1.setBounds(12, 48, 50, 50);
		lblNivelDeAtividade1.setBounds(10, 139, 100, 36);
		lblImc.setBounds(10, 158, 100, 50);
		lblTmb.setBounds(21, 284, 27, 50);
		lblFcm.setBounds(21, 258, 39, 50);
		txtImc.setBounds(87, 200, 250, 75);
		lblNomeResposta.setBounds(145, 10, 50, 50);
		lblPesoResposta.setBounds(145, 100, 50, 50);
		lblIdadeResposta.setBounds(145, 40, 50, 50);
		lblAlturaResposta.setBounds(145, 70, 50, 50);
		lblNivelAtividadeRespota.setBounds(131, 130, 250, 50);
		lblImcResposta.setBounds(145, 164, 100, 25);
		lblTmbResposta.setBounds(87, 306, 100, 19);
		lblFcmResposta.setBounds(87, 276, 100, 19);
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				cliente.setNome(txtNome.getText());
				cliente.setSexo(group.getSelection().getActionCommand());
				cliente.setPeso(Integer.parseInt(txtPeso.getText()));
				cliente.setAltura(Integer.parseInt(txtAltura.getText()));
				cliente.setIdade(Integer.parseInt(txtDtNasc.getText()));
				cliente.calcImc();
				cliente.getImc();
				cliente.calcFcm();
				cliente.calcTmb();

				lblNomeResposta.setText(cliente.getNome());
				lblAlturaResposta.setText(String.valueOf(cliente.getAltura()));
				lblPesoResposta.setText(String.valueOf(cliente.getPeso()));
				lblIdadeResposta.setText(String.valueOf(cliente.getIdade()));
				lblNivelAtividadeRespota.setText(cbNivelAtivi.getSelectedItem().toString());
				txtImc.setText(String.valueOf(cliente.calcImc()));
				lblImcResposta.setText(dfUmCasa.format(cliente.getImc()));
				lblFcmResposta.setText(dfSemCasa.format(cliente.calcFcm()));
				lblTmbResposta.setText(dfSemCasa.format(cliente.getTmb()));
				
				
				
			}
		});
		
			
		
		setVisible(true);
	}
}
