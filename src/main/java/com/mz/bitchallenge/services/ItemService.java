package com.mz.bitchallenge.services;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.mz.bitchallenge.dtos.DimensionDTO;
import com.mz.bitchallenge.dtos.ItemDTO;

@Service
public class ItemService {

	public ItemDTO getItem() {
		
		DimensionDTO dimension = new DimensionDTO();
		dimension.setWeight(10.5);
		dimension.setHeight(10.5);
		dimension.setWidth(10.5);
		dimension.setLength(10.5);
		
		ItemDTO item = new ItemDTO();
		item.setName("Celular");
		item.setCode("1");
		item.setDate("2016-10-01T14:30:37.040Z");
		item.setDimension(dimension);
		
		// To convert and filter after
		Date date = Date.from(Instant.parse("2016-10-01T14:30:37.040Z"));
		
		return item;
	}
}
