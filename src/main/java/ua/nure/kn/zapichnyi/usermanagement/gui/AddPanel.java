package ua.nure.kn.zapichnyi.usermanagement.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPanel extends JPanel implements ActionListener {
	private MainFrame parent;
	private JPanel buttonPanel;
	private JPanel fieldPanel;
	private JButton cancelButton;
	private JButton okButton;
	private JTextField dayOfBirthField;
	private JTextField lastNameField;
	private JTextField firstNameField;

public AddPanel(MainFrame parent) {
	this.parent= parent;
	initialize();
}
private void initialize() {
	this.setLayout(new BorderLayout());
	this.add(getFieldPanel(),BorderLayout.NORTH);
	this.add(getButtonPanel(),BorderLayout.SOUTH);
	
}
private JPanel getButtonPanel() {
	if(buttonPanel==null) {
	 buttonPanel= new JPanel();
	 buttonPanel.add(getOkButton(),null);
	 buttonPanel.add(getCancelButton(),null);
	} 
	return buttonPanel;
}
private JButton getCancelButton() {
	if(cancelButton==null) {
		cancelButton= new JButton();
		cancelButton.setText("������");
		cancelButton.setName("cancelButton");
	    cancelButton.setActionCommand("ok");
	    cancelButton.addActionListener(this);
	}
	
	return cancelButton;
}
private JButton getOkButton() {
if(okButton==null) {
	okButton= new JButton();
	okButton.setText("Ok");
	okButton.setName("okButton");
    okButton.setActionCommand("ok");
    okButton.addActionListener(this);
}
	return okButton;
}
private JPanel getFieldPanel() {
	if(fieldPanel==null) {
		 fieldPanel= new JPanel();
		 fieldPanel.setLayout(new GridLayout(3, 2));
	addLabeledField(fieldPanel,"���",getFirstNameField());
	addLabeledField(fieldPanel,"�������",getLastNameField());
	addLabeledField(fieldPanel,"���� ��������",getDayOfBirthField());
		
		} 
	return fieldPanel;
}
private JTextField getDayOfBirthField() {
	if(dayOfBirthField==null) {
		dayOfBirthField= new JTextField();
		dayOfBirthField.setName("dayOfBirthField");
		
	}
	return dayOfBirthField;
}
private JTextField getLastNameField() {
	if(lastNameField==null) {
		lastNameField= new JTextField();
		lastNameField.setName("lastNameField");
		
	}
	return lastNameField;
}
private JTextField getFirstNameField() {
	if(firstNameField==null) {
		firstNameField= new JTextField();
		firstNameField.setName("firstNameField");
		
	}
	return firstNameField;
}
private void addLabeledField(JPanel panel, String labelText, JTextField textField) {
JLabel label=new JLabel(labelText);
label.setLabelFor(textField);
panel.add(label);
panel.add(textField);


	
}


@Override
public void actionPerformed(ActionEvent e) {
	
	
}


}
