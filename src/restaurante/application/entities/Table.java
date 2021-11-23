package restaurante.application.entities;

import restaurante.application.enums.StatusTable;

public class Table {

	private final Integer numTable;
	private String statusTable;

	protected Table(Integer numTable, StatusTable statusTable) {
		this.numTable = numTable;
		setStatusTable(statusTable);
	}

	public Integer getNumTable() {
		return numTable;
	}

	public String getStatusTable() {
		return StatusTable.value(statusTable);
	}

	public void setStatusTable(StatusTable statusTable) {
		this.statusTable = statusTable.getStatus();
	}

}
