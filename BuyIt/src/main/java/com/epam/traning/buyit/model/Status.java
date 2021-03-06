package com.epam.traning.buyit.model;

public enum Status {
	BANNED("banned", true), UNBANNED("unbanned", false);

	private boolean type;
	private String status;

	Status(String status, boolean type) {
		this.status = status;
		this.type = type;
	}

	public boolean getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public static Status geRoleByStatus(String value) {
		Status result = null;
		for (Status temp : Status.values()) {
			if (temp.getStatus().equals(value)) {
				result = temp;
			}
		}
		return result;
	}

	public static Status geRoleByType(boolean value) {
		Status result = null;
		for (Status temp : Status.values()) {
			if (temp.getType() == value) {
				result = temp;
			}
		}
		return result;
	}

	public static boolean getTypeByRole(String value) {
		boolean result = false;
		for (Status temp : Status.values()) {
			if (temp.getStatus() == value) {
				result = temp.getType();
			}
		}
		return result;
	}
}
