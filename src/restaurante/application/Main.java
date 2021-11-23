package restaurante.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import restaurante.application.entities.Table;
import restaurante.application.entities.TableFactory;
import static restaurante.application.services.TableService.*;

public class Main {

	private static List<Table> tables;

	public static void main(String[] args) {

		tables = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Integer numTable = 0;

		System.out.print("Quantas mesas temos hoje?: ");
		int numMesas = sc.nextInt();

		for (int i = 1; i <= numMesas; i++) {
			tables.add(TableFactory.insertTable(i));
		}

		printMenu();
		int choice = sc.nextInt();

		while (choice != 4) {
			switch (choice) {
			case 1:

				showTablesFree();

				System.out.print("Escolha uma mesa:");
				numTable = sc.nextInt();

				if (numTable < 1 || numTable > tables.size()) {
					System.out.println("Opção inválida.");
					printMenu();
					choice = sc.nextInt();
					break;
				} else {
					reserveTable(tables.get(numTable - 1));
					printMenu();
					choice = sc.nextInt();
					break;
				}

			case 2:
				printAllTables();
				System.out.print("Escolha a mesa que deseja desocupar:");
				numTable = sc.nextInt();

				if (numTable < 1 || numTable > tables.size()) {
					System.out.println("Opção inválida.");
					printMenu();
					choice = sc.nextInt();
					break;
				} else {
					vacateTable(tables.get(numTable - 1));
					printMenu();
					choice = sc.nextInt();
					break;
				}

			case 3:
				printAllTables();
				printMenu();
				choice = sc.nextInt();
				break;
			}
		}

		System.out.println("Até mais!");
		sc.close();

	}

	public static void printMenu() {
		System.out.println();
		System.out.println("+--------------MENU-----------+");
		System.out.println("| 1 - Reservar mesa.          |");
		System.out.println("| 2 - Desocupar mesa.         |");
		System.out.println("| 3 - Mostrar todas as mesas. |");
		System.out.println("| 4 - Sair.                   |");
		System.out.println("+-----------------------------+");
	}

	public static void showTablesFree() {
		System.out.println("-------MESAS LIVRES-------");
		for (Table t : tables) {
			if (tableIsFree(t)) {
				System.out.println("Mesa " + t.getNumTable());
			}
		}
	}

	public static void printAllTables() {
		for (Table t : tables) {
			System.out.println(t.getNumTable() + " - " + t.getStatusTable());
		}
	}
}
