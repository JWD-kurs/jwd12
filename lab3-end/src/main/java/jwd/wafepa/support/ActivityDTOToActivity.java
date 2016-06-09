package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.web.dto.ActivityDTO;

@Component
public class ActivityDTOToActivity 
	implements Converter<ActivityDTO, Activity> {
	
	@Autowired
	private ActivityService activityService;

	@Override
	public Activity convert(ActivityDTO activityDTO) {
		Activity ret = new Activity();
		
		if(activityDTO.getId()!=null){
			ret = activityService.findOne(activityDTO.getId());
		}
		
		ret.setId(activityDTO.getId());
		ret.setName(activityDTO.getName());
		
		return ret;
	}
	
	public List<Activity> convert(List<ActivityDTO> activitiesDTO){
		List<Activity> ret = new ArrayList<>();
		
		for(ActivityDTO dto: activitiesDTO){
			ret.add(convert(dto));
		}
		
		return ret;
	}

}
