package Sample.sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App1 {
    public static void main(String[] args) {
    	
    	Person person = new Person();
    	person.dataparser();
    	System.out.println(person.Name());
    	System.out.println(person.Email());
    	System.out.println(person.Age());
    	System.out.println(person.MaritalStatus());
    	System.out.println(person.Weight());
    }
}

class Person {
	private String name;
	private String email;
	private long age;
	private boolean married;
	private double weight;
	
	void dataparser() {
		
		JSONParser parser = new JSONParser();

        try {     
            Object obj = parser.parse(new FileReader("/home/nehalg/Desktop/Person.json"));

            JSONObject jsonObject =  (JSONObject) obj;

            name = (String) jsonObject.get("name");
            email = (String) jsonObject.get("email");
            age = (Long) jsonObject.get("age");
            married = (Boolean) jsonObject.get("married");
            weight = (Double) jsonObject.get("weight");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	String Name() {
		return name;
	}
	
	String Email() {
		return email;
	}
	
	long Age() {
		return age;
	}
	
	boolean MaritalStatus() {
		return married;
	}
	
	double Weight() {
		return weight;
	}
	
}

//Create a Json file with the below content
//
//Person.json
//{
//    "name":"Bob",
//    "email":"bob@gmail.com",
//    "age": 22,
//    "married": false,
//    "weight": 73.4
//}
//
//Create a Java Class to represent this Person
//
//Read this json file and create an Java Object
//
//Print that Java Object in console
