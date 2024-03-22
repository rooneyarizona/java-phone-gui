package tv.weshowyou.phone;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alastair Sagar
 *
 */
public class PreviousCallList {

	private List<String> numbers;

	public PreviousCallList() {
		numbers = new ArrayList<>();

	}

	public void addNumber(String number) {
		numbers.add(number);

	}

	public List<String> getNumbers() {
		return numbers;

	}
}
