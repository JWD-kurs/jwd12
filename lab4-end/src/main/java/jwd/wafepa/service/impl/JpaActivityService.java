package jwd.wafepa.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Activity;
import jwd.wafepa.repository.ActivityRepository;
import jwd.wafepa.service.ActivityService;

@Service
public class JpaActivityService implements ActivityService {
	@Autowired
	private ActivityRepository activityRepository;
	
//	@PostConstruct
//	public void БилоШта(){
//		save(new Activity("Swimming"));
//		save(new Activity("Running"));
//	}

	@Override
	public Activity findOne(Long id) {
		return activityRepository.findOne(id);
	}

	@Override
	public List<Activity> findAll() {
		return activityRepository.findAll();
	}

	@Override
	public Activity save(Activity activity) {
		return activityRepository.save(activity);
	}

	@Override
	public List<Activity> save(List<Activity> activities) {
		
		return activityRepository.save(activities);
	}

	@Override
	public Activity delete(Long id) {
		Activity activity = activityRepository.findOne(id);
		
		if(activity==null){
			throw new IllegalArgumentException(
					"Removing nonexistant activity");
		}
		
		activityRepository.delete(activity);
		
		return activity;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			activityRepository.delete(id);
		}

	}

	@Override
	public List<Activity> findByName(String name) {
		
		return activityRepository.findByName(name);
	}

}
