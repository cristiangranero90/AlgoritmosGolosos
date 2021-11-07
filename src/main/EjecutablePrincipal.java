package main;

import java.awt.EventQueue;

import view.CampeonatoWindow;

public class EjecutablePrincipal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CampeonatoWindow window = new CampeonatoWindow();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
