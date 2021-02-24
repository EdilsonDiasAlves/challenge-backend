package com.mz.bitchallenge.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.mz.bitchallenge.dtos.ItemDTO;
import com.mz.bitchallenge.services.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${items.address}")
	private String itemsHostAddress;
	
	public List<ItemDTO> getItems(String beginDate, String finalDate) {
		log.info("Init of ItemService getItems method - Params: beginDate={}, finalDate={}", beginDate, finalDate);
		
		log.info("Making request to mocky API - URL: {}", itemsHostAddress);
		ItemDTO[] responseItems = restTemplate.getForObject(itemsHostAddress, ItemDTO[].class);
		List<ItemDTO> items = Arrays.asList(responseItems);
		
		// Filters only if the list is not empty and parameters are informed
		if(StringUtils.hasText(beginDate) && 
				StringUtils.hasText(finalDate) && 
				items != null &&
				!items.isEmpty()) {
			try {
				log.info("Parameterized search. The response must be filtered");
				return performFilter(beginDate, finalDate, items);
			} catch (ParseException e) {
				log.error("Error trying to filter the result. Details: {}", e);
			}
		}
		
		log.info("End of the ItemService getItems method. Result to be returned: {}", items);
		return items;
	}

	private List<ItemDTO> performFilter(String beginDate, String finalDate, List<ItemDTO> items) throws ParseException {
		log.info("Init of ItemService performFilter method - Params: beginDate={}, finalDate={}, items={}", beginDate, finalDate, items);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date beginDateParsed = formatter.parse(beginDate);
		Date finalDateParsed = formatter.parse(finalDate);
		
		// Adding one day to the final Date (the final date til 23:59:59 must be considered on the result filter)
		LocalDateTime finalDatePlusADay = LocalDateTime.from(finalDateParsed.toInstant().atZone(ZoneId.of("UTC"))).plusDays(1);
		finalDateParsed = Date.from(finalDatePlusADay.atZone(ZoneId.systemDefault()).toInstant());
		
		List<ItemDTO> filteredItems = new ArrayList<>();
		
		for (ItemDTO itemDTO : items) {
			if(itemDTO.getDate().after(beginDateParsed) && itemDTO.getDate().before(finalDateParsed)) {
				filteredItems.add(itemDTO);
			}
		}
		
		log.info("End of the ItemService performFilter method. Result to be returned: {}", filteredItems);
		return filteredItems;
	}
}
