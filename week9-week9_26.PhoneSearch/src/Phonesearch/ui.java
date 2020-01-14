/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phonesearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Samuel Jo
 */
public class ui {
    private List<Person>phonebook;
    private Scanner reader;
    
    public ui(){
        this.reader = new Scanner(System.in);
        this.phonebook = new ArrayList<Person>();
    }
    
    public void start(){
        System.out.println("Phone Search\n"
                        + "available operations: \n"
                        + "1 add a number \n"
                        + "2 search for a number \n"
                        + "3 search for a person by phone number \n"
                        + "4 add an address \n"
                        + "5 search for personal information \n"
                        + "6 delete personal information \n"
                        + "7 filtered listing \n"
                        + "x quit");
        this.readCommand();
    }
    
    public void readCommand(){
        while(true){
            System.out.print("command: ");
            String command = reader.nextLine();
            if (command.equals("x")){
                break;
            }else if (command.equals("1")){
                this.addNumber();
            }else if (command.equals("2")){
                this.searchNumberByName();
            }else if (command.equals("3")){
                this.searchNameByNumber();
            }else if (command.equals("4")){
                this.addAddress();
            }else if (command.equals("5")){
                this.searchAddressPhoneByName();
            }else if (command.equals("6")){
                this.deletePhoneAndAddress();
            }else if (command.equals("7")){
                this.printAllNamesAndAddress();
            }else{
                System.out.println("Follow the instructions DUMBASS.....");
            }
        }
        
    }

    private void addNumber() {
        System.out.print("Whose number: ");
        String name = reader.nextLine();
        System.out.print("Number: ");
        String number = reader.nextLine();
        
        for (Person person : this.phonebook){
            if (person.nameIs(name)){
                person.addNumber(number);
                return;
            }
        }
        this.phonebook.add(new Person(name, number));
    }

    private void searchNumberByName() {
        System.out.print("Whose number: ");
        String name = reader.nextLine();
        
        for (Person person : this.phonebook){
            if (person.searchNumberByNameIsTrue(name)){
                for (String number : person.printNumbers()){
                    System.out.println(" " + number);
                }
                return;
            }
        }
        System.out.println("Not found. ");
    }

    private void searchNameByNumber() {
        System.out.print("Number: ");
        String number = reader.nextLine();
        
        for (Person person: this.phonebook){
            if (person.searchNameByNumberIsTrue(number)){
                System.out.println(" " + person.printNames(number));
                return;
            }
        }
        System.out.println("Not found.");
    }

    private void addAddress() {
        System.out.print("Whose address: ");
        String name = reader.nextLine();
        System.out.print("Street: ");
        String street = reader.nextLine();
        System.out.print("City: ");
        String city = reader.nextLine();
        for (Person person : this.phonebook){
            if (person.nameIs(name)){
                person.setAddress(street, city);
                return;
            }
        }
        this.phonebook.add(new Person(name, street, city));
    }

    private void searchAddressPhoneByName() {
        System.out.print("Whose information: " );
        String name = reader.nextLine();
        
        for (Person person : this.phonebook){
            if (person.nameIs(name)){
                this.printAddress(name, person);
                this.printNumber(name, person);
                return;
            }
        }
        System.out.println("Not found: ");
    }
    
    private void deletePhoneAndAddress() {
        System.out.println("Whose information: ");
        String name = reader.nextLine();
        
        for (Person person : this.phonebook){
            if (person.nameIs(name)){
                this.phonebook.remove(person);
                break;
            }
        }
    }

    public void printAllNamesAndAddress() {
        System.out.println("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();

        Collections.sort(this.phonebook);

        if (!keyword.equals("")) {
            boolean found = false;
            for (Person person : this.phonebook) {
                if (person.containsKeyword(keyword)) {
                    System.out.println("\n " + person.getName());
                    this.printAddress(person.getName(), person);
                    this.printNumber(person.getName(), person);
                    found = true;
                }
            } if (found == false) {
                System.out.println("  not found");
            }
        } else {
            for (Person person : this.phonebook) {
                this.printAddress(person.getName(), person);
                this.printNumber(person.getName(), person);
            }

        }
    }    
    

    private void printNumber(String name, Person person) {
        if (person.searchNumberByNameIsTrue(name)){
            System.out.println(" Phone numbers: ");
            for (String number : person.printNumbers()){
                System.out.println(" " + number);
            }
        }else{
            System.out.println(" Phone number not found ");
        }
    }

    private void printAddress(String name, Person person) {
        if (person.searchAddressByNameIsTrue(name)){
            System.out.println(" Address: " + person.printAddress());
            return;
        }else{
            System.out.println(" Address unknown ");
        }
    }
}
