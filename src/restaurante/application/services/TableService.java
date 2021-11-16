package restaurante.application.services;

import restaurante.application.entities.Table;
import restaurante.application.enums.StatusTable;

public class TableService {

	public static void reserveTable(Table table) {
		Boolean statusTable = tableIsFree(table);
		if (statusTable) {
			table.setStatusTable(StatusTable.RESERVED);
			System.out.println("Mesa reservada com sucesso!");
		} else {
			System.out.println("A mesa já está reservada.");
		}
	}

	public static void vacateTable(Table table) {
		Boolean statusTable = tableIsFree(table);
		if (!statusTable) {
			table.setStatusTable(StatusTable.FREE);
			System.out.println("Mesa desocupada com sucesso!");
		} else {
			System.out.println("Essa mesa já está livre.");
		}
	}

	public static Boolean tableIsFree(Table table) {
		if (table.getStatusTable().equals(StatusTable.FREE)) {
			return true;
		} else {
			return false;
		}
	}
}
