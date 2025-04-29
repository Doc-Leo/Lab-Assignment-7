
public class Main {
    public static void main(String[] args) {
       
        DocumentRegistry registry = new DocumentRegistry();
        
        Document pdfDoc = registry.createPdfDocument("annual_report_2024.pdf", "Acme Corp", 150);
        pdfDoc.open();
        

        Document textDoc = registry.createTextDocument("meeting_notes.txt", "UTF-8", 250);
        textDoc.open();
        
   
        Document spreadsheetDoc = registry.createSpreadsheetDocument("sales_data_q1.xlsx", 1000, 20);
        spreadsheetDoc.open();
        
    
        Document anotherPdfDoc = registry.createPdfDocument("summary_report.pdf", "Acme Corp", 30);
        anotherPdfDoc.open();
    }
}


interface Document extends Cloneable {
    Document clone();
    void open();
    String getType();
}

class DocumentRegistry {
    private PdfDocument pdfPrototype;
    private TextDocument textDocumentPrototype;
    private SpreadsheetDocument spreadsheetPrototype;
    
    public DocumentRegistry() {
        pdfPrototype = new PdfDocument();
        System.out.println("Creating a PDF Document prototype.");
        
        textDocumentPrototype = new TextDocument();
        System.out.println("Creating a Text Document prototype.");
        
        spreadsheetPrototype = new SpreadsheetDocument();
        System.out.println("Creating a Spreadsheet Document prototype.");
    }
    
    public Document createPdfDocument(String name, String author, int pageCount) {
        PdfDocument doc = (PdfDocument) pdfPrototype.clone();
        doc.setFileName(name);
        doc.setAuthor(author);
        doc.setPageCount(pageCount);
        doc.setName(name);
        return doc;
    }
    
    public Document createTextDocument(String filePath, String encoding, int wordCount) {
        TextDocument doc = (TextDocument) textDocumentPrototype.clone();
        doc.setFilePath(filePath);
        doc.setEncoding(encoding);
        doc.setWordCount(wordCount);
        return doc;
    }
    
    public Document createSpreadsheetDocument(String spreadsheetName, int rowCount, int columnCount) {
        SpreadsheetDocument doc = (SpreadsheetDocument) spreadsheetPrototype.clone();
        doc.setSpreadsheetName(spreadsheetName);
        doc.setRowCount(rowCount);
        doc.setColumnCount(columnCount);
        return doc;
    }
    
    public Animal createAnimal(String name) {
        return new Animal(name);
    }
    
   
    public Animal createNew() {
        return new Animal();
    }
    
    public Animal createHorse() {
        return new Animal("Horse");
    }
}


class PdfDocument implements Document {
    private String fileName;
    private String author;
    private int pageCount;
    private String name;
    
    @Override
    public Document clone() {
        PdfDocument doc = new PdfDocument();
        return doc;
    }
    
    @Override
    public void open() {
        System.out.println("Opening PDF Document: " + fileName + " by " + author + " (" + pageCount + " pages)");
        System.out.println("Type: " + getType() + ", File: " + fileName + ", Author: " + author + ", Pages: " + pageCount);
    }
    
    @Override
    public String getType() {
        return "PDF";
    }
    
    // Setters
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}


class TextDocument implements Document {
    private String filePath;
    private String encoding;
    private int wordCount;
    
    @Override
    public Document clone() {
        TextDocument doc = new TextDocument();
        return doc;
    }
    
    @Override
    public void open() {
        System.out.println("Opening Text Document: " + filePath + " with encoding: " + encoding + " (" + wordCount + " words)");
        System.out.println("Type: " + getType() + ", Path: " + filePath + ", Encoding: " + encoding + ", Words: " + wordCount);
    }
    
    @Override
    public String getType() {
        return "Text";
    }
    
   
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}


class SpreadsheetDocument implements Document {
    private String spreadsheetName;
    private int rowCount;
    private int columnCount;
    
    @Override
    public Document clone() {
        SpreadsheetDocument doc = new SpreadsheetDocument();
        return doc;
    }
    
    @Override
    public void open() {
        System.out.println("Opening Spreadsheet Document: " + spreadsheetName + " (" + rowCount + " rows, " + columnCount + " columns)");
        System.out.println("Type: " + getType() + ", Name: " + spreadsheetName + ", Rows: " + rowCount + ", Columns: " + columnCount);
    }
    
    @Override
    public String getType() {
        return "Spreadsheet";
    }
    
 
    public void setSpreadsheetName(String spreadsheetName) {
        this.spreadsheetName = spreadsheetName;
    }
    
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
    
    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
}


class ProcessedDocument {
    
}


class Animal {
    private String name;
    
    public Animal() {
        this.name = "Unknown";
    }
    
    public Animal(String name) {
        this.name = name;
    }
}
