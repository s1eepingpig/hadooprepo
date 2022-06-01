import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partition extends Partitioner<keyPair, Text>{

    @Override
    //×Ô¶¨Òå·ÖÇø·½·¨
    //numÊÇreduceµÄÊýÁ¿
    public int getPartition(keyPair key, Text value, int num) {
        //°²×°Äê·Ý·ÖÇø£¬Äê·Ý±£´æÔÚkeyÖÐ
        //Äê·Ý³ËÒÔ³£Êý£¬ÔÚ¶ÔnumÈ¡Ä£
        return (key.getYear() * 127) % num;
    }





}
