package com.mz.bitchallenge.controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mz.bitchallenge.dtos.ItemDTO;
import com.mz.bitchallenge.services.ItemService;
import com.mz.bitchallenge.util.TestUtils;

@ExtendWith(MockitoExtension.class)
public class ItemControllerTest {

	@Mock
	private ItemService itemService;
	
	@InjectMocks
	private ItemController itemController = new ItemController();
	
	@Test
	public void testCallGetItemsWithNoParamsMustReturnAllItems() {
		String firstItemName = "Celular";
		String lastItemName = "Forno";
		List<ItemDTO> responseItems = new TestUtils().createMockedFullResponse();
		Mockito.when(itemService.getItems(null, null)).thenReturn(responseItems);
		List<ItemDTO> itemsResponse = itemController.getItems(null, null);
		assertNotNull(itemsResponse);
		assertTrue(itemsResponse.size() == 13);
		assertTrue(itemsResponse.get(0).getName().equals(firstItemName));
		assertTrue(itemsResponse.get(itemsResponse.size() -1).getName().equals(lastItemName));
	}
	
	@Test
	public void testCallGetItemsWithParamsMustReturnFilteredItems() {
		String beginDate = "03-10-2016";
		String finalDate = "05-10-2016";
		String firstItemName = "Televisao";
		String lastItemName = "Impressora";
		List<ItemDTO> responseItemsFiltered = new TestUtils().createMockedFilteredResponse();
		Mockito.when(itemService.getItems(beginDate, finalDate)).thenReturn(responseItemsFiltered);
		assertNotNull(itemController.getItems(beginDate, finalDate));
		assertTrue(responseItemsFiltered.size() == 3);
		assertTrue(responseItemsFiltered.get(0).getName().equals(firstItemName));
		assertTrue(responseItemsFiltered.get(responseItemsFiltered.size() -1).getName().equals(lastItemName));
	}

}
