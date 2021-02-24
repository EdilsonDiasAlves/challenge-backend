package com.mz.bitchallenge.services;

import java.util.List;

import com.mz.bitchallenge.dtos.ItemDTO;

public interface ItemService {
	
	public List<ItemDTO> getItems(String beginDate, String finalDate);
}
