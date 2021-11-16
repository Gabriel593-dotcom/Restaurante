package restaurante.application.entities;

import restaurante.application.enums.StatusTable;

public class Table {

	private final Integer numTable;
	private StatusTable statusTable;

	protected Table(Integer numTable, StatusTable statusTable) {
		this.numTable = numTable;
		this.statusTable = statusTable;
	}

	public Integer getNumTable() {
		return numTable;
	}

	public StatusTable getStatusTable() {
		return this.statusTable;
	}

	public void setStatusTable(StatusTable statusTable) {
		this.statusTable = statusTable;
	}

}
