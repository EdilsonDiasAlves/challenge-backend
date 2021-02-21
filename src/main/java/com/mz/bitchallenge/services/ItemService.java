package com.mz.bitchallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mz.bitchallenge.dtos.ItemDTO;

@Service
public class ItemService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${items.address}")
	private String itemAddress;
	
	public List<ItemDTO> getItems() {
		
		ItemDTO[] responseItems = restTemplate.getForObject(itemAddress, ItemDTO[].class);
		List<ItemDTO> items = Arrays.asList(responseItems);
		
		// To convert and filter after
		// Date date = Date.from(Instant.parse("2016-10-01T14:30:37.040Z"));
		
		return items;
	}
}
