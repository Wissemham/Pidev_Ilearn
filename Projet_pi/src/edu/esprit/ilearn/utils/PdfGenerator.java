/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.ilearn.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.esprit.ilearn.entities.Commande;
import edu.esprit.ilearn.services.ServiceLigneCommande;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class PdfGenerator {

    public static void pdfs()  throws DocumentException, FileNotFoundException, SQLException {

        Connection con = MyDB.getInstance().getConnection();
        Statement stmt = con.createStatement();
        /* Define the SQL query */
        ResultSet query_set = stmt.executeQuery("SELECT *From lignecommande");
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:\\Users\\ASUS\\Desktop\\java.pdf"));
        my_pdf_report.open();
        my_pdf_report.add(new Paragraph("                                       Votre Element Commande"));
        my_pdf_report.add(new Paragraph(" "));
         my_pdf_report.add(new Paragraph(" "));
        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(3);
        //create a cell object
        PdfPCell table_cell;
         PdfPCell c1 = new PdfPCell(new Phrase("IdC"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    my_report_table.addCell(c1);

    c1 = new PdfPCell(new Phrase("IdF"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    my_report_table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Prix DT"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    my_report_table.addCell(c1);
        while (query_set.next()) {
            String dept_id = query_set.getString("idcommand");
            table_cell = new PdfPCell(new Phrase(dept_id));
            my_report_table.addCell(table_cell);
            String dept_name = query_set.getString("idformation");
            table_cell = new PdfPCell(new Phrase(dept_name));
            my_report_table.addCell(table_cell);
            String manager_id = query_set.getString("prix");
            table_cell = new PdfPCell(new Phrase(manager_id));
            my_report_table.addCell(table_cell);
//                                    String location_id=query_set.getString("Sum");
//                                    table_cell=new PdfPCell(new Phrase(location_id));
//                                    my_report_table.addCell(table_cell);
        }
        /* Attach report table to PDF */
        my_pdf_report.add(my_report_table);
        my_pdf_report.close();

        /* Close all DB related objects */
        query_set.close();
        stmt.close();
        con.close();

    }

}
