package wheaterData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class DAL 
{
    private ArrayList<WheaterValue> weatherValue = new ArrayList();
    private boolean isValue = true;
    public void save(File file, ArrayList<WheaterValue> wet) throws FileNotFoundException
    {
        int count = 0;
        PrintWriter pw = new PrintWriter(file);
        for(WheaterValue w : wet)
        {
            pw.println(w.getTemps());
            pw.println(w.getHumidity());
            pw.println(w.getTime()); 
        }
        ++count;
        pw.close();
    }

    public ArrayList<WheaterValue> load(File file) throws Exception 
    {
        Scanner scan = new Scanner(file);
        String tmp = "";
        int counter = 1;
        int temp = 0, luft = 0;
        String zeit = "";
        while(scan.hasNext())
        {
            tmp = scan.nextLine();
            if(counter == 1)//Temp
            {
                temp = Integer.parseInt(tmp);
                ++counter;
            }
            
            else if(counter == 2)//Humidity
            {
                luft = Integer.parseInt(tmp);
                ++counter;
            }
            
            else if(counter == 3)//Date
            {
                zeit = tmp;
                ++counter;
                isValue = false;
            }

            if(isValue == false)
            {
                WheaterValue wett = new WheaterValue(temp,luft,zeit);
                weatherValue.add(wett);
                isValue = true;
                counter = 1;
            }
        }
        scan.close();
        return weatherValue;
    }
    
}
