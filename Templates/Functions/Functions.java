import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.math.BigInteger;

public class Functions extends SideFunctions {
    static Scanner input = new Scanner(System.in);

    public static int inputInt(String prompt) {
        return processInt(prompt, false, 0, false, 0);
    }

    public static int inputInt(String prompt, int min, int max) {
        return processInt(prompt, true, min, true, max);
    }

    public static int inputIntMin(String prompt, int min) {
        return processInt(prompt, true, min, false, 0);
    }

    public static int inputIntMax(String prompt, int max) {
        return processInt(prompt, false, 0, true, max);
    }

    public static int processInt(String prompt, boolean useMin, int min, boolean useMax, int max) {
        print(prompt);
        String teks = input.nextLine();
        if (checkIntInput(teks)) {
            int value = Integer.parseInt(teks);
            if (value < min && value > max && useMin && useMax) {
                println("\n" + numberErrors("lower than min") + min + " And " + numberErrors("higher than max") + max
                        + "!");
            } else if (value < min && useMin) {
                println("\n" + numberErrors("lower than min") + min + "!");
            } else if (value > min && useMax) {
                println("\n" + numberErrors("higher than max") + max + "!");
            } else {
                return value;
            }
        }
        return inputInt(prompt);
    }

    public static void generateTable(String tableTitle, Object[][] rowData, Object[] columnNames, boolean centerHeader, boolean centerRow) {
        int[] dataLength = dataLengthGenerator(rowData, columnNames);
        int totalDataLength = summarize(dataLength, columnNames.length);
        int gap = 0, bannerLength = tableTitle.length();
        if (bannerLength > totalDataLength) {
            gap = (bannerLength - totalDataLength);
            for(int i = 0; i < dataLength.length; i++){
                dataLength[i] += gap;
            }
            totalDataLength = summarize(dataLength, columnNames.length);
        } else if (bannerLength == totalDataLength) {
            gap = 1;
            for(int i = 0; i < dataLength.length; i++){
                dataLength[i] += gap;
            }
            totalDataLength = summarize(dataLength, columnNames.length);
        }
        String titleBanner = "+";
        for (int i = 0; i < totalDataLength - 1; i++) {
            titleBanner += "-";
        }
        titleBanner += "+";
        generateTableTitle(tableTitle, totalDataLength, titleBanner);
        generateTableHeader(columnNames, dataLength, gap, titleBanner, centerHeader);
        generateTableData(rowData, dataLength, gap, titleBanner, centerRow);
    }

    public static void generateTableHeader(Object[] columnNames, int[] dataLength, int gap, String titleBanner, boolean centerHeader) {
        System.out.printf("|");
        for (int i = 0; i < columnNames.length; i++) {
            String columnName = columnNames[i].toString();
            if (centerHeader) {
                System.out.printf((new StringAlignment(dataLength[i], StringAlignment.Alignment.CENTER).format(columnName)) + "|");
            } else{
                System.out.printf("%-" + dataLength[i] + "s|", columnName);
            }
        }
        System.out.printf("%n" + titleBanner + "%n");
    }

    public static void generateTableData(Object[][] rowData, int[] dataLength, int gap, String titleBanner, boolean centerRow) {
        for(int j = 0; j<rowData.length; j++){
            System.out.printf("|");
            for (int i = 0; i < rowData[j].length; i++) {
                Object dataText = rowData[j][i];
                if (centerRow) {
                    System.out.printf((new StringAlignment(dataLength[i], StringAlignment.Alignment.CENTER).format(dataText)) + "|");
                } else{
                    System.out.printf("%-" + dataLength[i] + "s|", dataText);
                }
            }
            System.out.printf("%n" + titleBanner + "%n");
        }
    }

    public static void generateTableTitle(String tableTitle, int totalDataLength, String titleBanner) {
        System.out.printf(titleBanner + "%n");
        System.out.printf("|" + (new StringAlignment(totalDataLength-1, StringAlignment.Alignment.CENTER).format(tableTitle)) + "|\n");
        System.out.printf(titleBanner + "%n");
    }

    public static int[] dataLengthGenerator(Object[][] rowData, Object[] columnNames) {
        int[] dataLength = new int[columnNames.length];
        for (int length = 0; length < columnNames.length; length++) {
            if (columnNames[length] != null) {
                int panjangHeader = columnNames[length].toString().length();
                if (panjangHeader > dataLength[length]) {
                    dataLength[length] = panjangHeader + 4;
                }
            }
        }

        for (int i = 0; i < rowData.length; i++) {
            for (int l = 0; l < columnNames.length; l++) {
                if (rowData[i][l] != null) {
                    int panjangData = rowData[i][l].toString().length();
                    if (panjangData > dataLength[l]) {
                        dataLength[l] = panjangData + 4;
                    }
                }
            }
        }
        return dataLength;
    }
}
