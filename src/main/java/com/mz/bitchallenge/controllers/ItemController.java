package com.mz.bitchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bitchallenge.dtos.ItemDTO;
import com.mz.bitchallenge.services.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "/items", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public List<ItemDTO> getItems(
			@RequestParam(name = "begindate", required = false) String beginDate,
			@RequestParam(name = "finaldate", required = false) String finalDate) {
		log.info("Init of ItemController getItems method - Params: beginDate={}, finalDate={}", beginDate, finalDate);
		List<ItemDTO> itemsReturned = itemService.getItems(beginDate, finalDate);
		return itemsReturned;
	}
}
