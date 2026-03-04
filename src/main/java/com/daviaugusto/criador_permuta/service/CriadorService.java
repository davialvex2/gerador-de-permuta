package com.daviaugusto.criador_permuta.service;

import com.daviaugusto.criador_permuta.Infrastructure.entities.Dados;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CriadorService {



    public byte[] criarPermuta(Dados dados) {

        try {

            String entrada = "GTE.pdf";
            String saida = "PERMUTAPREENCHIDA.pdf";

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfReader pdfReader = new PdfReader(entrada);
            PdfStamper pdfStamper = new PdfStamper(pdfReader, baos);




            PdfContentByte paginapdf = pdfStamper.getOverContent(1);

            BaseFont fonte = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED);
            paginapdf.beginText();
            paginapdf.setFontAndSize(fonte, 11);


            // PRIMEIRA PARTE
           paginapdf.setTextMatrix(90f, 713f);
           paginapdf.showText(dados.getSecaoSubstituto());

           paginapdf.setTextMatrix(90f, 698f);
           paginapdf.showText(dados.getSecaoEscalado());

           paginapdf.setTextMatrix(195f, 713f);
           paginapdf.showText(dados.getNomeSubstituto());

           paginapdf.setTextMatrix(195f, 698f);
           paginapdf.showText(dados.getNomeEscalado());

           paginapdf.setTextMatrix(146f, 684f);
           paginapdf.showText(dados.getPostoServico());

            paginapdf.setTextMatrix(360f, 684f);
            paginapdf.showText(dados.getDataServico());


           //SEGUNDA PARTE

            paginapdf.setTextMatrix(90f, 494f);
            paginapdf.showText(dados.getSecaoSubstituto());

            paginapdf.setTextMatrix(90f, 479f);
            paginapdf.showText(dados.getSecaoEscalado());

            paginapdf.setTextMatrix(195f, 494f);
            paginapdf.showText(dados.getNomeSubstituto());

            paginapdf.setTextMatrix(195f, 479f);
            paginapdf.showText(dados.getNomeEscalado());

            paginapdf.setTextMatrix(146f, 465f);
            paginapdf.showText(dados.getPostoServico());

            paginapdf.setTextMatrix(360f, 465f);
            paginapdf.showText(dados.getDataServico());



            //TERCEIRA PARTE


            paginapdf.setTextMatrix(90f, 319f);
            paginapdf.showText(dados.getSecaoSubstituto());

            paginapdf.setTextMatrix(90f, 305f);
            paginapdf.showText(dados.getSecaoEscalado());

            paginapdf.setTextMatrix(195f, 319f);
            paginapdf.showText(dados.getNomeSubstituto());

            paginapdf.setTextMatrix(195f, 305f);
            paginapdf.showText(dados.getNomeEscalado());

            paginapdf.setTextMatrix(146f, 290f);
            paginapdf.showText(dados.getPostoServico());

            paginapdf.setTextMatrix(360f, 290f);
            paginapdf.showText(dados.getDataServico());

           paginapdf.endText();
            pdfStamper.close();
            pdfReader.close();

            System.out.println("PDF criado comm sucesso");
            return baos.toByteArray();
        }
        catch(IOException | DocumentException e ){
            throw new RuntimeException("Erro ao criar PDF");
        }

    }

}
