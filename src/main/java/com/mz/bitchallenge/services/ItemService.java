package com.mz.bitchallenge.services;

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

@Service
public class ItemService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${items.address}")
	private String itemAddress;
	
	public List<ItemDTO> getItems(String beginDate, String finalDate) {
		
		ItemDTO[] responseItems = restTemplate.getForObject(itemAddress, ItemDTO[].class);
		List<ItemDTO> items = Arrays.asList(responseItems);
		
		if(StringUtils.hasText(beginDate) && StringUtils.hasText(finalDate)) {
			
			try {
				return performFilter(beginDate, finalDate, items);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return items;
	}

	private List<ItemDTO> performFilter(String beginDate, String finalDate, List<ItemDTO> items) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date beginDateParsed = formatter.parse(beginDate);
		Date finalDateParsed = formatter.parse(finalDate);
		
		// Adding one day to final Date (the final date til 23:59:59 must be considered on the result filter)
		LocalDateTime finalDatePlusADay = LocalDateTime.from(finalDateParsed.toInstant().atZone(ZoneId.of("UTC"))).plusDays(1);
		finalDateParsed = Date.from(finalDatePlusADay.atZone(ZoneId.systemDefault()).toInstant());
		
		List<ItemDTO> filteredItems = new ArrayList<>();
		
		for (ItemDTO itemDTO : items) {
			if(itemDTO.getDate().after(beginDateParsed) && itemDTO.getDate().before(finalDateParsed)) {
				filteredItems.add(itemDTO);
			}
		}
		return filteredItems;
	}
}
