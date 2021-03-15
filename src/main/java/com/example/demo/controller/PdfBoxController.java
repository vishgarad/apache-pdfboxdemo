package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfBoxController {

	@GetMapping("/loadpdf")
	public String loadPdfFile()

	{
		try {
			// Loading an existing document
			File file = new File("C:\\vishal\\pdfboxdemo\\my_doc.pdf");
			PDDocument document = PDDocument.load(file);

			// Retrieving the pages of the document
			PDPage page = document.getPage(2);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// Begin the Content stream
			contentStream.beginText();

			// Setting the font to the Content stream
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

			// Setting the position for the line newLineAtOffset(50 , 780 y axis);
			contentStream.newLineAtOffset(21, 700);

			String text = "This is the sample document page 3 and we are adding content to it.";

			// Adding text in the form of string
			contentStream.showText(text);

			// Ending the content stream
			contentStream.endText();
			contentStream.close();
			PDPage page1 = document.getPage(3);
			PDPageContentStream contentStream1 = new PDPageContentStream(document, page1);

			// Begin the Content stream
			contentStream1.beginText();

			// Setting the font to the Content stream
			contentStream1.setFont(PDType1Font.TIMES_ROMAN, 12);

			// Setting the position for the line newLineAtOffset(50 , 780 y axis);
			contentStream1.newLineAtOffset(25, 780);

			String text1 = "This is the sample document page4  and we are adding content to it.";

			// Adding text in the form of string
			contentStream1.showText(text1);

			// Ending the content stream
			contentStream1.endText();

			System.out.println("Content added");

			// Closing the content stream
			contentStream1.close();
			PDPage page2 = document.getPage(4);
			PDPageContentStream contentStream2 = new PDPageContentStream(document, page2);

			// Begin the Content stream
			contentStream2.beginText();

			// Setting the font to the Content stream
			contentStream2.setFont(PDType1Font.TIMES_ROMAN, 12);

			// Setting the position for the line newLineAtOffset(50 , 780 y axis);
			contentStream2.newLineAtOffset(25, 780);

			String text2 = "This is the sample document page5  and we are adding content to it.";

			// Adding text in the form of string
			contentStream2.showText(text2);

			// Ending the content stream
			contentStream2.endText();

			System.out.println("Content added");

			// Closing the content stream
			contentStream2.close();

			// Saving the document
			document.save(new File("C:\\vishal\\pdfboxdemo\\my_doc.pdf"));

			// Closing the document
			document.close();
			return "content added to the first page sucessfullay";
		} catch (IOException e) {
			e.printStackTrace();
			return "content not added";
		}
	}

	@GetMapping("/extractpdf")
	public String extractTextFromPdf() {
		try {
			// Loading an existing document
			File file = new File("C:\\vishal\\pdfboxdemo\\my_doc.pdf");
			PDDocument document = PDDocument.load(file);

			// Instantiate PDFTextStripper class
			PDFTextStripper pdfStripper = new PDFTextStripper();

			// Retrieving text from PDF document
			String text = pdfStripper.getText(document);

			System.out.println(text);

			// Closing the document
			document.close();
			return text;
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@GetMapping("/split")
	public String splitPages()
	{
		try {
		File file = new File("C:\\vishal\\pdfboxdemo\\my_doc.pdf");
	      PDDocument document = PDDocument.load(file); 

	      //Instantiating Splitter class
	      Splitter splitter = new Splitter();

	      //splitting the pages of a PDF document
	      List<PDDocument> Pages = splitter.split(document);

	      //Creating an iterator 
	      Iterator<PDDocument> iterator = Pages.listIterator();

	      //Saving each page as an individual document
	      int i = 1;
	      while(iterator.hasNext()) {
	         PDDocument pd = iterator.next();
	         pd.save("C:\\vishal\\pdfboxdemo\\split-pdf\\page"+ i++ +".pdf");
	      }
	      System.out.println("Multiple PDF’s created");
	      document.close();
	      return "Multiple PDF’s created";
	   } catch(IOException e)
		{
		   e.printStackTrace();
		   return e.getMessage();
		}
	
		
	}

}
