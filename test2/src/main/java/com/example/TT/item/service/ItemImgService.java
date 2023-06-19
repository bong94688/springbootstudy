package com.example.TT.item.service;

import java.io.IOException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.example.TT.item.entity.ItemImg;
import com.example.TT.item.repository.ItemImgRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemImgService {

	@Value(value = "${itemImgLocation}")
	private String itemImgLocation;
	
	private final FileService fileService;
	private final ItemImgRepository imgRepository;

	
	public void saveItemImg(ItemImg itemImg,MultipartFile ItemImgFile) throws IOException {
		String oriImgName = ItemImgFile.getOriginalFilename();
		String ImgName = "";
		String imgUrl="";
		
		if(!StringUtils.isEmpty(oriImgName)) {
			ImgName = fileService.uploadFile(itemImgLocation, oriImgName, ItemImgFile.getBytes());
			imgUrl = "/images/items/"+ImgName;
		}
		itemImg.UpdateItemImg(oriImgName, ImgName, imgUrl);
		imgRepository.save(itemImg);
	}
	
	public void updateItemImg(Long ItemImgId, MultipartFile itemImgFile) throws IOException {
		if(!itemImgFile.isEmpty()) {
			ItemImg itemImg = imgRepository.findById(ItemImgId).orElseThrow(EntityNotFoundException::new);
			
			
			if(!StringUtils.isEmpty(itemImg.getImgName())) {
				fileService.deleteFile(itemImgLocation+"/"+itemImg.getImgName());
			}
			
			String oriName = itemImgFile.getOriginalFilename();
			String imgName = fileService.uploadFile(itemImgLocation, oriName, itemImgFile.getBytes());
			String imgUrl = "/images/item/"	+ imgName;
			
			itemImg.UpdateItemImg(oriName, imgName, imgUrl);
			
		}
	}
}
