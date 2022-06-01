package com.hadoop;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partition extends Partitioner<keyPair, Text>{

	@Override
	//�Զ����������
	//num��reduce������
	public int getPartition(keyPair key, Text value, int num) {
		//��װ��ݷ�������ݱ�����key��
		//��ݳ��Գ������ڶ�numȡģ
		return (key.getYear() * 127) % num;
	}

	

	

}
