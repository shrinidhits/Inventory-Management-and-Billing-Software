/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.billing_system;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.text.PDFTextStripper;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
/**
 *
 * @author Shrinidhi T S
 */
import java.util.*;
public class bill_generator {
    
    public bill_generator(int bill_number,
                          String buyer_name,
                          String buyer_number,
                          ArrayList<Integer> item_nos, 
                          ArrayList<String> item_names,
                          ArrayList<Integer> item_qtys,
                          ArrayList<Integer> item_prices ,
                          int total)
    {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try{
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            int no_of_items=item_nos.size();
            contentStream.setFont(PDType1Font.COURIER,15);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("===============================================");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("%         G E N E R A L     S T O R E S       %");
            contentStream.newLineAtOffset(0, -40);
            contentStream.showText("%               CUSTOMER INVOICE              %");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("===============================================");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Bill number:   "+bill_number);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("===============================================");
            contentStream.newLineAtOffset(0, -40);
            contentStream.showText("Customer Name: "+buyer_name+"   Phone No.:"+buyer_number);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("===============================================");
            contentStream.newLineAtOffset(0, -40);
            contentStream.showText("Sl.no | Item no. |     Item Name|  Qty|  Price");
            contentStream.newLineAtOffset(0, -25);
            int sl_no=1;
            for(int i=0;i<no_of_items;i++)
            {
                contentStream.showText(String.format("%2d",sl_no)+"       "+String.format("%2d",item_nos.get(i))+"   "+String.format("%15s",item_names.get(i))+"    "+String.format("%2d",item_qtys.get(i))+"   "+String.format("%5d",item_prices.get(i)));
                contentStream.newLineAtOffset(0, -15);
                sl_no++;
            }
            contentStream.newLineAtOffset(0, -50);
            contentStream.showText("         Total price:    "+total);
            contentStream.newLineAtOffset(0, -25);
            contentStream.showText("===============================================");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("%             Contact No: 2334655             %");
            contentStream.newLineAtOffset(0, -30);
            contentStream.showText("%            THANK YOU VISIT AGAIN            %");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("===============================================");
            contentStream.close();
            document.save("E:\\Bills\\"+bill_number+".pdf");
            document.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}