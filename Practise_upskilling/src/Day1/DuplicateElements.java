package Day1;
import java.util.*;
import java.util.stream.*;

public class DuplicateElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
         Set<Integer> set = new HashSet();
         myList.stream()
               .filter(n -> !set.add(n))
               .forEach(System.out::println);
	}

}
