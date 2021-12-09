import java.util.Arrays;
import java.util.List;

import utils.OperationMarsUtil;

public class Main {

	public static void main(String[] args) {
		OperationMarsUtil operationMarsUtil = new OperationMarsUtil();

		Integer maxHorizontalCoordinates = 0;
		Integer maxVerticalCoordinates = 0;

		String commandFromEarth = "5 5\r\n1 2 N\r\nLMLMLMLM\r\nM 3 3 E\r\nMMRMMRMRRM";
		System.out.println("Input:");
		System.out.println(commandFromEarth);
		System.out.println(" ");
		System.out.println("Output:");

		List<String> lines = Arrays.asList(commandFromEarth.split("\\r?\\n"));
		operationMarsUtil.processCommand(
				operationMarsUtil.createPlateau(maxHorizontalCoordinates, maxVerticalCoordinates, lines.get(0)), lines);
	}

}
