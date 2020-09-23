package com.capg.otms.ms.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.otms.ms.exception.InvalidInputException;
import com.capg.otms.ms.exception.MovieException;
import com.capg.otms.ms.model.Screen;

import com.capg.otms.ms.repository.ScreenRepo;

//it indicates the class as a service class
@Service
public class ScreenServiceImpl implements IScreenService {

	//Repo object will be injected into service while creating controller in WebApplicationContext
	@Autowired
	ScreenRepo screenRepo;

	
	// implements abstract classes from service interface by overriding those methods so that we write our own code
	@Override
	public Screen addScreen(Screen screen)  {

		Integer screenId = screen.getScreenId();
		if (screenId == 0) {
			throw new InvalidInputException("screen id cannot be 0 ");
		}
		return screenRepo.saveAndFlush(screen);
	}
	
	

	@Override
	public Screen updateScreenById(Screen screen) {
		Integer screenId = screen.getScreenId();
		if (screenId == 0) {
			throw new InvalidInputException("screen id cannot be 0 ");
		} else if (screenRepo.existsById(screenId)) {
			Screen updateScreen = screenRepo.getOne(screenId);
			updateScreen.setScreenName(screen.getScreenName());
			updateScreen.setColumns(screen.getColumns());
			updateScreen.setRows(screen.getRows());
			updateScreen.setMovieEndDate(screen.getMovieEndDate());
			screenRepo.saveAndFlush(updateScreen);
		}
		return screen;		
	}

	@Override
	public boolean deleteScreenById(int screenId) { // it will call screenRepo interface inbuilt method and returns boolean true or false
		

		if (screenRepo.existsById(screenId)) {
			screenRepo.deleteById(screenId);
		} else {
			throw new MovieException("Id not found");
		}
		return true;
	}

	@Override
	public List<Screen> findAllScreens() { //It will call the method from screenRepo and return list of screens
		
		return screenRepo.findAll();
	}

	@Override
	public Screen getScreenById(int screenId) {
		
		return screenRepo.getOne(screenId);
	}

	@Override
	public boolean validateScreenId(int screenId) {
		String screen = Integer.toString(screenId);
		if (!(screen.length()>= 1))
			throw new MovieException("ScreenId cannot be zero");
		return true;
	}
}


