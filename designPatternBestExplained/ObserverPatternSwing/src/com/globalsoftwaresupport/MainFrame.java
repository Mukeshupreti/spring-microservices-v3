package com.globalsoftwaresupport;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ClickListener {
	
	private TextPanel textPanel;
	private Toolbar toolbar;
	
	public MainFrame() {
		super("Action Listener Pattern");
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		toolbar.setClickListener(this);
		textPanel = new TextPanel();
		
		add(toolbar, BorderLayout.SOUTH);
		add(textPanel, BorderLayout.CENTER);
		
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void clicked() {
		textPanel.addText();
	}
}
