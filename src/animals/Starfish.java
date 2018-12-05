package animals;

import types.Size;

/**
 * No magic here ;)
 * 
 * @author MMOSCINS
 */
public class Starfish extends Animal {

	public Starfish(String name, Size size, int age) {
		super(name, size, age);
	}

	public Starfish(String name, Size size) {
		super(name, size);
	}

	public Starfish(String name) {
		super(name);
	}

	@Override
	protected String getSpecies() {
		return "a starfish";
	}

	@Override
	public String toString() {
		return super.toString() + "\nNO, THIS IS PATRICK\n";
	}

	@Override
	public Animal copy() {
		return new Starfish(this.name, this.size, this.age);
	}
}
