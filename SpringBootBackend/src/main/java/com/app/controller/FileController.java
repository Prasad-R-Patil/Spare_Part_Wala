package com.app.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.utils.StorageService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
public class FileController {
	@Autowired
	private StorageService storageService;

	@RequestMapping(value="/{fileName}", produces = "image/*")
	public void download(@PathVariable("fileName") String fileName, HttpServletResponse resp) {
		System.out.println("Loading file: " + fileName);
		Resource resource = storageService.load(fileName);
		if(resource != null) {
			try(InputStream in = resource.getInputStream()) {
				ServletOutputStream out = resp.getOutputStream();
				FileCopyUtils.copy(in, out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
//	@Value("${project.image}")
//	private String path;
//	@Autowired
//	private FileService fileService;
//	@GetMapping(value = "/{fileName}", produces =MediaType.IMAGE_JPEG_VALUE )
//	public void downloadFile(@PathVariable String fileName, HttpServletResponse response) throws IOException {
//
//		
//		
//		InputStream resource = fileService.getResource(path, fileName);
//		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//		StreamUtils.copy(resource, response.getOutputStream());
//
//	}
	
}
