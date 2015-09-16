import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: tivesoft
 * Date: 9/15/15
 * Time: 17:45
 */
public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("==================================================");
        System.out.println("==================================================");
        obj.runNodes();
        System.out.println("==================================================");
        System.out.println("==================================================");
        obj.runData();
    }

    public void runNodes() {
        String csvFile = "nodes.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int index = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] nodes = line.split(cvsSplitBy);
                String nodeName = nodes[0];
                String sas = String.format("{\"name\":\"%s\",\"group\":%d},", nodeName, index);
                System.out.println(sas);
                index++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void runData() {
        String csvFile = "data.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(cvsSplitBy);

                for (int column = 0; column < columns.length; column++) {
                    int value = Integer.parseInt(columns[column]);
                    if (value > 0) {
                        String sas = String.format("{\"source\":%d,\"target\":%d,\"value\":%d},", row, column, value);
                        System.out.println(sas);
                    }
                }
                row++;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
