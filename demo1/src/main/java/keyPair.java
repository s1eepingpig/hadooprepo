import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
public class keyPair implements WritableComparable<keyPair>{

    //IntWritable a = new IntWritable(2);
    private int year;
    private int temperature;
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    //ÖØÐ´ÈçÏÂÈý¸ö·½·¨
    @Override
    public void readFields(DataInput in) throws IOException {
        //Ê¹ÓÃRPCÐ­Òé¶ÁÈ¡¶þ½øÖÆÁ÷£¬·´ÐòÁÐ»¯¹ý³Ì
        this.year = in.readInt();
        this.temperature = in.readInt();
    }
    @Override
    public void write(DataOutput out) throws IOException {
        //Ê¹ÓÃRPCÐ­Òé¶ÁÈ¡¶þ½øÖÆÁ÷£¬ÐòÁÐ»¯¹ý³Ì
        out.writeInt(year);
        out.writeInt(temperature);
    }
    @Override
    public int compareTo(keyPair o) {
        int iRet = Integer.compare(year, o.getYear());
        if(iRet != 0 )
        {
            return iRet;
        }
        return Integer.compare(temperature, o.getTemperature());
    }
    //ÁíÍâ£¬»¹ÐèÖØÐ´tostring
    @Override
    public String toString() {
        return year + "\t" + temperature;
    }
    //ÖØÐ´hashcode
    @Override
    public int hashCode() {
        return new Integer(year+temperature).hashCode();
    }
}
