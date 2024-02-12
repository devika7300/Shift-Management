package com.syr.zen.shift_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syr.zen.shift_service.repositories.ShiftRepository;

@Service
public class ShiftService {
	@Autowired
	private ShiftRepository shiftRepository;

	public Shift addShift(ShiftEntity event){
		ShiftEntity shEntity = new ShiftEntity();
		shEntity = shiftRepository.save(event);
		Event evt = new Event();
		BeanUtils.copyProperties(shEntity, evt);
		return evt;
	}

	public void deleteShift(Integer eventId){
		shiftRepository.deleteById(eventId);
	}

	public Optional<ShiftEntity> getShiftsById(Integer eventId) {
		return shiftRepository.findById(eventId);
	}


	public List<Event> getAllShifts() {
		List<ShiftEntity> shEntity = new ArrayList<>();
		List<Event> result = new ArrayList<>();
		shEntity = shiftRepository.findAll();
		for (Object source : shEntity) {
			Event target = new Event();
			BeanUtils.copyProperties(source, target);
			result.add(target);
		}
		return result;
	}
}
