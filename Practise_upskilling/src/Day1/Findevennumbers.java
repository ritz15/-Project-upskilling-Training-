package Day1;

import java.util.Arrays;
import java.util.List;

public class Findevennumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
         list.stream()
             .filter(n -> n%2 == 0)
             .forEach(System.out::println);
	}

}
