package com.mz.bitchallenge.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mz.bitchallenge.dtos.DimensionDTO;
import com.mz.bitchallenge.dtos.ItemDTO;

@Service
public class ItemService {

	public List<ItemDTO> getItems() {
		
		DimensionDTO dimension = new DimensionDTO();
		dimension.setWeight(10.5);
		dimension.setHeight(10.5);
		dimension.setWidth(10.5);
		dimension.setLength(10.5);
		
		List<ItemDTO> items = new ArrayList<>();
		
		ItemDTO item1 = new ItemDTO();
		item1.setName("Celular");
		item1.setCode("1");
		item1.setDate("2016-10-01T14:30:37.040Z");
		item1.setDimension(dimension);
		
		ItemDTO item2 = new ItemDTO();
		item2.setName("Celular");
		item2.setCode("1");
		item2.setDate("2016-10-01T14:30:37.040Z");
		item2.setDimension(dimension);
		
		items.add(item1);
		items.add(item2);
		
		// To convert and filter after
		Date date = Date.from(Instant.parse("2016-10-01T14:30:37.040Z"));
		
		return items;
	}
}
