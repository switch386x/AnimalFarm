package animals;

import types.Size;

/**
 * No magic here ;)
 * 
 * @author MMOSCINS
 */
public class Dog extends Animal {

	public Dog(String name, Size size, int age) {
		super(name, size, age);
	}

	public Dog(String name, Size size) {
		super(name, size);
	}

	public Dog(String name) {
		super(name);
	}

	@Override
	protected String getSpecies() {
		return "a dog";
	}

	@Override
	public String toString() {
		return super.toString() + "\nI AM A GOOD BOI\n";
	}

	@Override
	public Animal copy() {
		return new Dog(this.name, this.size, this.age);
	}
}
