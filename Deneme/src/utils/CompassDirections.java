package utils;

public enum CompassDirections {
	NORTH("N", 0), WEST("W", 90), SOUTH("S", 180), EAST("E", 270);

	private final String shortCode;
	private final Integer degree;

	CompassDirections(String shortCode, Integer degree) {
		this.shortCode = shortCode;
		this.degree = degree;
	}

	public String getShortCode() {
		return this.shortCode;
	}

	public Integer getDegree() {
		return this.degree;
	}

	public static CompassDirections getCompassDirectionFromCode(String shortCode) {
		for (CompassDirections direction : CompassDirections.values()) {
			if (shortCode.equals(direction.getShortCode())) {
				return direction;
			}
		}
		return null;
	}

	private static CompassDirections getCompassDirectionFromDegree(Integer degree) {
		for (CompassDirections direction : CompassDirections.values()) {
			if (degree.equals(direction.getDegree())) {
				return direction;
			}
		}
		return null;
	}

	public static CompassDirections getNewCompassDirectionFromDegree(CompassDirections oldDirection, Integer degree) {
		Integer newDegree = oldDirection.getDegree() + degree;
		if (newDegree > 270) {
			return CompassDirections.NORTH;
		} else if (newDegree < 0) {
			return CompassDirections.EAST;
		} else {
			return getCompassDirectionFromDegree(newDegree);
		}
	}

}
