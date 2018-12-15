package ua.nure.kn.zapichnyi.usermanagement.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.nure.kn.zapichnyi.usermanagement.util.Messages;

public class MainFrame extends JFrame {
	private static final int FRAME_HEIGHT = 600;
	private static final int FRAME_WIDTH = 800;
	private JPanel  contentPanel;
	private JPanel browserPanel;
	private AddPanel addPanel;

	public MainFrame() {
		super();
		initialize();
	}

	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.setTitle(Messages.getString("MainFrame.user_nanagement")); //$NON-NLS-1$
		this.setContentPane(getContentPanel());
		
		
	}

	private Container getContentPanel() {
		if(contentPanel==null) {
			contentPanel= new JPanel();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.add(getBrowsePanel(),BorderLayout.CENTER);
		}
		return contentPanel;
	}

	private JPanel getBrowsePanel() {
		if(browserPanel==null) {
			browserPanel= new BrowsePanel(this);
		}
		return browserPanel;
	}

	public static void main(String[] args) {
	MainFrame frame = new MainFrame();
	frame.setVisible(true);
	

	}

	public void showAddPanel() {
	showPanel(getAddPanel());	
		
	}

	public void showBrowsePanel() {
		showPanel(getBrowsePanel());
	}

	private void showPanel(JPanel panel) {
		
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		panel.repaint();
	}

	private AddPanel getAddPanel() {
		if(addPanel== null) {
		addPanel = new AddPanel(this);
		}
		return addPanel;
	}

}
