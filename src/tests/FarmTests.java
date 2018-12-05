package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import animals.Animal;
import animals.Dog;
import animals.Horse;
import animals.Penguin;
import animals.Pig;
import animals.Starfish;
import types.Size;
import utils.FarmUtils;
import utils.FarmUtilsStreaming;

/**
 * 
 * TODO: TASK 0 (README)
 * 
 * This class consists of 35 JUnits that compare the respective results of
 * almost as many methods in classes {@link FarmUtils} and
 * {@link FarmUtilsStreaming}. Since the code in both classes is currently
 * identical all tests pass. Sadly, the code is (intentionally) pretty ugly -
 * all methods are written in the simplest (i.e. the least elegant) way I could
 * imagine and many of them are hideously repetitive.
 * 
 * Your mission, should you choose to accept it, will be to refactor the code in
 * {@link FarmUtilsStreaming}, with emphasis on the tools introduced with Java
 * 8, including (but not limited to):
 * <ul>
 * <li>Stream API
 * <li>Lambda expressions
 * <li>Method / Constructor reference
 * <li>Function
 * <li>Optional
 * <li>Predicate
 * </ul>
 * 
 * In addition, Java Generics may come in handy to reduce the number of methods
 * which only differ from one another by the type they accept as input / return
 * as result. Whichever other ways you can think of to reduce the amount of
 * unnecessary code and / or to improve its overall quality - feel free to do so
 * and show off ;)
 * 
 * Needless to say, it would be wise to run the tests often, since at the end of
 * your refactoring exercise all test should pass as well. For the purposes of
 * our test suite, two lists are considered equal if they contain the same
 * elements - however the order of those elements is normally not important
 * (apart from the {@link #checkAnimalsNotChanged}, {@link #testNumberAnimals},
 * {@link #testGetMiddlePartOfList} and all the sorting tests).
 * 
 * On a final note - spend as long as you like browsing all the classes of this
 * project - some parts of them you may even find to be slightly amusing ;)
 * However, do not change anything apart from the {@link FarmUtilsStreaming}
 * class and other places where specifically asked to do so.
 * 
 * @author MMOSCINS
 *
 */
public final class FarmTests {
	private static List<Animal> animals;
	private static List<Animal> backupAnimals;
	private static List<Animal> identicalAnimals;
	private static Map<Size, List<Animal>> animalsBySize;
	private static List<String> names;
	private static Size[] sizes = { Size.LARGE, Size.SMALL };
	private static int age;
	private static String name;
	private static int wrongAge;
	private static String wrongName;
	private static int start;
	private static int end;

	@BeforeClass
	public static void prepareAnimals() {
		Random random = new Random();
		List<Animal> smallAnimals = new ArrayList<>();
		List<Animal> mediumAnimals = new ArrayList<>();
		List<Animal> largeAnimals = new ArrayList<>();

		Dog fluffy = new Dog("Fluffy", Size.LARGE, 31);
		Dog butch = new Dog("Butch", Size.SMALL, 4);
		Dog clifford = new Dog("Clifford", Size.LARGE, 42);
		Penguin julius = new Penguin("Julius", Size.MEDIUM, 13);
		Penguin tiberius = new Penguin("Tiberius", Size.LARGE, 15);
		Penguin marcus = new Penguin("Marcus", Size.LARGE, 17);
		Pig babe = new Pig("Babe", Size.SMALL, 2);
		Pig porky = new Pig("Porky", Size.LARGE, 94);
		Pig piglet = new Pig("Piglet", Size.MEDIUM, 4);
		Starfish peter = new Starfish("Peter", Size.SMALL, 6);
		Starfish percy = new Starfish("Percy", Size.MEDIUM, 7);
		Starfish pedro = new Starfish("Pedro", Size.LARGE, 8);
		Horse famine = new Horse("Famine", Size.SMALL, 17);
		Horse death = new Horse("Death", Size.LARGE, 100);
		Horse pestilence = new Horse("Pestilence", Size.MEDIUM, 66);
		Horse war = new Horse("War", Size.LARGE, 45);

		smallAnimals.add(babe);
		smallAnimals.add(famine);
		smallAnimals.add(peter);
		smallAnimals.add(butch);

		mediumAnimals.add(pestilence);
		mediumAnimals.add(percy);
		mediumAnimals.add(julius);
		mediumAnimals.add(piglet);

		largeAnimals.add(fluffy);
		largeAnimals.add(clifford);
		largeAnimals.add(death);
		largeAnimals.add(tiberius);
		largeAnimals.add(marcus);
		largeAnimals.add(porky);
		largeAnimals.add(pedro);
		largeAnimals.add(war);

		animals = new ArrayList<>();
		animals.addAll(smallAnimals);
		animals.addAll(mediumAnimals);
		animals.addAll(largeAnimals);

		backupAnimals = new ArrayList<>();
		for (int i = 0; i < animals.size(); i++) {
			backupAnimals.add(animals.get(i).copy());
		}

		age = famine.getAge();
		name = famine.getName();
		wrongAge = -1;
		wrongName = "wrong";

		start = random.nextInt(animals.size());
		end = start + 1 + random.nextInt(animals.size() - start);
		Horse hugeFamine = new Horse(name, Size.HUGE, age);
		identicalAnimals = Collections.nCopies(5, hugeFamine);

		animalsBySize = new HashMap<>();
		animalsBySize.put(Size.SMALL, smallAnimals);
		animalsBySize.put(Size.MEDIUM, mediumAnimals);
		animalsBySize.put(Size.LARGE, largeAnimals);
		animalsBySize.put(Size.HUGE, identicalAnimals);

		names = new ArrayList<>();
		names.add("Huey");
		names.add("Duwey");
		names.add("Louie");
	}

	@Before
	public void checkAnimalsNotChanged() {
		assertEquals(animals, backupAnimals);
	}

	@Test
	public void testPrintAnimals() {
		assertEquals(FarmUtils.printAnimals(animals), FarmUtilsStreaming.printAnimals(animals));
	}

	@Test
	public void testPrintAnimalsOfGivenSizes() {
		assertEquals(FarmUtils.printAnimalsOfGivenSizes(animals, sizes),
				FarmUtilsStreaming.printAnimalsOfGivenSizes(animals, sizes));
	}

	@Test
	public void testGetAnimalsOfGivenSizes() {
		assertEqualLists(FarmUtils.getAnimalsOfGivenSizes(animals, sizes),
				FarmUtilsStreaming.getAnimalsOfGivenSizes(animals, sizes));
	}

	@Test
	public void testCountAnimalsOfGivenSizes() {
		assertEquals(FarmUtils.countAnimalsOfGivenSizes(animals, sizes),
				FarmUtilsStreaming.countAnimalsOfGivenSizes(animals, sizes));
	}

	@Test
	public void testSumAnimalsAge() {
		assertEquals(FarmUtils.sumAnimalsAge(animals), FarmUtilsStreaming.sumAnimalsAge(animals));
	}

	@Test
	public void testRemoveDuplicates() {
		assertEqualLists(FarmUtils.removeDuplicates(identicalAnimals),
				FarmUtilsStreaming.removeDuplicates(identicalAnimals));
	}

	@Test
	public void testGetMiddlePartOfList() {
		assertEquals(FarmUtils.getMiddlePartOfList(animals, start, end),
				FarmUtilsStreaming.getMiddlePartOfList(animals, start, end));
	}

	@Test
	public void testNumberAnimals() {
		assertEquals(FarmUtils.numberAnimals(animals), FarmUtilsStreaming.numberAnimals(animals));
	}

	@Test
	public void testGroupAnimalsBySize() {
		assertEquals(FarmUtils.groupAnimalsBySize(animals), FarmUtilsStreaming.groupAnimalsBySize(animals));
	}

	@Test
	public void testGetOldestAnimal() {
		assertEquals(FarmUtils.getOldestAnimal(animals), FarmUtilsStreaming.getOldestAnimal(animals));
	}

	@Test
	public void testGetLastAnimalAlphabetically() {
		assertEquals(FarmUtils.getLastAnimalAlphabetically(animals),
				FarmUtilsStreaming.getLastAnimalAlphabetically(animals));
	}

	@Test
	public void testGetLargestAnimal() {
		assertEquals(FarmUtils.getLargestAnimal(animals), FarmUtilsStreaming.getLargestAnimal(animals));
	}

	@Test
	public void testGetYoungestAnimal() {
		assertEquals(FarmUtils.getYoungestAnimal(animals), FarmUtilsStreaming.getYoungestAnimal(animals));
	}

	@Test
	public void testGetFirstAnimalAlphabetically() {
		assertEquals(FarmUtils.getFirstAnimalAlphabetically(animals),
				FarmUtilsStreaming.getFirstAnimalAlphabetically(animals));
	}

	@Test
	public void testGetSmallestAnimal() {
		assertEquals(FarmUtils.getSmallestAnimal(animals), FarmUtilsStreaming.getSmallestAnimal(animals));
	}

	@Test
	public void testContainsAnimalWithGivenName() {
		assertEquals(FarmUtils.containsAnimalWithGivenName(animals, name),
				FarmUtilsStreaming.containsAnimalWithGivenName(animals, name));
		assertEquals(FarmUtils.containsAnimalWithGivenName(animals, wrongName),
				FarmUtilsStreaming.containsAnimalWithGivenName(animals, wrongName));
	}

	@Test
	public void testContainsAnimalOfGivenAge() {
		assertEquals(FarmUtils.containsAnimalOfGivenAge(animals, age),
				FarmUtilsStreaming.containsAnimalOfGivenAge(animals, age));
		assertEquals(FarmUtils.containsAnimalOfGivenAge(animals, wrongAge),
				FarmUtilsStreaming.containsAnimalOfGivenAge(animals, wrongAge));
	}

	@Test
	public void testAllAnimalsHaveGivenName() {
		assertEquals(FarmUtils.allAnimalsHaveGivenName(identicalAnimals, name),
				FarmUtilsStreaming.allAnimalsHaveGivenName(identicalAnimals, name));
		assertEquals(FarmUtils.allAnimalsHaveGivenName(animals, name),
				FarmUtilsStreaming.allAnimalsHaveGivenName(animals, name));
	}

	@Test
	public void testAllAnimalsOfGivenAge() {
		assertEquals(FarmUtils.allAnimalsAreOfGivenAge(identicalAnimals, age),
				FarmUtilsStreaming.allAnimalsAreOfGivenAge(identicalAnimals, age));
		assertEquals(FarmUtils.allAnimalsAreOfGivenAge(animals, age),
				FarmUtilsStreaming.allAnimalsAreOfGivenAge(animals, age));
	}

	@Test
	public void testGetFirstAnimalWithGivenName() {
		assertEquals(FarmUtils.getFirstAnimalWithGivenName(animals, name),
				FarmUtilsStreaming.getFirstAnimalWithGivenName(animals, name));
	}

	@Test
	public void testGetFirstAnimalOfGivenAge() {
		assertEquals(FarmUtils.getFirstAnimalOfGivenAge(animals, age),
				FarmUtilsStreaming.getFirstAnimalOfGivenAge(animals, age));
	}

	@Test
	public void testTransformMapToListRemoveIdenticalElements() {
		assertEqualLists(FarmUtils.transformMapToListRemoveIdenticalElements(animalsBySize),
				FarmUtilsStreaming.transformMapToListRemoveIdenticalElements(animalsBySize));
	}

	@Test
	public void testFuseAnimals() {
		assertEquals(FarmUtils.fuseAnimals(animals), FarmUtilsStreaming.fuseAnimals(animals));
	}

	@Test
	public void testGetCommonSizeIfExistsOrElseNull() {
		assertEquals(FarmUtils.getCommonSizeIfExistsOrElseNull(identicalAnimals),
				FarmUtilsStreaming.getCommonSizeIfExistsOrElseNull(identicalAnimals));
		assertEquals(FarmUtils.getCommonSizeIfExistsOrElseNull(animals),
				FarmUtilsStreaming.getCommonSizeIfExistsOrElseNull(animals));
	}

	@Test
	public void testSortByNameNaturalOrdering() {
		assertEquals(FarmUtils.sortByNameNaturalOrdering(animals),
				FarmUtilsStreaming.sortByNameNaturalOrdering(animals));
	}

	@Test
	public void testSortByNameReversedOrdering() {
		assertEquals(FarmUtils.sortByNameReversedOrdering(animals),
				FarmUtilsStreaming.sortByNameReversedOrdering(animals));
	}

	@Test
	public void testSortBySizeNaturalOrdering() {
		assertEquals(FarmUtils.sortBySizeNaturalOrdering(animals),
				FarmUtilsStreaming.sortBySizeNaturalOrdering(animals));
	}

	@Test
	public void testSortBySizeReversedOrdering() {
		assertEquals(FarmUtils.sortBySizeReversedOrdering(animals),
				FarmUtilsStreaming.sortBySizeReversedOrdering(animals));
	}

	@Test
	public void testSortByAgeNaturalOrdering() {
		assertEquals(FarmUtils.sortByAgeNaturalOrdering(animals), FarmUtilsStreaming.sortByAgeNaturalOrdering(animals));
	}

	@Test
	public void testSortByAgeReversedOrdering() {
		assertEquals(FarmUtils.sortByAgeReversedOrdering(animals),
				FarmUtilsStreaming.sortByAgeReversedOrdering(animals));
	}

	@Test
	public void testCreateDogs() {
		assertEqualLists(FarmUtils.createDogs(names), FarmUtilsStreaming.createDogs(names));
	}

	@Test
	public void testCreateStarfish() {
		assertEqualLists(FarmUtils.createStarfish(names), FarmUtilsStreaming.createStarfish(names));
	}

	@Test
	public void testCreatePigs() {
		assertEqualLists(FarmUtils.createPigs(names), FarmUtilsStreaming.createPigs(names));
	}

	@Test
	public void testCreatePenguins() {
		assertEqualLists(FarmUtils.createPenguins(names), FarmUtilsStreaming.createPenguins(names));
	}

	@Test
	public void testCreateHorses() {
		assertEqualLists(FarmUtils.createHorses(names), FarmUtilsStreaming.createHorses(names));
	}

	public static <T> void assertEqualLists(List<T> expected, List<T> actual) {
		assertEquals(createCardinalityMap(expected), createCardinalityMap(actual));
	}

	private static <T> Map<T, Integer> createCardinalityMap(List<T> list) {
		Map<T, Integer> result = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			T key = list.get(i);
			if (!result.containsKey(key)) {
				result.put(key, 0);
			}
			result.put(key, result.get(key) + 1);
		}
		return result;
	}

}
