package com.bsuir.epam.lab.core.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame{
 
	private Human human = new Human();
	private String str = null;
	
	private JButton button1 = new JButton("Ïðèãîòîâèòü åäó");
	private JButton button2 = new JButton("Íêîèñàòü êîä");
	private JButton button3 = new JButton("àòêîêî");
	private JButton button4 = new JButton("Íàïèîä");
	
	private ActionListener action1 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			e = human.getName().moveFluid(e);
		}
	};
	private ActionListener action2 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			human.getName().boughtD();
		}
	};
	
	Window(String name){
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 250);
		setLocation(400, 400);
		setVisible(true);
		this.getContentPane().setLayout(new GridLayout(4, 1, 20, 20));
		
		getContentPane().add(button1);
		getContentPane().add(button2);
		
		button1.addActionListener(action1);
		button2.addActionListener(action2);
	}
}