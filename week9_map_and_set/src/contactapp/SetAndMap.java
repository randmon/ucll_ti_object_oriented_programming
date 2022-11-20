package contactapp;

import java.time.LocalDate;
import java.util.*;

public class SetAndMap {

	public static void main(String[] args) {
		partA();
//		partB();
//		partC();
	}

	public static void partA() {
		String[] letters1 = {"p", "e", "a", "b", "a"};
		String[] letters2 = {"p", "f", "a", "b", "a","x","a","f"};
		List<String> l1 = new ArrayList<>(Arrays.asList(letters1));
		List<String> l2 = new ArrayList<>(Arrays.asList(letters2));
		print("row1: \n" + l1);
		print("row2: \n" + l2);

		print("\ncommon letters in row 1 and 2, doubles allowed");
		l1.retainAll(l2);
		print(l1);

		print("\ncommon letters in row 1 and 2, doubles not allowed");
		Set<String> s1 = new HashSet<>(Arrays.asList(letters1));
		s1.retainAll(l2);
		print(s1);


		print("\ncommon letters in row 1 and 2, doubles not allowed, alphabetical order");
		Set<String> t1 = new TreeSet<>(Arrays.asList(letters1));
		t1.retainAll(l2);
		print(t1);


		print("\nTotal appearances of each letter in row 2, alphabetical order");
		Map <String,Integer> map = new TreeMap<>();
		l2 = new ArrayList<>(Arrays.asList(letters2));
		l2.forEach(x -> {
			Integer count = map.getOrDefault(x, 0);
			map.put(x, count+1);
		});
		Set <Map.Entry<String, Integer>> set = map.entrySet();
		for (Map.Entry<String,Integer> entry : set){
			String output = String.format("%2s: %2d",entry.getKey(), entry.getValue());
			print(output);
		}

		print("\nSum of letters in row 2 that appear 1, 2, 3 and 4 times");
		Map <Integer,Set<String>> map2 = new TreeMap<>();
		for (int i =1; i < 5;i++){
			map2.put(i, new TreeSet<>());
		}
		for (var entry : set){
			int aantal = entry.getValue();
			map2.get(aantal).add(entry.getKey());
		}
		for (var entry : map2.entrySet()){
			String output = String.format("%2s: %-20s", entry.getKey(),entry.getValue());
			print(output);
		}
	}

	public static void partB() {
		contactapp.Date[] d1 = {
				new contactapp.Date(4,11,2020),
				new contactapp.Date(14,10,2020),
				new contactapp.Date(1,2,2019),
				new contactapp.Date(12,12,2019),
				new contactapp.Date(1,2,2019)};
		contactapp.Date[] d2 = {
				new contactapp.Date(4,11,2020),
				new contactapp.Date(16,10,2020),
				new contactapp.Date(1,2,2019),
				new contactapp.Date(12,12,2019),
				new contactapp.Date(1,2,2019),
				new contactapp.Date(1,12,2020),
				new contactapp.Date(1,2,2019),
				new contactapp.Date(16,10,2020)};

		List <contactapp.Date> l1 = new ArrayList<>(Arrays.asList(d1));
		List <contactapp.Date> l2 = new ArrayList<>(Arrays.asList(d2));
		print("row1: \n" + l1);
		print("row2: \n" + l2);

		print("common dates in row d1 and d2, doubles allowed");
		l1.retainAll(l2);
		print(l1);

		print("common dates in row d1 and d2, doubles not allowed");
		Set<contactapp.Date> s1 = new HashSet<>(Arrays.asList(d1));
		s1.retainAll(l2);
		print(s1);


		print("common dates in row d1 and d2, doubles not allowed, alphabetical order");
		Set<contactapp.Date> s2 = new HashSet<>(Arrays.asList(d1));
		s2.retainAll(l2);
		print(Arrays.toString(s2.stream().sorted().toArray()));


		print("Aantal voorkomens van elke datum in row d2, geordend");
		Map <contactapp.Date,Integer> map = new TreeMap<>();
		l2 = new ArrayList<>(Arrays.asList(d2));
		l2.forEach(x -> {
			Integer count = map.get(x);
			if (count == null) count = 0;
			map.put(x, count+1);
		});
		Set <Map.Entry<contactapp.Date, Integer>> set = map.entrySet();
		for (Map.Entry<contactapp.Date,Integer> entry:set){
			String output = String.format("%2s: %2d", entry.getKey(),entry.getValue());
			print(output);
		}

		print("opsomming van dates in row d2 die 1, 2, 3 and 4 keer voorkomen");
		Map <Integer,Set<contactapp.Date>> map2 = new TreeMap<>();
		for (int i =1; i < 5;i++){
			map2.put(i, new TreeSet<>() );
		}
		for (Map.Entry<contactapp.Date,Integer> entry:set){
			int aantal = entry.getValue();
			map2.get(aantal).add(entry.getKey());
		}
		Set <Map.Entry<Integer,Set<contactapp.Date>>> set2 = map2.entrySet();
		for (Map.Entry<Integer,Set<Date>> entry:set2){
			String output = String.format("%2s: %-20s", entry.getKey(),entry.getValue());
			print(output);
		}

	}

	public static void partC() {
		LocalDate[] datums1 = {
				LocalDate.of(2020, 4, 11),
				LocalDate.of(2020, 10, 14),
				LocalDate.of(2019, 2, 1),
				LocalDate.of(2019, 12, 12),
				LocalDate.of(2019, 2, 1)
		};

		LocalDate[] datums2 = {
				LocalDate.of(2020, 4, 11),
				LocalDate.of(2020, 10, 16),
				LocalDate.of(2019, 2, 1),
				LocalDate.of(2019, 12, 12),
				LocalDate.of(2019, 2, 1),
				LocalDate.of(2020, 12, 1),
				LocalDate.of(2019, 2, 1),
				LocalDate.of(2020, 10, 16)
		};

		List <LocalDate> l1 = new ArrayList<>(Arrays.asList(datums1));
		List <LocalDate> l2 = new ArrayList<>(Arrays.asList(datums2));
		print("row1:"+"\n"+l1);
		print("row2:"+"\n"+l2);

		print("common dates in row datums1 and datums2, doubles allowed");
		l1.retainAll(l2);
		print(l1);

		print("common dates in row datums1 and datums2, doubles not allowed");
		Set<LocalDate> s1 = new HashSet<>(Arrays.asList(datums1));
		s1.retainAll(l2);
		print(s1);


		print("common dates in row datums1 and datums2, doubles not allowed, alphabetical order");
		Set<LocalDate> s2 = new HashSet<>(Arrays.asList(datums1));
		s2.retainAll(l2);
		print(Arrays.toString(s2.stream().sorted().toArray()));


		print("Aantal voorkomens van elke datum in row datums2, geordend");
		Map <LocalDate,Integer> map = new TreeMap<>();
		l2 = new ArrayList<>(Arrays.asList(datums2));
		l2.forEach(x -> {
			Integer count = map.get(x);
			if (count == null) count = 0;
			map.put(x, count+1);
		});
		Set <Map.Entry<LocalDate, Integer>> set = map.entrySet();
		for (Map.Entry<LocalDate,Integer> entry:set){
			String output = String.format("%2s: %2d", entry.getKey(),entry.getValue());
			print(output);
		}

		print("opsomming van dates in row datums2 die 1, 2, 3 and 4 keer voorkomen");
		Map <Integer,Set<LocalDate>> map2 = new TreeMap<>();
		for (int i =1; i < 5;i++){
			map2.put(i, new TreeSet<>() );
		}
		for (Map.Entry<LocalDate,Integer> entry:set){
			int aantal = entry.getValue();
			map2.get(aantal).add(entry.getKey());
		}
		Set <Map.Entry<Integer,Set<LocalDate>>> set2 = map2.entrySet();
		for (Map.Entry<Integer,Set<LocalDate>> entry:set2){
			String output = String.format("%2s: %-20s", entry.getKey(),entry.getValue());
			print(output);
		}

	}

	private static void print(Object o) {
		System.out.println(o);
	}
}

