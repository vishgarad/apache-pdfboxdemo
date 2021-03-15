package com.example.demo.service;

import java.io.File;

import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

@Service
public class ExtractImageText {
	public String extractTextFromImage() {
		File imageFile = new File("C:\\vishal\\pdfboxdemo\\PAN.png");
		//ITesseract instance = new Tesseract(); // JNA Interface Mapping
		 ITesseract instance = new Tesseract1(); // JNA Direct Mapping
		File tessDataFolder = LoadLibs.extractTessResources("tessdata");
		instance.setDatapath(tessDataFolder.getAbsolutePath()); // path to tessdata directory
		instance.setLanguage("eng");
		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
			return result;
		} catch (TesseractException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
