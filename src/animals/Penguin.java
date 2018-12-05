package animals;

import types.Size;

/**
 * No magic here ;)
 * 
 * @author MMOSCINS
 */
public class Penguin extends Animal {

	public Penguin(String name, Size size, int age) {
		super(name, size, age);
	}

	public Penguin(String name, Size size) {
		super(name, size);
	}

	public Penguin(String name) {
		super(name);
	}

	@Override
	protected String getSpecies() {
		return "a penguin";
	}

	@Override
	public String toString() {
		return super.toString() + "\nCANNOT FLY :(\n";
	}

	@Override
	public Animal copy() {
		return new Penguin(this.name, this.size, this.age);
	}
}
