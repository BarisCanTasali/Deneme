package models;

import interfaces.IState;
import utils.CompassDirections;

public class State implements IState {
	Coordinate coordinate;
	CompassDirections direction;

	public State(Coordinate coordinate, CompassDirections direction) {
		this.coordinate = coordinate;
		this.direction = direction;
	}

	@Override
	public Coordinate getCoordinates() {
		return coordinate;
	}

	@Override
	public void setCoordinates(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public CompassDirections getDirection() {
		return this.direction;
	}

	@Override
	public void setDirection(CompassDirections direction) {
		this.direction = direction;
	}
}
