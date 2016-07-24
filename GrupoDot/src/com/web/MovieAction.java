package com.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.MovieDAO;
import com.dao.MovieDAOImpl;
import com.data.Movie;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MovieAction extends ActionSupport implements ModelDriven<Movie> {

  private static final long serialVersionUID = -6659925652584240539L;

  private Movie movie = new Movie();
  private List<Movie> movieList = new ArrayList<Movie>();
  private MovieDAO movieDAO = new MovieDAOImpl();
  
  public Movie getModel() {
    return movie;
  }
  
  /**
   * To save or update movie.
   * @return String
   */
  public String saveOrUpdate()
  { 
    movieDAO.saveOrUpdateMovie(movie);
    return SUCCESS;
  }
  
  /**
   * To list all movies.
   * @return String
   */
  public String list()
  {
    movieList = movieDAO.listMovie();
    return SUCCESS;
  }
  
  /**
   * To delete a movie.
   * @return String
   */
  public String delete()
  {
    HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    movieDAO.deleteMovie(Long.parseLong(request.getParameter("id")));
    return SUCCESS;
  }
  
  /**
   * To list a single movie by Id.
   * @return String
   */
  public String edit()
  {
    HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    movie = movieDAO.listMovieById(Long.parseLong(request.getParameter("id")));
    return SUCCESS;
  }
  
  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public List<Movie> getMovieList() {
    return movieList;
  }

  public void setMovieList(List<Movie> movieList) {
    this.movieList = movieList;
  }

}
