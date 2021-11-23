package restaurante.application.enums;

public enum StatusTable {
	RESERVED("Reservada"), FREE("Livre");

	private String status;

	private StatusTable(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public static String value(String status) {
		for (StatusTable s : StatusTable.values()) {
			if (s.getStatus() == status) {
				return status;
			}
		}

		throw new IllegalArgumentException();
	}
}
