
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private static String[] header = {"ID","Weight(kg)","Name of Sender","Name of Reciever","Description of Contents"};
    private static int index = 0;
    private static FileWriter fw;

    //function for writing the csv file
    public static void writeCSV(String[] values) throws IOException{
        fw = new FileWriter("Inventory.csv",true);
        
        if(index == 0){
            for(int i = 0; i<header.length;i++){
                fw.write(header[i]+","); 
            }
            fw.write(String.format("%n"));
            index++;
        } 
        
        for(int i = 0; i<values.length;i++){
            fw.write(values[i]+",");
        }
        fw.write(String.format("%n"));
        fw.close();
    }
}
