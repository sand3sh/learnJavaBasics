import java.text.ParseException;
import java.util.*;
import java.util.Map.Entry;


public class CollectionsTest {

	public static void main(String args[]) throws ParseException{
		//test();
		new HashMapSorting().main(null);
	}
	
	public static void test(){
		Map<String, Person> people = new HashMap<String, Person>();
		Person jims = new Person("Jim", 25);
	    Person scott = new Person("Scott", 28);
	    Person anna = new Person("Anna", 23);

	    people.put(jims.getName(), jims);
	    people.put(scott.getName(), scott);
	    people.put(anna.getName(), anna);
	    
	    List<Person> peopleByAge = new ArrayList<Person>(people.values());
	    
	    //Before 
	    for (Person p : peopleByAge) {
	        System.out.println(p.getName() + "\t" + p.getAge());
	    }
	    
	    Collections.sort(peopleByAge, new Comparator<Person>() {

	        public int compare(Person o1, Person o2) {
	            return o1.getAge() - o2.getAge();
	        }
	    });
	    
	    //After
	    for (Person p : peopleByAge) {
	        System.out.println(p.getName() + "\t" + p.getAge());
	    }
	    
	    SortedSet<Person> values = new TreeSet<Person>(people.values());
	    
	    
	}
}


class Person{
	 String name; 
	 int age; 
	 
	 Person(String name, int age){
		 this.name = name;
		 this.age = age;
	 }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

//Sorting by Treemap or Collections.sort
class HashMapSorting{

    public static void main(String args[]) throws ParseException {
        
        // let's create a map with Java releases and their code names
        HashMap<String, String> codenames = new HashMap<String, String>();
        
        codenames.put("JDK 1.1.4", "Sparkler");
        codenames.put("J2SE 1.2", "Playground");
        codenames.put("J2SE 1.3", "Kestrel");
        codenames.put("J2SE 1.4", "Merlin");
        codenames.put("J2SE 5.0", "Tiger");
        codenames.put("Java SE 6", "Mustang");
        codenames.put("Java SE 7", "Dolphin");
        
        System.out.println("HashMap before sorting, random order ");
        Set<Entry<String, String>> entries = codenames.entrySet();
       
        for(Entry<String, String> entry : entries){
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }
        
        // Now let's sort HashMap by keys first 
        // all you need to do is create a TreeMap with mappings of HashMap
        // TreeMap keeps all entries in sorted order
        TreeMap<String, String> sorted = new TreeMap<String, String>(codenames);
        Set<Entry<String, String>> mappings = sorted.entrySet();
        
        System.out.println("HashMap after sorting by keys in ascending order ");
        for(Entry<String, String> mapping : mappings){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
        
        
        // Now let's sort the HashMap by values
        // there is no direct way to sort HashMap by values but you
        // can do this by writing your own comparator, which takes
        // Map.Entry object and arrange them in order increasing 
        // or decreasing by values.
        
        Comparator<Entry<String, String>> valueComparator = new Comparator<Entry<String,String>>() {
            
            @Override
            public int compare(Entry<String, String> e1, Entry<String, String> e2) {
                String v1 = e1.getValue();
                String v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };
        
        // Sort method needs a List, so let's first convert Set to List in Java
        List<Entry<String, String>> listOfEntries = new ArrayList<Entry<String, String>>(entries);
        
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        
        LinkedHashMap<String, String> sortedByValue = new LinkedHashMap<String, String>(listOfEntries.size());
        
        // copying entries from List to Map
        for(Entry<String, String> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println("HashMap after sorting entries by values ");
        Set<Entry<String, String>> entrySetSortedByValue = sortedByValue.entrySet();
        
        for(Entry<String, String> mapping : entrySetSortedByValue){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
    }

    
}

