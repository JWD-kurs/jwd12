package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Activity;
import jwd.wafepa.web.dto.ActivityDTO;

@Component
public class ActivityToActivityDTO implements Converter<Activity, ActivityDTO> {

	@Override
	public ActivityDTO convert(Activity activity) {
		ActivityDTO ret = new ActivityDTO();
		
		ret.setId(activity.getId());
		ret.setName(activity.getName());
		
		return ret;
	}
	
	public List<ActivityDTO> convert(List<Activity> activities){
		List<ActivityDTO> ret = new ArrayList<>();
		for(Activity a : activities){
			ret.add(convert(a));
		}
		return ret;
	}
}
