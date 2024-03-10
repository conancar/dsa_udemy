package dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class HashingMain {

	public static void main(String[] args){
		//MyHashing<String> hashing=new DirectChainingHashing<>(10);
		//MyHashing<String> hashing=new LinearProbingHashing<>(String.class,20);
		MyHashing<String> hashing=new QuadraticProbingHashing<>(String.class,20);
		hashing.insert("ABC");
		hashing.insert("DFGBC");
		hashing.insert("DEEABC");
		hashing.insert("SDSABC");
		hashing.insert("CBA");
		hashing.insert("BAC");

		final String read = hashing.read();

		System.out.println(read);

		System.out.println("******************");
		System.out.println(hashing.find("ABC"));
		System.out.println(hashing.find("ABCsss"));

		hashing.remove("ABC");

		System.out.println(hashing.read());


	}
}
