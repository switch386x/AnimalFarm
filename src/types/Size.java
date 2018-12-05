package types;

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
		for (int i = 0; i < sizes.length; i++) {
			if (this == sizes[i]) {
				return true;
			}
		}
		return false;
	}

	public static Size getRandomSize() {
		// randomness achieved with a series of coin tosses.
		return Size.HUGE;
	}

	public static Size max(Size size1, Size size2) {
		return size1.size > size2.size ? size1 : size2;
	}
}
