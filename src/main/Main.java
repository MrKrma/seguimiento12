package main;

import java.util.Scanner;

import model.BankLine;

public class Main {
	public static Scanner s = new Scanner(System.in);
	public static BankLine line;

	public static void main(String[] args) {
		line = new BankLine();
		int option = 1;
		do {
			option = mainMenu();
			options(option);
		}while(option != 0);

	}
	
	public static int mainMenu() {
		int option = 0;
		System.out.println("\nElegir una opción: "+ 
						   "\n(1) Dar turno"+
						   "\n(2) Mostrar turno"+
						   "\n(3) Pasar turno"+
						   "\n(4) Eliminar turno actual"+
						   "\n(0) Salir");
		option = s.nextInt();
		s.nextLine();
		return option;
	}
	
	public static void options(int option) {
		int turn;
		switch (option) {
		case 1:
			turn = line.lastTurn()+1;
			addTurn(turn);
			System.out.println("\nEl turno es: " + turn);
			break;
		case 2:
			System.out.println(theTurn());
			break;
		case 3:
			nextTurn();
			System.out.println(theTurn());
			break;
		case 4:
			System.out.println("Ingrese el número del turno a eliminar");
			turn = s.nextInt();
			s.nextLine();
			deleteTurn(turn);
			break;
		case 0:
			System.out.println(seeLine());
			break;
		default:
			System.out.println("\nOpción no validad");
			break;
		}
	}
	
	public static String seeLine() {
		return line.print();
	}
	
	public static void addTurn(int num) {
		line.addNode(num);
	}
	
	public static String theTurn() {
		return "\nEl turno es: "+line.theTurn();
	}
	
	public static void nextTurn() {
		line.nextTurn();
	}
	
	public static void deleteTurn(int value) {
		if(line.deleteTurn(value)) {
			System.out.println("\nEliminado con exito");
		}else {
			System.out.println("\nEl turno no existe");
		}
	}
}
