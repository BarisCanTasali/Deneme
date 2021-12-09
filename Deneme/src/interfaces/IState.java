package interfaces;

import models.Coordinate;
import utils.CompassDirections;

public interface IState {

	Coordinate getCoordinates();

	void setCoordinates(Coordinate coordinate);

	CompassDirections getDirection();

	void setDirection(CompassDirections direction);
}
