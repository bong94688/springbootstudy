package com.example.TT.item.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.TT.item.dto.ItemSearchDto;
import com.example.TT.item.entity.item;

public interface ItemRepositoryCustom {

	
	Page<item> getAdminItemPage(ItemSearchDto itemSearchDto,Pageable pageable);
}
