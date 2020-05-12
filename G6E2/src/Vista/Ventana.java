package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exepciones.DepositoInvalidoException;
import Exepciones.ExtraccionInvalidaException;
import Modelo.Banco;
import Modelo.CuentaBancaria;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JTextField textField_Nombre;
	private JButton btn_Crear;
	private JScrollPane scrollPane;
	private JList<CuentaBancaria> list_Cuentas;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblNewLabel_CantidadDepo;
	private JTextField textField_Depositar;
	private JLabel lblNewLabel_Extraer;
	private JTextField textField_Extraer;
	private JButton btnNewButton_Depositar;
	private JButton btnNewButton_Extraccion;
	private JScrollPane scrollPane_1;
	private JList list_info;
	private Banco banco;
	private DefaultListModel<CuentaBancaria> modeloListaBanco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 448);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new GridLayout(0, 4, 0, 0));

		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_6 = new JPanel();
		this.panel_1.add(this.panel_6);
		this.panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.textField_Nombre = new JTextField();
		this.panel_6.add(this.textField_Nombre);
		this.textField_Nombre.setColumns(10);

		this.panel_5 = new JPanel();
		this.panel_1.add(this.panel_5);
		this.panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.btn_Crear = new JButton("Crear");
		this.btn_Crear.addActionListener(this);
		this.panel_5.add(this.btn_Crear);

		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2);
		this.panel_2.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.panel_2.add(this.scrollPane, BorderLayout.CENTER);

		this.list_Cuentas = new JList();
		this.scrollPane.setViewportView(this.list_Cuentas);

		this.panel_3 = new JPanel();
		this.panel.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_8 = new JPanel();
		this.panel_3.add(this.panel_8);
		this.panel_8.setLayout(new GridLayout(2, 2, 0, 0));

		this.panel_9 = new JPanel();
		this.panel_8.add(this.panel_9);

		this.lblNewLabel_CantidadDepo = new JLabel("Depositar");
		this.panel_9.add(this.lblNewLabel_CantidadDepo);

		this.panel_10 = new JPanel();
		this.panel_8.add(this.panel_10);

		this.textField_Depositar = new JTextField();
		this.panel_10.add(this.textField_Depositar);
		this.textField_Depositar.setColumns(10);

		this.panel_11 = new JPanel();
		this.panel_8.add(this.panel_11);

		this.lblNewLabel_Extraer = new JLabel("Extraer");
		this.panel_11.add(this.lblNewLabel_Extraer);

		this.panel_12 = new JPanel();
		this.panel_8.add(this.panel_12);

		this.textField_Extraer = new JTextField();
		this.textField_Extraer.setText("");
		this.panel_12.add(this.textField_Extraer);
		this.textField_Extraer.setColumns(10);

		this.panel_7 = new JPanel();
		this.panel_3.add(this.panel_7);

		this.btnNewButton_Extraccion = new JButton("Extraccion");
		this.btnNewButton_Extraccion.addActionListener(this);
		this.panel_7.add(this.btnNewButton_Extraccion);

		this.btnNewButton_Depositar = new JButton("Depositar");
		this.btnNewButton_Depositar.addActionListener(this);
		this.panel_7.add(this.btnNewButton_Depositar);

		this.panel_4 = new JPanel();
		this.panel.add(this.panel_4);
		this.panel_4.setLayout(new BorderLayout(0, 0));

		this.scrollPane_1 = new JScrollPane();
		this.panel_4.add(this.scrollPane_1, BorderLayout.CENTER);

		this.list_info = new JList();
		this.scrollPane_1.setViewportView(this.list_info);
		this.modeloListaBanco = new DefaultListModel<CuentaBancaria>();
		this.list_Cuentas.setModel(modeloListaBanco);

		banco = new Banco();

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Crear") && this.textField_Nombre.getText() != null) {
			this.banco.agregaCuenta(this.textField_Nombre.getText());
			this.textField_Nombre.setText("");
		} else {
			if (arg0.getActionCommand().equals("Depositar") && this.list_Cuentas.getSelectedValue() != null) {
				try {
					this.list_Cuentas.getSelectedValue()
							.depositar(Double.parseDouble(this.textField_Depositar.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DepositoInvalidoException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
				this.textField_Depositar.setText("");
			} else {
				if (arg0.getActionCommand().equals("Extraccion") && this.list_Cuentas.getSelectedValue() != null) {

					try {
						this.list_Cuentas.getSelectedValue()
								.extraer(Double.parseDouble(this.textField_Extraer.getText()));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExtraccionInvalidaException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage() + " Saldo: $" + e.getDato().getSaldo()
								+ " Cant a extraer: $" + e.getDato().getExtraccion_solicitada());
						System.out.println(e.getMessage() + " Saldo: $" + e.getDato().getSaldo() + " Cant a extraer: $"
								+ e.getDato().getExtraccion_solicitada());
					}
					this.textField_Extraer.setText("");
				}
			}

		}

		this.actualizarLista();
	}

	private void actualizarLista() {
		// TODO Auto-generated method stub
		this.modeloListaBanco.clear();
		Iterator<CuentaBancaria> it = banco.getListaBanco().iterator();
		while (it.hasNext())
			this.modeloListaBanco.addElement(it.next());
		this.repaint();
	}
}
