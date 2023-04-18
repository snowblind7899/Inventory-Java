import java.io.FileWriter;
import java.io.IOException;

//class for writing the csv file
public class CsvWriter {
    private static String[] header = {"ID","Weight(kg)","Name of Sender","Name of Reciever","Description of Contents"};
    private static int headerWritten = 0;
    private static FileWriter fw;

    //appends item data to a csv file
    public static void writeCSV(String[] values) throws IOException{
        fw = new FileWriter("Inventory.csv",true);

        //initial write, creates headers in the csv file
        if(headerWritten == 0){
            for(int i = 0; i<header.length;i++){
                fw.write(header[i]+","); 
            }
            fw.write(String.format("%n"));
            headerWritten++;
        } 
        
        for(int i = 0; i<values.length;i++){
            fw.write(values[i]+",");
        }
        fw.write(String.format("%n"));
        fw.close();
    }
}
