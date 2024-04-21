package com.ngalaxy.registration.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ngalaxy.registration.model.FileResponseDTO;

@RequestMapping("/file")
@RestController
public class FileUploadController {

	@PostMapping("/upload")
	public ResponseEntity<FileResponseDTO> fileUpload(@RequestParam("file") MultipartFile file) throws Exception{
		
		try {
            byte[] fileContent = file.getBytes();

            // Create DTO and set file metadata and content
            FileResponseDTO responseDTO = new FileResponseDTO();
            responseDTO.setFilename(file.getOriginalFilename());
            responseDTO.setContentType(Files.probeContentType(Paths.get(file.getOriginalFilename())));
            responseDTO.setContent(fileContent);

            return new ResponseEntity<FileResponseDTO>(responseDTO, HttpStatus.OK);
        } catch (IOException ex) {
            // Handle error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
}
