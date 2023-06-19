package com.example.TT.item.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class FileService {

	public String uploadFile(String uploadPath, String oriFileName,byte[] fileData) throws IOException{
		
		UUID uuid = UUID.randomUUID();
		String extension = oriFileName.substring(oriFileName.lastIndexOf("."));
		String savedFileName = uuid.toString() + extension;
		String fileUploadUrl = uploadPath + "/" + savedFileName;
		FileOutputStream fos = new FileOutputStream(fileUploadUrl);
		
		fos.write(fileData);
		fos.close();
		return savedFileName;	
	}
	
	public void deleteFile(String filePath) {
		File deletFile = new File(filePath);
		
		if(deletFile.exists()) {
			deletFile.delete();
			log.info("파일을 삭제했습니다.");
		}
		else
		{
			log.info("파일이 존재하지 않습니다.");
		}
	}
}
