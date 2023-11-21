package Day1;
import java.util.*;
import java.util.stream.*;
public class FindMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
          int max =  myList.stream()
                           .max(Integer::compare)
                           .get();
          System.out.println(max);      
	}

}
