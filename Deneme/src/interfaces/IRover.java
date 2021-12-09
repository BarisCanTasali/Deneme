package interfaces;
import models.State;

public interface IRover {
	State getState();

	void setState(State state);

	String getName();

	void setName(String name);
}
