package com.example.TT.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.TT.utils.entity.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "my_item_Img")
@Getter
@Setter
@NoArgsConstructor
public class ItemImg extends BaseEntity{

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "ItemImg_id")
	private Long id;   //상품 코드
	
//	파일업로드 이름
	private String imgName;
	
//	원래이름
	private String oriImgName;
	
	private String imgUrl;
	
	private String repImgYn;
	
	@JoinColumn(name = "item_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private item item;

	
	public void UpdateItemImg(String oriImgName,String imgName, String imgUrl) {
		this.imgName = imgName;
		this.oriImgName = oriImgName;
		this.imgUrl = imgUrl;
	}
	
	
}
