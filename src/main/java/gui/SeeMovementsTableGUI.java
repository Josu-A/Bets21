package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementationModelAdapter;
import domain.User;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class SeeMovementsTableGUI extends JFrame {
	private JTable table;
	
	public SeeMovementsTableGUI(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mugimenduak");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		BLFacade facade = MainGUI.getBusinessLogic();
		AbstractTableModel model = new BLFacadeImplementationModelAdapter(facade, u);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
	}

}
