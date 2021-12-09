package models;
import interfaces.ICoordinate;

public class Coordinate implements ICoordinate {
	Integer horizontal;
	Integer vertical;

	public Coordinate(Integer horizontal, Integer vertical) {
		this.horizontal = horizontal;
		this.vertical = vertical;
	}

	public Integer getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(Integer horizontal) {
		this.horizontal = horizontal;
	}

	public Integer getVertical() {
		return vertical;
	}

	public void setVertical(Integer vertical) {
		this.vertical = vertical;
	}
}
