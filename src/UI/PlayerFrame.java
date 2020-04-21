package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Blob.ABlob;
import Game.Game;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;

public class PlayerFrame extends JFrame {
	private JLabel lblScore;
	private JLabel lblPlayerHP;

	public PlayerFrame() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 50, 800, 50);
		setUndecorated(true);
		setBackground(Color.PINK);
		getContentPane().setLayout(null);
		
		lblScore = new JLabel("Player score: ");
		lblScore.setForeground(Color.BLUE);
		lblScore.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblScore.setBounds(10, 10, 169, 59);
		getContentPane().add(lblScore);
		
		lblPlayerHP = new JLabel("Player HP: ");
		lblPlayerHP.setForeground(Color.BLUE);
		lblPlayerHP.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPlayerHP.setBounds(221, 17, 169, 40);
		getContentPane().add(lblPlayerHP);
	}
	
	public void setScore (int score) {
		lblScore.setText("Player score: " + score);
	}
	
	public void setHP (int hp) {
		lblPlayerHP.setText("Player HP: " + hp);
	}
	
}
