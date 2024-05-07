public class SideFunctions extends Checkers{
    public static int summarize(int ... values){
        int total = 0;
        for(int num : values){
            total += num;
        }
        return total;
    }

    public static int summarize(int[] value1, int ... values){
        int total = 0;
        for(int num1 : value1){
            total += num1;
        }
        for(int num : values){
            total += num;
        }
        return total;
    }

    public static int summarize(int[] ... values){
        int total = 0;
        for(int[] nums : values){
            for(int num : nums){
                total += num;
            }
        }
        return total;
    }
    
    public static void generateTableHeader(Object[] columnNames, int[] dataLength, int gap, String titleBanner, boolean centerHeader) {
        System.out.printf(titleBanner + "%n");
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
