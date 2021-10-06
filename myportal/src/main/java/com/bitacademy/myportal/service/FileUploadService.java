package com.bitacademy.myportal.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FileUploadService.class);
	// 파일 저장 위치
	private static String SAVE_PATH = "c:/upload/";

	public String store(MultipartFile multipartFile) {
		String saveFilename = "";

		try {
			String originalFilename = multipartFile.getOriginalFilename();
			Long size = multipartFile.getSize();
			logger.debug(originalFilename);
			logger.debug("filesize : " + size);
			String extName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
			// 확장자 이름 추출 및 중복 없는 파일 이름으로 변경
			saveFilename = getSaveFilename(extName);
			writeFile(multipartFile, saveFilename);

		} catch (IOException e) {
			logger.error("파일 저장 실패");
			throw new RuntimeException(e);
		}

		return saveFilename;
	}

	private String getSaveFilename(String ext) { // ext:확장자
		// 중복되지 않는 파일명 생성
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis() / 1000) + ext.toLowerCase();
	}

	private void writeFile(MultipartFile mFile, String saveFileName) throws IOException { // 원본 멀티파트 파일

		// 저장할 파일 바이너리
		byte[] fileData = mFile.getBytes();

		FileOutputStream fos = new FileOutputStream(SAVE_PATH + saveFileName);
		fos.write(fileData);
		fos.flush();
		fos.close();

	}

}
