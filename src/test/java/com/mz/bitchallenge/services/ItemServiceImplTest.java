package com.mz.bitchallenge.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.mz.bitchallenge.dtos.ItemDTO;
import com.mz.bitchallenge.services.impl.ItemServiceImpl;
import com.mz.bitchallenge.util.TestUtils;

@ExtendWith(MockitoExtension.class)
public class ItemServiceImplTest {

	@Mock
	private RestTemplate restTemplateMock;
	
	@InjectMocks
	private ItemServiceImpl itemService = new ItemServiceImpl();
	
	private String apiURLFake = "http://getallitems.com";
	
	@BeforeEach
	public void initialize() {
		ReflectionTestUtils.setField(itemService, "itemsHostAddress", apiURLFake);
	}
	
	@Test
	public void testCallGetItemsWithNoParamsMustReturnAllItems() {
		String firstItemName = "Celular";
		String lastItemName = "Forno";
		ItemDTO[] responseItemsFromApiMocky = new TestUtils().createMockedFullResponseArray();
		Mockito.when(restTemplateMock.getForObject("http://getallitems.com", ItemDTO[].class)).thenReturn(responseItemsFromApiMocky);
		List<ItemDTO> itemsResponse = itemService.getItems(null, null);
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
		ItemDTO[] responseItemsFromApiMocky = new TestUtils().createMockedFullResponseArray();
		Mockito.when(restTemplateMock.getForObject("http://getallitems.com", ItemDTO[].class)).thenReturn(responseItemsFromApiMocky);
		List<ItemDTO> itemsResponse = itemService.getItems(beginDate, finalDate);
		assertNotNull(itemsResponse);
		assertTrue(itemsResponse.size() == 3);
		assertTrue(itemsResponse.get(0).getName().equals(firstItemName));
		assertTrue(itemsResponse.get(itemsResponse.size() -1).getName().equals(lastItemName));
	}

}
