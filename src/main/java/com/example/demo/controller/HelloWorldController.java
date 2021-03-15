package com.example.demo.controller;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/hi")
	public String displayHello() {

		try {
			PDDocument document = new PDDocument();

			// Saving the document
			for (int i = 0; i < 5; i++)
				document.addPage(new PDPage());
			document.save("C:\\vishal\\pdfboxdemo\\my_doc.pdf");

			System.out.println("PDF created");

			// Closing the document
			document.close();
			return "PDF created";
		} catch (IOException e) {
			e.printStackTrace();
			return "PDF  not created";
		}

	}

	@GetMapping("/hello")
	public String hello()
	{
		return "hello world";

	}
}
