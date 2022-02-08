package com.movie.managment.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.managment.model.movie.Movie;
import com.movie.managment.model.movie.MovieRequestModel;
import com.movie.managment.model.movie.MovieResponseModel;
import com.movie.managment.repository.MovieRepository;



@Service
public class MovieServiceImpl {

	@Autowired
	MovieRepository movieRepository;

	public MovieResponseModel createCustomer(MovieRequestModel request) {
		Movie m = new Movie();
		m.setMovieId(UUID.randomUUID().toString());
		m.setMovieName(request.getMovieName());
		m.setDescription(request.getDescription());
		m.setStarring(request.getStarring());
		m.setRunTime(request.getRunTime());
		m.setSlug(request.getSlug());
		//m.setGenresId(request.get);
		movieRepository.save(m);
		MovieResponseModel response =new MovieResponseModel();
		response.setMovieId(m.getMovieId());
		response.setMovieName(m.getMovieName());
		response.setDescription(m.getDescription());
		response.setStarring(m.getStarring());
		response.setRunTime(m.getRunTime());
		response.setSlug(m.getSlug());

		return response;

	}

	public List<MovieResponseModel> getAllMovies() {
		ModelMapper mapper = new ModelMapper();
		List<MovieResponseModel> returnList = new ArrayList<MovieResponseModel>();

		List<Movie> list = movieRepository.findAll();

		for (Movie m : list) {
			MovieResponseModel modelObject = mapper.map(m, MovieResponseModel.class);
			returnList.add(modelObject);
		}

		return returnList;
	}
	
	public MovieResponseModel getMovieById(String Id) {
		Optional<Movie> optional = movieRepository.findById(Id);

		if (optional.isPresent()) {
			Movie c = optional.get();
			ModelMapper mapper = new ModelMapper();
			MovieResponseModel returnObject = mapper.map(c, MovieResponseModel.class);
			return returnObject;
		}

		return null;
		
	}
	
	public MovieResponseModel updateCustomer(String id,MovieRequestModel requestModel) {
		Optional<Movie> optional = movieRepository.findById(id);
		if (optional.isPresent()) {
			ModelMapper mapper = new ModelMapper();
			Movie c = mapper.map(requestModel, Movie.class);
			c.setMovieId(id);
			movieRepository.save(c);
			MovieResponseModel trm = mapper.map(c, MovieResponseModel.class);
			return trm;
		}

		return null;

	}

	public void deleteMovie(String id) {
		movieRepository.deleteById(id);
	}

}
