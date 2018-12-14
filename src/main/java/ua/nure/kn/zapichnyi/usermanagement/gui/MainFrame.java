package ua.nure.kn.zapichnyi.usermanagement.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final int FRAME_HEIGHT = 600;
	private static final int FRAME_WIDTH = 800;
	private JPanel  contentPanel;
	private JPanel browserPanel;

	public MainFrame() {
		super();
		initialize();
	}

	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.setTitle("���������� ��������������");
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

}