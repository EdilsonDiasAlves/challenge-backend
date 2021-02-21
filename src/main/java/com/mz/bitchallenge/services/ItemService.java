package com.mz.bitchallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.Gson;
import com.mz.bitchallenge.dtos.ItemDTO;

@Service
public class ItemService {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${items.address}")
	private String itemAddress;
	
	public List<ItemDTO> getItems() {
		
		String responseItems = webClientBuilder.build()
			.get()
			.uri(itemAddress)
			.retrieve()
			.bodyToMono(String.class)
			.block();
		
		ItemDTO[] response = new Gson().fromJson(responseItems, ItemDTO[].class);
		List<ItemDTO> items = Arrays.asList(response);
		
		// To convert and filter after
		// Date date = Date.from(Instant.parse("2016-10-01T14:30:37.040Z"));
		
		return items;
	}
}
