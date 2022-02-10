package com.movie.managment.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.managment.model.show.Show;
import com.movie.managment.model.show.ShowRequestModel;
import com.movie.managment.model.show.ShowResponseModel;
import com.movie.managment.repository.ShowRepository;

@Service
public class ShowServiceImpl {
	@Autowired
	ShowRepository showRepository;

	public ShowResponseModel createShow(ShowRequestModel request) {
		Show show = new Show();
		show.setShowId(UUID.randomUUID().toString());
		show.setShowDate(request.getShowDate());
		show.setStartTime(request.getStartTime());
		show.setEndTime(request.getEndTime());
		show.setPrice(request.getPrice());
		show.setMovie(request.getMovie());
		
		showRepository.save(show);
		ShowResponseModel response =new ShowResponseModel();
		response.setShowId(show.getShowId());
		response.setShowDate(show.getShowDate());
		response.setStartTime(show.getStartTime());
		response.setPrice(show.getPrice());
		response.setEndTime(show.getEndTime());
		response.setMovie(show.getMovie());
		

		return response;

	}

	public List<ShowResponseModel> getAllShows() {
		ModelMapper mapper = new ModelMapper();
		List<ShowResponseModel> returnList = new ArrayList<ShowResponseModel>();

		List<Show> list = showRepository.findAll();

		for (Show m : list) {
			ShowResponseModel modelObject = mapper.map(m, ShowResponseModel.class);
			returnList.add(modelObject);
		}

		return returnList;
	}
	
	public ShowResponseModel getShowById(String Id) {
		Optional<Show> optional = showRepository.findById(Id);

		if (optional.isPresent()) {
			Show c = optional.get();
			ModelMapper mapper = new ModelMapper();
			ShowResponseModel returnObject = mapper.map(c, ShowResponseModel.class);
			return returnObject;
		}

		return null;
		
	}
	
	public ShowResponseModel updateShow(String id,ShowRequestModel requestModel) {
		Optional<Show> optional = showRepository.findById(id);
		if (optional.isPresent()) {
			ModelMapper mapper = new ModelMapper();
			Show c = mapper.map(requestModel, Show.class);
			c.setShowId(id);
			showRepository.save(c);
			ShowResponseModel trm = mapper.map(c, ShowResponseModel.class);
			return trm;
		}

		return null;

	}

	public void deleteShow(String id) {
		showRepository.deleteById(id);
	}
}
