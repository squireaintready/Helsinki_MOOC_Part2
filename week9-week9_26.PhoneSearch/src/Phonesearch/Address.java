/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phonesearch;

/**
 *
 * @author Samuel Jo
 */
public class Address {
    private String street;
    private String city;
    
    public Address(){
        
    }
    
    public Address(String street, String city){
        this.street = street;
        this.city = city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public void setStreet(String street){
        this.street = street;
    }
    
    public boolean addressContainsKeyword(String keyword){
        if (this.street.contains(keyword) || (this.city.contains(keyword))){
            return true;
        }else{
            return false;
        }
    } 
    
    public String toString(){
        return this.street + " " + this.city;
    }
}
