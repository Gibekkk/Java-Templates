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
            if(gap >= columnNames.length)gap /= columnNames.length;
            for(int i = 0; i < dataLength.length; i++){
                dataLength[i] += gap;
            }
            totalDataLength = summarize(dataLength, columnNames.length);
            if(totalDataLength < bannerLength)totalDataLength = bannerLength;
        } 
        if (bannerLength == totalDataLength) {
            gap = 1;
            for(int i = 0; i < dataLength.length; i++){
                dataLength[i] += gap;
            }
            totalDataLength = summarize(dataLength, columnNames.length);
        }
        String titleBanner = "+";
        for (int i = 1; i < totalDataLength; i++) {
            titleBanner += "-";
        }
        titleBanner += "+";
        String dataBanner = "+";
        for (int i = 0; i < dataLength.length; i++) {
            for(int j = 0; j < dataLength[i]; j++){
                dataBanner += "-";
            }
            dataBanner += "+";
        }
        generateTableTitle(tableTitle, totalDataLength, titleBanner);
        generateTableHeader(columnNames, dataLength, gap, dataBanner, centerHeader);
        generateTableData(rowData, dataLength, gap, dataBanner, centerRow);
    }
}
