package com.syr.zen.shift_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syr.zen.shift_service.services.ShiftService;

@Controller
@RequestMapping(value = "/shift")
public class ShiftController {

	@Autowired
	ShiftService shiftService;

	@PostMapping("/signupshifts")
	public ResponseEntity<Event> signup(@RequestBody Event event){
		ShiftEntity shEntity = new ShiftEntity();
	    	BeanUtils.copyProperties(shEntity, event);
	        return ResponseEntity.ok(shiftService.signup(shEntity));
	}

	@GetMapping
	public ResponseEntity<List<Event>> getAllShifts() {
		return ResponseEntity.ok(shiftService.getAllShifts());
	}

	@GetMapping("/{eventId}")
	public ResponseEntity<ShiftEntity> getShiftById(@PathVariable Integer eventId) {
	        Optional<ShiftEntity> event = shiftService.getShiftById(eventId);
	        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{eventId}")
	public ResponseEntity<Void> deleteShift(@PathVariable Integer eventId) {
	        shiftService.deleteShift(eventId);
	        return ResponseEntity.ok().build();
	}
}
