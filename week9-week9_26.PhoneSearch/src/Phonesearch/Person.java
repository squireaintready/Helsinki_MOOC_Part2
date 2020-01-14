/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phonesearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Samuel Jo
 */
public class Person implements Comparable<Person>{
    private String name;
    private Map<String, Phone>numberByName;
    private Map<String, String>nameByNumber;
    private Map<String, Address>addressByName;
    
    public Person (String name, String number){
        this.name = name;
        this.numberByName = new HashMap<String, Phone>();
        this.nameByNumber = new HashMap<String, String>();
        this.addressByName = new HashMap<String, Address>();
        
        this.numberByName.put(name, new Phone());
        this.numberByName.get(name).add(number);
        this.nameByNumber.put(number, name);
    }
    
    public Person(String name, String street, String city){
        this.name = name;
        this.numberByName = new HashMap<String, Phone>();
        this.nameByNumber = new HashMap<String, String>();
        this.addressByName = new HashMap<String, Address>();
        
        this.addressByName.put(name, new Address());
        this.addressByName.get(name).setStreet(street);
        this.addressByName.get(name).setCity(city);
    }
    
    public void addNumber(String number){
        this.nameByNumber.put(number, this.name);
        if(this.numberByName.get(this.name) != null){
            this.numberByName.get(this.name).add(number);
        }else {
            this.numberByName.put(this.name, new Phone());
            this.numberByName.get(this.name).add(number);
        }
        
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean nameIs(String name){
        if (this.name.equals(name)){
            return true;
        }else {
            return false;
        }
    }
    
    public boolean searchNumberByNameIsTrue(String name){
        if(this.numberByName.containsKey(name)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean searchNameByNumberIsTrue(String number){
        if(this.nameByNumber.containsKey(number)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean searchAddressByNameIsTrue(String name){
        if (this.addressByName.containsKey(name)){
            return true;
        }else{
            return false;
        }
    }
    
    public void setAddress(String street, String city){
        if (this.addressByName.get(this.name) == null){
            this.addressByName.put(name, new Address());
        }
        this.addressByName.get(this.name).setStreet(street);
        this.addressByName.get(this.name).setCity(city);
    }
    
    public Address printAddress(){
        return this.addressByName.get(this.name);
    }
    
    public Set<String> printNumbers(){
        return this.numberByName.get(this.name).getNumbers();
    }
    
    public String printNames(String number){
        return this.nameByNumber.get(number);
    }
    
    @Override
    public int compareTo(Person person) {
        return this.name.compareToIgnoreCase(person.name);
    }

    public boolean containsKeyword(String keyword){
        if (this.addressByName.get(this.name) != null){
            if((this.addressByName.get(this.name).addressContainsKeyword(keyword)) || this.name.contains(keyword)){
                return true;
            }else{
                return false;
            }
        }else{
            if (this.name.contains(keyword)){
                return true;
            }else{
                return false;
            }
        }
    }
}

