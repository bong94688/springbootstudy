package com.example.TT.item.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.example.TT.item.constant.itemSellStatus;
import com.example.TT.item.entity.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ItemFormDto {

	private Long id;   //상품 코드
	
	@NotBlank(message = "상품명은 필수 항목 입니다.")
	private String itemNm;  //상품 이름
	
	@NotNull(message = "가격은 필수 항목 입니다.")
	private int price;   //상품 가격
	
	@NotNull(message = "재고는 필수 항목 입니다.")
	private int stockNumber; //재고 수량
	
	private itemSellStatus itemSellStatus;
	
	@NotBlank(message = "상품 설명은 필수 항목 입니다.")
	private String itemDetail; //상품 상세 설명
	
	private List<ItemImgDto> itemImgDtoList = new ArrayList<>();
	
	private List<Long> itemImgIds = new ArrayList<>();
	
	private static ModelMapper mapper = new ModelMapper();
	
	public item createItem() {
		
		return mapper.map(this,item.class);
	}
	
	public static ItemFormDto of(item item) {
		
		return mapper.map(item, ItemFormDto.class);
	}
}
