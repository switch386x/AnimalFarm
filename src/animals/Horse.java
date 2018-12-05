package animals;

import types.Size;

/**
 * No magic here ;)
 * 
 * @author MMOSCINS
 */
public class Horse extends Animal {

	public Horse(String name, Size size, int age) {
		super(name, size, age);
	}

	public Horse(String name, Size size) {
		super(name, size);
	}

	public Horse(String name) {
		super(name);
	}

	@Override
	protected String getSpecies() {
		return "a horse";
	}

	@Override
	public String toString() {
		return super.toString() + "\nNEIGH! WHINNY!\n";
	}

	@Override
	public Animal copy() {
		return new Horse(this.name, this.size, this.age);
	}
}
