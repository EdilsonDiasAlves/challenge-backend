package com.mz.bitchallenge.dtos;

import lombok.Data;

@Data
public class ItemDTO {
	private String name;
	private String code;
	private String date;
	private DimensionDTO dimension;
}