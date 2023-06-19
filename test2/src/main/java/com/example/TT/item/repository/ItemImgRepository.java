package com.example.TT.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.TT.item.entity.ItemImg;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long>{

//	@Query("select i from ItemImg i where i.item = :itemid")

	List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);	
}
