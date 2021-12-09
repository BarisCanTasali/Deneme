package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import models.Coordinate;
import models.Move;
import models.Plateau;
import models.Rover;
import models.State;

public class OperationMarsUtil {
	public Integer nameSequence = 0;

	public void processCommand(Plateau plateau, List<String> lines) {
		List<Rover> roverList = new ArrayList<Rover>();
		String roverDeployedDirection;
		boolean isRoverDeployed;
		Rover selectedRover = null;

		for (int i = 1; i < lines.size(); i++) {
			Coordinate roverInitialCoordinate = null;
			roverDeployedDirection = "";
			isRoverDeployed = false;
			if (!roverList.isEmpty()) {
				selectedRover = roverList.get(roverList.size() - 1);
			}
			List<String> letters = Arrays.asList(lines.get(i).split(" "));
			for (int a = 0; a < letters.size(); a++) {
				Pattern digitPattern = Pattern.compile(".*[0-9].*");
				if (digitPattern.matcher(letters.get(a)).matches()) {
					roverInitialCoordinate = prepareNewRover(selectedRover, roverInitialCoordinate, letters.get(a));
				} else {
					deployOrMoveRover(roverInitialCoordinate, isRoverDeployed, roverDeployedDirection, nameSequence,
							roverList, selectedRover, letters.get(a));
				}
			}
		}
		printRoversLastState(roverList);
	}

	private void printRoversLastState(List<Rover> roverList) {
		for (Rover rover : roverList) {
			StringBuilder sb = new StringBuilder();
			sb.append(rover.getName());
			sb.append(" ");
			sb.append(rover.getState().getCoordinates().getHorizontal().toString());
			sb.append(" ");
			sb.append(rover.getState().getCoordinates().getVertical().toString());
			sb.append(" ");
			sb.append(rover.getState().getDirection().getShortCode());

			System.out.println(sb.toString());
		}
	}

	private void deployOrMoveRover(Coordinate roverInitialCoordinate, boolean isRoverDeployed,
			String roverDeployedDirection, Integer nameSequence, List<Rover> roverList, Rover selectedRover,
			String letter) {
		if (roverInitialCoordinate != null && roverInitialCoordinate.getHorizontal() != null
				&& roverInitialCoordinate.getVertical() != null && !isRoverDeployed) {
			roverDeployedDirection = letter;
			isRoverDeployed = true;
			this.nameSequence = this.nameSequence + 1;

			roverList.add(createRover(this.nameSequence, roverInitialCoordinate,
					CompassDirections.getCompassDirectionFromCode(roverDeployedDirection)));
		} else if (selectedRover != null) {
			turnOrMove(selectedRover, letter);
		}
	}

	private void turnOrMove(Rover selectedRover, String letter) {
		Move move = new Move();
		char[] ch = letter.toCharArray();
		for (int b = 0; b < ch.length; b++) {
			if ('L' == ch[b]) {
				selectedRover.setState(move.turnLeft(selectedRover.getState()));
			} else if ('R' == ch[b]) {
				selectedRover.setState(move.turnRight(selectedRover.getState()));
			} else if ('M' == ch[b]) {
				selectedRover.setState(move.moveForward(selectedRover.getState()));
			}
		}
	}

	private Coordinate prepareNewRover(Rover selectedRover, Coordinate roverInitialCoordinate, String letter) {
		selectedRover = null;
		if (roverInitialCoordinate == null) {
			roverInitialCoordinate = new Coordinate(null, null);
		}
		setCoordinates(roverInitialCoordinate, letter);
		return roverInitialCoordinate;
	}

	private Rover createRover(Integer nameSequence, Coordinate roverInitialCoordinate,
			CompassDirections compassDirections) {
		State state = new State(
				new Coordinate(roverInitialCoordinate.getHorizontal(), roverInitialCoordinate.getVertical()),
				compassDirections);
		Rover rover = new Rover(state, findRoverName(nameSequence));
		roverInitialCoordinate = null;
		return rover;
	}

	private void setCoordinates(Coordinate coordinate, String letter) {
		if (coordinate.getHorizontal() == null) {
			coordinate.setHorizontal(Integer.valueOf(letter));
		} else {
			coordinate.setVertical(Integer.valueOf(letter));
		}
	}

	private String findRoverName(Integer nameSequence) {
		StringBuilder sb = new StringBuilder();
		sb.append("Rover");
		sb.append(nameSequence.toString());
		return sb.toString();
	}

	public Plateau createPlateau(Integer maxHorizontalCoordinates, Integer maxVerticalCoordinates, String boundiries) {
		List<String> newBoundaries = Arrays.asList(boundiries.split(" "));
		return new Plateau(Integer.valueOf(newBoundaries.get(0)), Integer.valueOf(newBoundaries.get(1)));
	}

}
