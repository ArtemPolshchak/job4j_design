package ru.job4j;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PdfToExcelConverter {

    public static void main(String[] args) throws IOException {
        String pdfFilePath = "C:\\projects\\PDFDOCUMENTS\\Invoices_06-04-2024-350.pdf";
        String excelFilePath = "C:\\projects\\PDFDOCUMENTS\\output.xlsx";

        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Data");
            int rowNum = 0;

            for (int i = 0; i < document.getNumberOfPages(); i++) {
                pdfStripper.setStartPage(i + 1);
                pdfStripper.setEndPage(i + 1);
                String pageText = pdfStripper.getText(document);

                // Извлечение информации о модели телевизора, количестве и сумме
                String[] lines = pageText.split("\n");
                String model = null;
                int quantity = 0;
                double sum = 0;
                boolean modelFound = false;
                for (String line : lines) {
                    if (!modelFound && line.contains("TV")) {
                        model = line;
                        modelFound = true;
                    } else if (line.contains("St.")) {
                        String[] parts = line.split(" ");
                        quantity = (int) Double.parseDouble(parts[1]); // парсим как double, а затем преобразуем в int

                        // Извлекаем сумму
                        int indexOfEuro = line.indexOf("EUR"); // находим позицию "EUR"
                        int indexOfLastSpace = line.lastIndexOf(" ", indexOfEuro - 1); // находим последний пробел перед "EUR"
                        String sumString = line.substring(indexOfLastSpace + 1, indexOfEuro).trim(); // извлекаем строку между последним пробелом и "EUR"
                        if (!sumString.isEmpty()) { // проверяем, что строка не пустая
                            sum = Double.parseDouble(sumString); // парсим строку как double
                        }
                    }
                }



                // Извлечение информации о получателе
                String recipient = null;
                for (String line : lines) {
                    if (line.startsWith("Käufer:")) {
                        recipient = line.substring(8);
                        break;
                    }
                }

                // Запись данных в Excel
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(model);
                row.createCell(1).setCellValue(quantity);
                row.createCell(2).setCellValue(sum);
                row.createCell(3).setCellValue(recipient);
            }

            try (FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {
                workbook.write(fileOut);
            }
        }
    }
}