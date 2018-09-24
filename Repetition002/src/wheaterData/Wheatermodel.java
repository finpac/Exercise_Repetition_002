package wheaterData;

import java.io.File;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class Wheatermodel extends AbstractListModel
{
    private ArrayList <WheaterValue> wheaterValue;
    
    public Wheatermodel()
    {
        this.wheaterValue = new ArrayList();
    }
    
    void add(WheaterValue w) 
    {
        wheaterValue.add(w);
    }
    
    public String[] getListe() 
    {
        String[] feld = new String[wheaterValue.size()];
        for(int i=0; i < wheaterValue.size(); i++)
        {
        feld[i] = wheaterValue.get(i).getTime()       + " - "  +
                  wheaterValue.get(i).getTemps()      + "° - " +
                  wheaterValue.get(i).getHumidity()+ "% "   ; 
                             
        }
        return feld;
    }

    @Override
    public int getSize() 
    {
        return wheaterValue.size();
    }

    @Override
    public Object getElementAt(int index) 
    {
        return wheaterValue.get(index);
    }
    
    public ArrayList<WheaterValue> getProducts()
    {
        return wheaterValue;
    }

    void save(File file) throws Exception 
    {
        DAL dal = new DAL();
        dal.save(file, wheaterValue);
    }

    void load(File file) throws Exception 
    {
        DAL dal = new DAL();
        wheaterValue = dal.load(file);
    } 
}
