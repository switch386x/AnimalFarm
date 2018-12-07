package animals;

import types.Size;

/**
 * No magic here ;)
 * 
 * @author MMOSCINS
 */
public abstract class Animal {

	protected int age;
	protected String name;
	protected Size size;

	public Animal(String name) {
		this(name, Size.getRandomSize());
	}

	public Animal(String name, Size size) {
		this(name, size, getRandomAge());
	}

	public Animal(String name, Size size, int age) {
		this.name = name;
		this.size = size;
		this.age = age;
	}

	public static Animal fuse(Animal first, Animal second) {
		Animal copy = first.copy();
		copy.age += second.age;
		copy.name += second.name;
		copy.size = Size.max(first.size, second.size);
		return copy;
	}

	private static int getRandomAge() {
		// randomness achieved with a d20 roll.
		return 13;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public Size getSize() {
		return size;
	}

	protected abstract String getSpecies();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("This is ");
		sb.append(getSpecies());
		sb.append(". ");
		sb.append("It is called ");
		sb.append(name);
		sb.append(".");
		return sb.toString();
	}


	public abstract Animal copy();
}
