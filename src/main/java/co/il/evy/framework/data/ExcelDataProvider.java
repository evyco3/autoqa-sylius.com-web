package co.il.evy.framework.data;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public final class ExcelDataProvider {
    private final static String filePath = "C:\\Users\\evyco\\IdeaProjects\\sylius.com-web\\src\\main\\resources\\Book1.xlsx";

    private ExcelDataProvider() {
    }

    @org.testng.annotations.DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        return getData("login");
    }

    @org.testng.annotations.DataProvider(name = "registrationData")
    public static Object[][] getRegistrationData() {
        return getData("register");
    }

    @org.testng.annotations.DataProvider(name = "dropdownData")
    public static Object[][] getDropdownData() {
        return getData("dropdown");
    }

    @org.testng.annotations.DataProvider(name = "addReviewToProductData")
    public static Object[][] getAddToReviewData() {
        return getData("addReviewToProduct");
    }

    @org.testng.annotations.DataProvider(name = "productSizeData")
    public static Object[][] getProductData() {
        return getData("productSize");
    }

    @DataProvider(name = "productQuantity")
    public static Object[][] getProductQuantity() {
        return getData("productQuantity");
    }

    private static Object[][] getData(String sheetName) {
        System.out.println(filePath);
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int numRows = sheet.getPhysicalNumberOfRows();
            int numCols = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[][] data = new Object[numRows - 1][numCols];

            for (int i = 1; i < numRows; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < numCols; j++) {
                        Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        data[i - 1][j] = cell.toString();
                    }
                }
            }
            return data;
        } catch (IOException e) {
            System.err.println("Error reading Excel file. Exception details: " + e.getMessage());

            throw new RuntimeException("Error reading Excel file", e.getCause());
        }
    }
}

