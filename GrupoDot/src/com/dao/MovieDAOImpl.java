package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.data.Movie;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class MovieDAOImpl implements MovieDAO {
  
  @SessionTarget
  Session session;
  
  @TransactionTarget
  Transaction transaction;

  /**
   * Used to save or update a movie.
   */
  public void saveOrUpdateMovie(Movie movie) {
    try {
      session.saveOrUpdate(movie);
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
  }

  /**
   * Used to delete a movie.
   */
  public void deleteMovie(Long movieId) {
    try {
      Movie movie = (Movie) session.get(Movie.class, movieId);
      session.delete(movie);
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    } 
  }
  
  /**
   * Used to list all the movies.
   */
  @SuppressWarnings("unchecked")
  public List<Movie> listMovie() {
    List<Movie> courses = null;
    try {
      courses = session.createQuery("from Movie").list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return courses;
  }

  /**
   * Used to list a single movie by Id.
   */
  public Movie listMovieById(Long movieId) {
    Movie movie = null;
    try {
      movie = (Movie) session.get(Movie.class, movieId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return movie;
  }

}
