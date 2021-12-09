package models;

import utils.CompassDirections;

public class Move {
	public State turnLeft(State oldState) {
		State newState = new State(oldState.getCoordinates(), oldState.getDirection());
		newState.setDirection(CompassDirections.getNewCompassDirectionFromDegree(oldState.getDirection(), 90));
		return newState;
	}

	public State turnRight(State oldState) {
		State newState = new State(oldState.getCoordinates(), oldState.getDirection());
		newState.setDirection(CompassDirections.getNewCompassDirectionFromDegree(oldState.getDirection(), -90));
		return newState;
	}

	public State moveForward(State oldState) {
		State newState = new State(oldState.getCoordinates(), oldState.getDirection());
		Coordinate newCoordinate = new Coordinate(oldState.getCoordinates().getHorizontal(),
				oldState.getCoordinates().getVertical());
		if (oldState.getDirection().equals(CompassDirections.NORTH)) {
			newCoordinate.setVertical(oldState.getCoordinates().getVertical() + 1);
		} else if (oldState.getDirection().equals(CompassDirections.WEST)) {
			newCoordinate.setHorizontal(oldState.getCoordinates().getHorizontal() - 1);
		} else if (oldState.getDirection().equals(CompassDirections.SOUTH)) {
			newCoordinate.setVertical(oldState.getCoordinates().getVertical() - 1);
		} else {
			newCoordinate.setHorizontal(oldState.getCoordinates().getHorizontal() + 1);
		}
		newState.setCoordinates(newCoordinate);
		return newState;
	}

}
