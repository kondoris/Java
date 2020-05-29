package com.bsuir.epam.lab.core.gui;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class InfoWindow extends JFrame{
	InfoWindow(int numb){
		super("Information");
		this.setLocation(500, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 150);
		
		this.getContentPane().setLayout(new GridLayout(4, 1, 20, 20));
    if(numb == 1) {
		  JLabel txt1 = new JLabel("Ïðèãîòîâèòü åäó");
		  getContentPane().add(txt1);
    }
    if(numb == 2) {
		  JLabel txt2 = new JLabel("Íàêîðìèòü ïîâàðà");
		  getContentPane().add(txt2);
    }
	}
}