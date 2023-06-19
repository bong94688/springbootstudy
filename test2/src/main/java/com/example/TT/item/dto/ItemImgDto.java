package com.example.TT.item.dto;

import org.modelmapper.ModelMapper;

import com.example.TT.item.entity.ItemImg;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class ItemImgDto {
	private Long id;   //상품 코드
	
//	파일업로드 이름
	private String imgName;
	
//	원래이름
	private String oriImgName;
	
	private String imgUrl;
	
	private String repImgYn;
	
	private static ModelMapper mapper = new ModelMapper();
	
	public static ItemImgDto of(ItemImg img){
		return mapper.map(img, ItemImgDto.class);
	}
}
