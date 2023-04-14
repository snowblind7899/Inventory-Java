import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    
    //function for writing the csv file
    public static void writeCSV() throws IOException{
        
        FileWriter fw = new FileWriter("Inventory.csv");

        fw.write(String.format("%n"));
        fw.close();
    }
}
