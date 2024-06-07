package visao;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import controle.CalculadoraControle;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField txtSistemaDeBlocos;
	private JTextField massaATextField;
	private JTextField massaBTextField;
	private JTextField atritoATextField;
	private JTextField atritoBTextField;
	private JTextField forcaTextField;
	private JTextPane resultPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		
		setSize(new Dimension(900, 675));
		setResizable(false);
		setTitle("Sistema de blocos - Trabalho de física");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSistemaDeBlocos = new JTextField();
		txtSistemaDeBlocos.setEditable(false);
		txtSistemaDeBlocos.setHorizontalAlignment(SwingConstants.CENTER);
		txtSistemaDeBlocos.setForeground(Color.BLACK);
		txtSistemaDeBlocos.setBackground(Color.WHITE);
		txtSistemaDeBlocos.setFont(new Font("Leelawadee UI", Font.BOLD, 30));
		txtSistemaDeBlocos.setText("Calculadora de Sistema de Blocos ");
		txtSistemaDeBlocos.setBounds(193, 10, 500, 67);
		contentPane.add(txtSistemaDeBlocos);
		txtSistemaDeBlocos.setColumns(10);
		
		JLabel massaALabel = new JLabel("Massa do bloco A:");
		massaALabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		massaALabel.setBounds(10, 296, 173, 51);
		contentPane.add(massaALabel);
		
		massaATextField = new JTextField();
		massaATextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		massaATextField.setHorizontalAlignment(SwingConstants.CENTER);
		massaATextField.setText("0.0");
		massaATextField.setBounds(237, 304, 173, 45);
		contentPane.add(massaATextField);
		massaATextField.setColumns(10);
		
		massaBTextField = new JTextField();
		massaBTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		massaBTextField.setHorizontalAlignment(SwingConstants.CENTER);
		massaBTextField.setText("0.0");
		massaBTextField.setColumns(10);
		massaBTextField.setBounds(237, 365, 173, 45);
		contentPane.add(massaBTextField);
		
		JLabel massaBLabel_1 = new JLabel("Massa do bloco B:");
		massaBLabel_1.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		massaBLabel_1.setBounds(10, 357, 173, 51);
		contentPane.add(massaBLabel_1);
		
		JLabel atritoALabel = new JLabel("Força de atrito do bloco A:");
		atritoALabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		atritoALabel.setBounds(442, 296, 251, 51);
		contentPane.add(atritoALabel);
		
		atritoATextField = new JTextField();
		atritoATextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		atritoATextField.setHorizontalAlignment(SwingConstants.CENTER);
		atritoATextField.setText("0.0");
		atritoATextField.setColumns(10);
		atritoATextField.setBounds(703, 296, 173, 45);
		contentPane.add(atritoATextField);
		
		atritoBTextField = new JTextField();
		atritoBTextField.setHorizontalAlignment(SwingConstants.CENTER);
		atritoBTextField.setText("0.0");
		atritoBTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		atritoBTextField.setColumns(10);
		atritoBTextField.setBounds(703, 357, 173, 45);
		contentPane.add(atritoBTextField);
		
		JLabel atritoBLabel = new JLabel("Força de atrito do bloco B:");
		atritoBLabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		atritoBLabel.setBounds(442, 357, 251, 51);
		contentPane.add(atritoBLabel);
		
		JLabel forcaLabel = new JLabel("Força aplicada ao bloco:");
		forcaLabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		forcaLabel.setBounds(10, 418, 217, 51);
		contentPane.add(forcaLabel);
		
		forcaTextField = new JTextField();
		forcaTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		forcaTextField.setHorizontalAlignment(SwingConstants.CENTER);
		forcaTextField.setText("0.0");
		forcaTextField.setColumns(10);
		forcaTextField.setBounds(237, 426, 173, 45);
		contentPane.add(forcaTextField);
		
		JButton calcularButton = new JButton("Calcular");
		calcularButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calcularButton.setBounds(464, 422, 173, 53);
		calcularButton.addActionListener(new CalculadoraControle(this));
		contentPane.add(calcularButton);
		
		JButton limparButton = new JButton("Limpar");
		limparButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		limparButton.setBounds(664, 422, 173, 53);
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		contentPane.add(limparButton);
		
		resultPane = new JTextPane();
		resultPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		resultPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultPane.setText("Result:");
		resultPane.setBackground(Color.LIGHT_GRAY);
		resultPane.setForeground(Color.BLACK);
		resultPane.setBounds(10, 495, 866, 133);
		contentPane.add(resultPane);
		
		JTextArea txtrEstaUma = new JTextArea();
		txtrEstaUma.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		txtrEstaUma.setLineWrap(true);
		txtrEstaUma.setText("Esta é uma calculadora específica para a obtenção do valor da força que um bloco aplica em outro, considerando a força de atrito. Para isso, preencha os seguintes campos abaixo.\r\nEx: Existe um sistema de dois blocos, A e B, e o bloco A está sendo empurrado com uma força F, qual será a força aplicada de A em B? Considerando a força de atrito de ambos. ");
		txtrEstaUma.setBounds(10, 107, 866, 153);
		contentPane.add(txtrEstaUma);
	}
	
	private void limpar() {
		massaATextField.setText("0.0");
		massaBTextField.setText("0.0");
		atritoATextField.setText("0.0");
		atritoBTextField.setText("0.0");
		forcaTextField.setText("0.0");
		resultPane.setText("Result:");
	}
	
	public void calcular() {
		try {
			double massaA = Double.parseDouble(massaATextField.getText());
			double massaB = Double.parseDouble(massaBTextField.getText());
			double atritoA = Double.parseDouble(atritoATextField.getText());
			double atritoB = Double.parseDouble(atritoBTextField.getText());
			double forca = Double.parseDouble(forcaTextField.getText());
			
			double aceleracao = (forca - atritoA - atritoB) / (massaA + massaB);
			double forcaAB = -(massaA * aceleracao) - atritoA + forca;
			
			String resultado = String.format("Aceleração do sistema: %.2f m/s²\nForça de A em B: %.2f N", aceleracao, forcaAB);
			resultPane.setText(resultado);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
