package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ExtractImageText;
import com.example.demo.service.SaveImagesInPdf;

@RestController
public class ExtractImageFromController {
	
	
	
	@Autowired
	private  SaveImagesInPdf  saveimgpdf;
	@Autowired
	private ExtractImageText extraxtImageTest;
	
	@GetMapping("/extractimg")
	public String  extractImage()
	{
		try {
		//extractimgservice.extractImagePdf();
			saveimgpdf.extractAllImages();
		return "image saved to the file";
		}catch(IOException e)
		{
			return "Exception is : "+e.getMessage();
		}
		
	}
	@GetMapping("/extractimgtext")
	public String   extractImageText()
	{
	String extractedText=	extraxtImageTest.extractTextFromImage();
		
	return extractedText;
	}
	
	

}
