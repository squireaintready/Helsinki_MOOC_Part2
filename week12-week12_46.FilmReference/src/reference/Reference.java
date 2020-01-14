/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author Samuel Jo
 */
public class Reference {
    private RatingRegister register;
    
    public Reference(RatingRegister register){
        this.register = register;
    }
    
    public Film recommendFilm(Person person){
        //if person has no ratings for any films, create a new array with 
        //a new array, copy all the film ratings, and recommend one with the highest rating.
        if (register.getPersonalRatings(person).isEmpty()){
            List<Film>films = new ArrayList<Film>(register.filmRatings().keySet());
            Collections.sort(films, new FilmComparator(register.filmRatings()));
            return films.get(0);
        }
        // look for a film with positively similar reviewers 
        // that the viewer has not seen.
        //  generate list of positively similar reviewers sorted in descending 
        //  order of similarity
        List<Person> reviewersSortedSimilarity = reviewersSortBySimilarity(person);
        return getRecommendedFilm(person, reviewersSortedSimilarity);
    }

    private List<Person> reviewersSortBySimilarity(Person person) {
        //get positively simliiar reviews into new hashmap.
        Map<Person, Integer> reviewersSimilarity = new HashMap<Person, Integer>();
        //add all people to a list.
        List<Person> similarReviewers = new ArrayList<Person>(reviewersSimilarity.keySet());
        //sort people on list by their keyset(integers representing ratings)
        Collections.sort(similarReviewers, new PersonComparator(reviewersSimilarity));
        return similarReviewers;
    }

    private Film getRecommendedFilm(Person person, List<Person> reviewersSortedSimilarity) {
        Map<Film, Rating> viewerSeenFilms = register.getPersonalRatings(person);
        for (Person reviewer : reviewersSortedSimilarity){
            if (reviewer == person){
                continue;
            }
            
            for (Film film: register.getPersonalRatings(reviewer).keySet()){
                if(viewerSeenFilms.containsKey(film)){
                    continue;
                }
                if (register.getPersonalRatings(reviewer).get(film).getValue() > 1){
                    return film;
                }
            }
        }
        return null;
    }
}
