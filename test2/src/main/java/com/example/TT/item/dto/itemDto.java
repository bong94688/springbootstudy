package com.example.TT.item.dto;

import java.time.LocalDateTime;

import com.example.TT.item.constant.itemSellStatus;
import com.example.TT.utils.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class itemDto extends BaseEntity{
	
	private Long id;   //상품 코드
	
 	private String itemNm;  //상품 이름
	
	private int price;   //상품 가격
	
	private int stockNumber; //재고 수량
	
	private itemSellStatus itemSellStatus;
	
	private String itemDetail; //상품 상세 설명

}
