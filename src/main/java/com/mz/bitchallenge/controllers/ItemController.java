package com.mz.bitchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.bitchallenge.dtos.ItemDTO;
import com.mz.bitchallenge.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemDTO> getItem() {
		List<ItemDTO> itemsReturned = itemService.getItems();
		return itemsReturned;
	}
}
