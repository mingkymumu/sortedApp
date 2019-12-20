package com.noer;
import java.io.*;
import java.util.*;

public class Main {
    /**
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    //this method for read from file and convert text to person List
    public static List<Person> getListFromFile(String filePath) throws FileNotFoundException {
        List<Person> list = new ArrayList<>();
        File myObj = new File(filePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String [] arrayName = data.split("\\W+");
            Person person = new Person(arrayName[0],arrayName[arrayName.length-1],data);
            list.add(person);
        }
        return list;
    }

    //this method for sorting a list collection
    public static List<Person> sortPerson(List list){
        //first sort criteria is last name then the full name
        Collections.sort(list,Comparator.comparing(Person::getLastName).thenComparing(Person::getFullName));
        return  list;
    }
    //this method for create sorted name list file
    public static void createSortedFile(ArrayList<Person> list) throws IOException {
        FileWriter myWriter = new FileWriter("sorted-name-list.txt");
        list.forEach(person ->{
            try {
                myWriter.write(person.getFullName()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        myWriter.close();
    }



    public static void main(String[] args) throws IOException {
            List<Person> list = getListFromFile(args[0]);
            sortPerson( list);
            list.forEach(person->{
                System.out.println(person.getFullName());
            });
            createSortedFile((ArrayList<Person>) list);
        }
}

class Person {

    public Person(String firstName, String lastName, String fullName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
    }

    String firstName;
    String lastName;
    String fullName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}

