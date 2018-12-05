package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import animals.Animal;
import animals.Dog;
import animals.Horse;
import animals.Penguin;
import animals.Pig;
import animals.Starfish;
import types.Size;

/**
 * @author MMOSCINS
 */
public final class FarmUtils {

	/**
	 * simply join all the animals (no string separator necessary) and return
	 * them as one string
	 */
	public static String printAnimals(List<Animal> animals) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < animals.size(); i++) {
			sb.append(animals.get(i));
		}
		return sb.toString();
	}

	/**
	 * same as above, but consider only the animals whose size matches the
	 * second input parameter
	 */
	public static String printAnimalsOfGivenSizes(List<Animal> animals, Size... sizes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getSize().in(sizes)) {
				sb.append(animal);
			}
		}
		return sb.toString();
	}

	/**
	 * return a list containing only the animals whose size matches the second
	 * input parameter
	 */
	public static List<Animal> getAnimalsOfGivenSizes(List<Animal> animals, Size... sizes) {
		List<Animal> result = new ArrayList<>();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getSize().in(sizes)) {
				result.add(animal);
			}
		}
		return result;
	}

	/**
	 * return the number of animals whose size matches the second input
	 * parameter
	 */
	public static int countAnimalsOfGivenSizes(List<Animal> animals, Size... sizes) {
		int result = 0;
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getSize().in(sizes)) {
				result++;
			}
		}
		return result;
	}

	/**
	 * return the sum of all the animals' age
	 */
	public static int sumAnimalsAge(List<Animal> animals) {
		int result = 0;
		for (int i = 0; i < animals.size(); i++) {
			result += animals.get(i).getAge();
		}
		return result;
	}

	/**
	 * return a list containing no identical animals
	 */
	public static List<Animal> removeDuplicates(List<Animal> animals) {
		List<Animal> result = new ArrayList<>();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (!result.contains(animal)) {
				result.add(animal);
			}
		}
		return result;
	}

	/**
	 * return a list containing elements whose indexes are greater or equal than
	 * start and smaller than end
	 */
	public static List<Animal> getMiddlePartOfList(List<Animal> animals, int start, int end) {
		List<Animal> result = new ArrayList<>();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (i >= start && i < end) {
				result.add(animal);
			}
		}
		return result;
	}

	/**
	 * return a Map containing entries: (0, animals.get(0)), (1, animals.get(1))
	 * etc.
	 */
	public static Map<Integer, Animal> numberAnimals(List<Animal> animals) {
		Map<Integer, Animal> result = new HashMap<>();
		for (int i = 0; i < animals.size(); i++) {
			result.put(i, animals.get(i));
		}
		return result;
	}

	/**
	 * return a Map whose keys are of type {@link Size} and values are lists of
	 * animals whose size matches the key
	 */
	public static Map<Size, List<Animal>> groupAnimalsBySize(List<Animal> animals) {
		Map<Size, List<Animal>> result = new HashMap<>();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (!result.containsKey(animal.getSize())) {
				result.put(animal.getSize(), new ArrayList<>());
			}
			result.get(animal.getSize()).add(animal);
		}
		return result;
	}

	/**
	 * return the oldest animal - if more than one exists, return the first of
	 * them
	 */
	public static Animal getOldestAnimal(List<Animal> animals) {
		Animal result = animals.get(0);
		int maxAge = result.getAge();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getAge() > maxAge) {
				maxAge = animal.getAge();
				result = animal;
			}
		}
		return result;
	}

	/**
	 * return the animal whose name is last in alphabetical order - if more than
	 * one exists, return the first of them
	 */
	public static Animal getLastAnimalAlphabetically(List<Animal> animals) {
		Animal result = animals.get(0);
		String lastNameAlphabetically = result.getName();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getName().compareTo(lastNameAlphabetically) > 0) {
				lastNameAlphabetically = animal.getName();
				result = animal;
			}
		}
		return result;
	}

	/**
	 * return the largest animal - if more than one exists, return the first of
	 * them
	 */
	public static Animal getLargestAnimal(List<Animal> animals) {
		Animal result = animals.get(0);
		Size maxSize = result.getSize();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getSize().compareTo(maxSize) > 0) {
				maxSize = animal.getSize();
				result = animal;
			}
		}
		return result;
	}

	/**
	 * return the youngest animal - if more than one exists, return the first of
	 * them
	 */
	public static Animal getYoungestAnimal(List<Animal> animals) {
		Animal result = animals.get(0);
		int minAge = result.getAge();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getAge() < minAge) {
				minAge = animal.getAge();
				result = animal;
			}
		}
		return result;
	}

	/**
	 * return the animal whose name is first in alphabetical order - if more
	 * than one exists, return the first of them
	 */
	public static Animal getFirstAnimalAlphabetically(List<Animal> animals) {
		Animal result = animals.get(0);
		String firstNameAlphabetically = result.getName();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getName().compareTo(firstNameAlphabetically) < 0) {
				firstNameAlphabetically = animal.getName();
				result = animal;
			}
		}
		return result;
	}

	/**
	 * return the smallest animal - if more than one exists, return the first of
	 * them
	 */
	public static Animal getSmallestAnimal(List<Animal> animals) {
		Animal result = animals.get(0);
		Size minSize = result.getSize();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getSize().compareTo(minSize) < 0) {
				minSize = animal.getSize();
				result = animal;
			}
		}
		return result;
	}

	/**
	 * return true if the name of any of the animals matches the second
	 * parameter
	 */
	public static boolean containsAnimalWithGivenName(List<Animal> animals, String name) {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * return true if the age of any of the animals matches the second parameter
	 */
	public static boolean containsAnimalOfGivenAge(List<Animal> animals, int age) {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getAge() == age) {
				return true;
			}
		}
		return false;
	}

	/**
	 * return true if the name of all the animals matches the second parameter
	 */
	public static boolean allAnimalsHaveGivenName(List<Animal> animals, String name) {
		for (int i = 0; i < animals.size(); i++) {
			if (!animals.get(i).getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * return true if the age of all the animals matches the second parameter
	 */
	public static boolean allAnimalsAreOfGivenAge(List<Animal> animals, int age) {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getAge() != age) {
				return false;
			}
		}
		return true;
	}

	/**
	 * return the first of the animals whose name matches the second parameter
	 */
	public static Animal getFirstAnimalWithGivenName(List<Animal> animals, String name) {
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getName().equals(name)) {
				return animal;
			}
		}
		return null;
	}

	/**
	 * return the first of the animals whose name matches the second parameter
	 */
	public static Animal getFirstAnimalOfGivenAge(List<Animal> animals, int age) {
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (animal.getAge() == age) {
				return animal;
			}
		}
		return null;
	}

	/**
	 * combine all the values of the map into one list of animals and then
	 * remove duplicates from it
	 */
	public static List<Animal> transformMapToListRemoveIdenticalElements(Map<Size, List<Animal>> animals) {
		List<Animal> result = new ArrayList<>();
		for (int i = 0; i < Size.values().length; i++) {
			if (animals.containsKey(Size.values()[i])) {
				List<Animal> innerAnimals = animals.get(Size.values()[i]);
				for (int j = 0; j < innerAnimals.size(); j++) {
					Animal animal = innerAnimals.get(j);
					if (!result.contains(animal)) {
						result.add(animal);
					}
				}
			}
		}
		return result;
	}

	/**
	 * "fuse" all the animals into one and return it. The implementation of the
	 * fuse method is essentially unimportant, although you're more than welcome
	 * to have a look.
	 */
	public static Animal fuseAnimals(List<Animal> animals) {
		Animal result = animals.get(0).copy();
		for (int i = 1; i < animals.size(); i++) {
			result = Animal.fuse(result, animals.get(i));
		}
		return result;
	}

	/**
	 * if all the elements of the list have the same size than return it, else
	 * return null
	 */
	public static Size getCommonSizeIfExistsOrElseNull(List<Animal> animals) {
		Size commonSize = null;
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (commonSize == null) {
				commonSize = animal.getSize();
			} else if (commonSize != animal.getSize()) {
				return null;
			}
		}
		return commonSize;
	}

	/**
	 * sort animals by name, last alphabetically first
	 */
	public static List<Animal> sortByNameNaturalOrdering(List<Animal> animals) {
		List<Animal> result = new ArrayList<>(animals);
		quickSortByNameNaturalOrdering(result, 0, result.size() - 1);
		return result;
	}

	private static void quickSortByNameNaturalOrdering(List<Animal> animals, int begin, int end) {
		if (begin < end) {
			int pivot = partitionByNameNaturalOrdering(animals, begin, end);
			quickSortByNameNaturalOrdering(animals, begin, pivot - 1);
			quickSortByNameNaturalOrdering(animals, pivot + 1, end);
		}

	}

	private static int partitionByNameNaturalOrdering(List<Animal> animals, int begin, int end) {
		Animal middle = animals.get(begin);
		int i = begin;

		for (int j = begin + 1; j <= end; j++)
			if (animals.get(j).getName().compareTo(middle.getName()) > 0) {
				i = i + 1;
				swap(animals, i, j);
			}
		swap(animals, i, begin);
		return i;
	}

	/**
	 * sort animals by name, first alphabetically first
	 */
	public static List<Animal> sortByNameReversedOrdering(List<Animal> animals) {
		List<Animal> result = new ArrayList<>(animals);
		quickSortByNameReversedOrdering(result, 0, result.size() - 1);
		return result;
	}

	private static void quickSortByNameReversedOrdering(List<Animal> animals, int begin, int end) {
		if (begin < end) {
			int pivot = partitionByNameReversedOrdering(animals, begin, end);
			quickSortByNameReversedOrdering(animals, begin, pivot - 1);
			quickSortByNameReversedOrdering(animals, pivot + 1, end);
		}

	}

	private static int partitionByNameReversedOrdering(List<Animal> animals, int begin, int end) {
		Animal middle = animals.get(begin);
		int i = begin;

		for (int j = begin + 1; j <= end; j++)
			if (animals.get(j).getName().compareTo(middle.getName()) < 0) {
				i = i + 1;
				swap(animals, i, j);
			}
		swap(animals, i, begin);
		return i;
	}

	/**
	 * sort animals by size, greatest first
	 */
	public static List<Animal> sortBySizeNaturalOrdering(List<Animal> animals) {
		List<Animal> result = new ArrayList<>(animals);
		quickSortBySizeNaturalOrdering(result, 0, result.size() - 1);
		return result;
	}

	private static void quickSortBySizeNaturalOrdering(List<Animal> animals, int begin, int end) {
		if (begin < end) {
			int pivot = partitionBySizeNaturalOrdering(animals, begin, end);
			quickSortBySizeNaturalOrdering(animals, begin, pivot - 1);
			quickSortBySizeNaturalOrdering(animals, pivot + 1, end);
		}

	}

	private static int partitionBySizeNaturalOrdering(List<Animal> animals, int begin, int end) {
		Animal middle = animals.get(begin);
		int i = begin;

		for (int j = begin + 1; j <= end; j++)
			if (animals.get(j).getSize().compareTo(middle.getSize()) > 0) {
				i = i + 1;
				swap(animals, i, j);
			}
		swap(animals, i, begin);
		return i;
	}

	/**
	 * sort animals by size, smallest first
	 */
	public static List<Animal> sortBySizeReversedOrdering(List<Animal> animals) {
		List<Animal> result = new ArrayList<>(animals);
		quickSortBySizeReversedOrdering(result, 0, result.size() - 1);
		return result;
	}

	private static void quickSortBySizeReversedOrdering(List<Animal> animals, int begin, int end) {
		if (begin < end) {
			int pivot = partitionBySizeReversedOrdering(animals, begin, end);
			quickSortBySizeReversedOrdering(animals, begin, pivot - 1);
			quickSortBySizeReversedOrdering(animals, pivot + 1, end);
		}

	}

	private static int partitionBySizeReversedOrdering(List<Animal> animals, int begin, int end) {
		Animal middle = animals.get(begin);
		int i = begin;

		for (int j = begin + 1; j <= end; j++)
			if (animals.get(j).getSize().compareTo(middle.getSize()) < 0) {
				i = i + 1;
				swap(animals, i, j);
			}
		swap(animals, i, begin);
		return i;
	}

	/**
	 * sort animals by age, oldest first
	 */
	public static List<Animal> sortByAgeNaturalOrdering(List<Animal> animals) {
		List<Animal> result = new ArrayList<>(animals);
		quickSortByAgeNaturalOrdering(result, 0, result.size() - 1);
		return result;
	}

	private static void quickSortByAgeNaturalOrdering(List<Animal> animals, int begin, int end) {
		if (begin < end) {
			int pivot = partitionByAgeNaturalOrdering(animals, begin, end);
			quickSortByAgeNaturalOrdering(animals, begin, pivot - 1);
			quickSortByAgeNaturalOrdering(animals, pivot + 1, end);
		}

	}

	private static int partitionByAgeNaturalOrdering(List<Animal> animals, int begin, int end) {
		Animal middle = animals.get(begin);
		int i = begin;

		for (int j = begin + 1; j <= end; j++)
			if (animals.get(j).getAge() > middle.getAge()) {
				i = i + 1;
				swap(animals, i, j);
			}
		swap(animals, i, begin);
		return i;
	}

	/**
	 * sort animals by age, youngest first
	 */
	public static List<Animal> sortByAgeReversedOrdering(List<Animal> animals) {
		List<Animal> result = new ArrayList<>(animals);
		quickSortByAgeReversedOrdering(result, 0, result.size() - 1);
		return result;
	}

	private static void quickSortByAgeReversedOrdering(List<Animal> animals, int begin, int end) {
		if (begin < end) {
			int pivot = partitionByAgeReversedOrdering(animals, begin, end);
			quickSortByAgeReversedOrdering(animals, begin, pivot - 1);
			quickSortByAgeReversedOrdering(animals, pivot + 1, end);
		}

	}

	private static int partitionByAgeReversedOrdering(List<Animal> animals, int begin, int end) {
		Animal middle = animals.get(begin);
		int i = begin;

		for (int j = begin + 1; j <= end; j++)
			if (animals.get(j).getAge() < middle.getAge()) {
				i = i + 1;
				swap(animals, i, j);
			}
		swap(animals, i, begin);
		return i;
	}

	private static void swap(List<Animal> animals, int i, int j) {
		Animal temp = animals.get(i);
		animals.set(i, animals.get(j));
		animals.set(j, temp);
	}

	/**
	 * create dogs with given names
	 */
	public static List<Dog> createDogs(List<String> names) {
		List<Dog> result = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			result.add(new Dog(names.get(i)));
		}
		return result;
	}

	/**
	 * create starfish with given names
	 */
	public static List<Starfish> createStarfish(List<String> names) {
		List<Starfish> result = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			result.add(new Starfish(names.get(i)));
		}
		return result;
	}

	/**
	 * create pigs with given names
	 */
	public static List<Pig> createPigs(List<String> names) {
		List<Pig> result = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			result.add(new Pig(names.get(i)));
		}
		return result;
	}

	/**
	 * create penguins with given names
	 */
	public static List<Penguin> createPenguins(List<String> names) {
		List<Penguin> result = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			result.add(new Penguin(names.get(i)));
		}
		return result;
	}

	/**
	 * create horses with given names
	 */
	public static List<Horse> createHorses(List<String> names) {
		List<Horse> result = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			result.add(new Horse(names.get(i)));
		}
		return result;
	}

}
