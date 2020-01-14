/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author Samuel Jo
 */
public class RatingRegister {
    private Map<Film, List<Rating>>filmRatings;
    private Map<Person, Map<Film, Rating>> personRatings;
    
    public RatingRegister(){
        this.filmRatings = new HashMap<Film, List<Rating>>();
        this.personRatings = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating){
        if (!this.filmRatings.containsKey(film)){
            this.filmRatings.put(film, new ArrayList<Rating>());
        }
        filmRatings.get(film).add(rating);
    }
    
    public List<Rating> getRatings(Film film){
        return filmRatings.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings(){
        return this.filmRatings;
    }
    
    public void addRating(Person person, Film film, Rating rating){
        if(!this.personRatings.containsKey(person)){
            this.personRatings.put(person, new HashMap<Film, Rating>());
            this.personRatings.get(person).put(film, rating);
            addRating(film, rating);
        }else if(!personRatings.get(person).containsKey(film)){
           this.personRatings.get(person).put(film, rating);
           addRating(film, rating);
        }
    }
    
    public Rating getRating(Person person, Film film){
        if(!this.personRatings.containsKey(person)){
            return Rating.NOT_WATCHED;
        }else if (!this.personRatings.get(person).containsKey(film)){
            return Rating.NOT_WATCHED;
        }
        return personRatings.get(person).get(film);
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person){
        if(!personRatings.containsKey(person)){
            return new HashMap();
        }
        return this.personRatings.get(person);
    }
    
    public List<Person> reviewers(){
        return new ArrayList<Person>(personRatings.keySet());
    }
}
