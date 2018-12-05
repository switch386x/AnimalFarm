package animals;

import types.Size;

/**
 * No magic here ;)
 * 
 * @author MMOSCINS
 */
public class Pig extends Animal {

	public Pig(String name, Size size, int age) {
		super(name, size, age);
	}

	public Pig(String name, Size size) {
		super(name, size);
	}

	public Pig(String name) {
		super(name);
	}

	@Override
	protected String getSpecies() {
		return "a pig";
	}

	@Override
	public String toString() {
		return super.toString() + "\nOINK OINK!\n";
	}

	@Override
	public Animal copy() {
		return new Pig(this.name, this.size, this.age);
	}
}
