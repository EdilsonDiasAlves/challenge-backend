package com.mz.bitchallenge.util;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

import com.google.gson.Gson;
import com.mz.bitchallenge.dtos.ItemDTO;

/*
 * Utility class for testing, can be used to create more elaborate mocks or specific treatments
 */
public class TestUtils {
	String itemsResponseJson = "[ { name: \"Celular\", code: \"1\", date: \"2016-10-01T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Xbox\", code: \"2\", date: \"2016-10-02T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Televisao\", code: \"3\", date: \"2016-10-03T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Caixa de Som\", code: \"4\", date: \"2016-10-04T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Impressora\", code: \"5\", date: \"2016-10-05T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Fifa2017\", code: \"6\", date: \"2016-10-06T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Notebook\", code: \"7\", date: \"2016-10-07T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Tablet\", code: \"8\", date: \"2016-10-08T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Computador\", code: \"9\", date: \"2016-10-09T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Guarda-Roupa\", code: \"10\", date: \"2016-10-10T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Fogao\", code: \"11\", date: \"2016-10-11T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Freezer\", code: \"12\", date: \"2016-10-12T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } }, { name: \"Forno\", code: \"13\", date: \"2016-10-13T14:30:37.040Z\", dimension: { weight: 10.5, height: 10.5, width: 10.5, length: 10.5 } } ]";
	
	public List<ItemDTO> createMockedFullResponse() {
		ItemDTO[] itemsResponseParsed = new Gson().fromJson(itemsResponseJson, ItemDTO[].class);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<ItemDTO> itemsResponse =  new ArrayList(Arrays.asList(itemsResponseParsed));
		return itemsResponse;
	}
	
	public ItemDTO[] createMockedFullResponseArray() {
		return new Gson().fromJson(itemsResponseJson, ItemDTO[].class);
	}
	
	public List<ItemDTO> createMockedFilteredResponse() {
		ItemDTO[] itemsResponseParsed = new Gson().fromJson(itemsResponseJson, ItemDTO[].class);
		List<ItemDTO> itemsResponseFiltered =  new ArrayList<>();
		itemsResponseFiltered.add(itemsResponseParsed[2]);
		itemsResponseFiltered.add(itemsResponseParsed[3]);
		itemsResponseFiltered.add(itemsResponseParsed[4]);
		return itemsResponseFiltered;
	}	
}
