package models;
import interfaces.IRover;

public class Rover implements IRover {
	State state;
	String name;

	public Rover(State state, String name) {
		this.state = state;
		this.name = name;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
