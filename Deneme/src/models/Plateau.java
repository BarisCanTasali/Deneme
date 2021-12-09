package models;
import interfaces.IPlateau;

public class Plateau implements IPlateau {
	private Integer horizontalBoundary;
	private Integer verticalBoundary;

	public Plateau(Integer horizontalBoundary, Integer verticalBoundary) {
		this.horizontalBoundary = horizontalBoundary;
		this.verticalBoundary = verticalBoundary;
	}

	@Override
	public Integer getHorizontalBoundary() {
		return horizontalBoundary;
	}

	@Override
	public void setHorizontalBoundary(Integer horizontalBoundary) {
		this.horizontalBoundary = horizontalBoundary;
	}

	@Override
	public Integer getVerticalBoundary() {
		return verticalBoundary;
	}

	@Override
	public void setVerticalBoundary(Integer verticalBoundary) {
		this.verticalBoundary = verticalBoundary;
	}

}
