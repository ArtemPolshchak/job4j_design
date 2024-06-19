package ru.job4j;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitPDFPages {

    int numberOfPage = 80;
    public static void main(String[] args) {
        try {

            String filePath = "C:\\projects\\PDFDOCUMENTS\\Invoices_23-05-2024.pdf";
            // Загрузка PDF-документа
            PDDocument document = PDDocument.load(new File(filePath));

            // Создание объекта PDFTextStripper
            PDFTextStripper pdfStripper = new PDFTextStripper();
            int newDocumentNumber = 80;
            // Проход по каждой странице документа
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                // Извлечение текста с текущей страницы
                pdfStripper.setStartPage(i + 1);
                pdfStripper.setEndPage(i + 1);
                String text = pdfStripper.getText(document);

                // Парсинг текста для поиска номера документа
                String documentNumber = parseDocumentNumber(text);

                // Создание нового PDF-документа для текущей страницы
                PDDocument newDocument = new PDDocument();
                newDocument.addPage(document.getPage(i));

                // Сохранение PDF-документа с учетом номера документа в имени файла
                newDocument.save(new File("C:\\projects\\PDFDOCUMENTS\\" + documentNumber + "-4-2024.pdf"));
               // newDocument.save(new File("C:\\projects\\PDFDOCUMENTS\\" + String.valueOf(newDocumentNumber++) +"-4-2024.pdf"));
                newDocument.close();
            }

            // Закрытие исходного PDF-документа
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для парсинга текста и извлечения номера документа
    private static String parseDocumentNumber(String text) {
        // Регулярное выражение для поиска номера документа
        String regex = "\\b(\\d+)/(\\d+)/(\\d+)\\b";

        // Компиляция регулярного выражения
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Поиск совпадений
        if (matcher.find()) {
            // Возвращаем первые цифры перед первым знаком "/"
            return matcher.group(1);
        } else {
            return "Номер документа не найден";
        }
    }



//    public static void main(String[] args) {
//        String filePath = "C:\\projects\\PDFDOCUMENTS\\Invoices_06-04-2024-350.pdf";
//        File file = new File(filePath);
//
//        try {
//            PDDocument document = PDDocument.load(file);
//            for (int i = 0; i < document.getNumberOfPages(); i++) {
//                PDDocument singlePageDocument = new PDDocument();
//                singlePageDocument.addPage(document.getPage(i));
//                String outputFileName = "C:\\projects\\PDFDOCUMENTS\\output_" + (i + 1) + ".pdf";
//                singlePageDocument.save(outputFileName);
//                singlePageDocument.close();
//                System.out.println("Page " + (i + 1) + " saved as " + outputFileName);
//            }
//            document.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//


}
