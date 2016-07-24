
package com.dao;

import java.util.List;

import com.data.Movie;

public interface MovieDAO {

  public void saveOrUpdateMovie(Movie movie);
  public List<Movie> listMovie();
  public Movie listMovieById(Long movieId);
  public void deleteMovie(Long movieId);
}

