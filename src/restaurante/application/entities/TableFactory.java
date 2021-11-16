package restaurante.application.entities;

import restaurante.application.enums.StatusTable;

public class TableFactory {

	public static Table insertTable(Integer numMesa) {
		return new Table(numMesa, StatusTable.FREE);
	}
}
