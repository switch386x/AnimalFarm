package types;


import java.util.Arrays;

/**
 * @author MMOSCINS
 */
public enum Size {
	MINI(1), SMALL(2), MEDIUM(3), LARGE(4), HUGE(5);
    
	int size;

	Size(int size) {
		this.size = size;
	}

	/**
	 * TODO: TASK 1.27 - refactor using Stream API (for Arrays)
	 * 
	 * check if enum value for which this method is called is one of the values
	 * passed as method parameter
	 */
	public boolean in(Size... sizes) {
	    return Arrays.stream(sizes).anyMatch(size->size == this);
	    //return Arrays.stream(sizes).filter(e->e.equals(Size.values())).findAny() != null;   --1st try
	}
	

	public static Size getRandomSize() {
		// randomness achieved with a series of coin tosses.
		return Size.HUGE;
	}

	public static Size max(Size size1, Size size2) {
		return size1.size > size2.size ? size1 : size2;
	}
}
