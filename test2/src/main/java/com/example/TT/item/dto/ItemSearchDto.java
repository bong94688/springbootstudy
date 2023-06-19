package com.example.TT.item.dto;

import com.example.TT.item.constant.itemSellStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ItemSearchDto {

	private String searchDateType;

    private itemSellStatus searchSellStatus;

    private String searchBy;

    private String searchQuery = "";
}
