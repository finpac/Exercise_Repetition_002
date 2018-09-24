
package wheaterData;

public class WheaterValue 
{
    private int temps;
    private int humidity;
    private String time;

    public WheaterValue(int temp, int humidity, String time) 
    {
        this.temps = temp;
        this.humidity = humidity;
        this.time = time;
    }

    public int getTemps() 
    {
        return temps;
    }

    public int getHumidity() 
    {
        return humidity;
    }

    public String getTime() 
    {
        return time;
    }
}
