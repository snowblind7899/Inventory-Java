import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private static String[][] values = new String[5][20];
    private static String[] header = {"ID","Weight(kg)","Name of Sender","Name of Reciever","Content Dedscription"};
    private static int index = 0;
    private static FileWriter fw;

    //function for writing the csv file
    public static void writeCSV() throws IOException{
        if(index == 0){
            values[index] = header;
            fw = new FileWriter("Inventory.csv",true);
        } else {
            fw.write(String.format("%n"));
        }
    }
}
